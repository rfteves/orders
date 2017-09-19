<%-- 
    Document   : confirmed
    Created on : Sep 16, 2017, 7:39:43 AM
    Author     : rfteves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Confirmation <%=(String) session.getAttribute("order-id")%></title>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"
                integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
                crossorigin="anonymous"></script>
    </head>
    <frameset border="0" rows="45%,55%">
        <frame id="hi_bar" name="hi_bar" src="/orders/gcr.jsp">
        <frame src="<%=(String)session.getAttribute("order_status_url")%>">
    </frameset>
</html>
