/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gotkcups.orders;

import com.gotkcups.io.GateWay;
import com.gotkcups.io.RestHttpClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

/**
 *
 * @author rfteves
 */
public class Confirmation extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    String param = request.getParameter("order-id");
    String json = GateWay.getOrder("prod", Long.parseLong(param));
    Document d = Document.parse(json);
    Document order = (Document) d.get("order");
    request.getSession().setAttribute("order-id", order.getString("name"));
    request.getSession().setAttribute("order_status_url", order.getString("order_status_url"));
    request.getSession().setAttribute("email", order.getString("email"));
    request.getSession().setAttribute("delivery-date", getDeliveryDate());
    if (true) {
      response.sendRedirect("/orders/confirmed.jsp");
    } else {
      String resp = RestHttpClient.processGet(order.getString("order_status_url"));
      try (
        PrintWriter out = response.getWriter()) {
        /*out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Confirmation</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Confirmation at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");*/
        out.println(resp);
        out.flush();
      }
    }
  }

  private String getDeliveryDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar now = Calendar.getInstance();
    int working = 0;
    boolean added = false;
    while (working < 5) {
      added = false;
      now.add(Calendar.DATE, 1);
      if (now.get(Calendar.DAY_OF_WEEK) > 1 && now.get(Calendar.DAY_OF_WEEK) < 7) {
        ++working;
        added = true; 
      }
      if (added && (now.get(Calendar.DAY_OF_WEEK) == 1 || now.get(Calendar.DAY_OF_WEEK) == 7)) {
        --working;
      }
    }
    return sdf.format(now.getTime());
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
