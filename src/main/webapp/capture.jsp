<%-- 
    Document   : order
    Created on : Sep 16, 2017, 7:53:12 AM
    Author     : rfteves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Confirmation <%=(String) session.getAttribute("order-id")%></title>
    </head>
    <style>
        body {
            background-image: url("https://tools.gotkcups.com/orders/logo.png");
        }
    </style>

    <body>
        "order_id": "<%=(String) session.getAttribute("order-id")%>"<br>
        "email": "<%=(String) session.getAttribute("email")%>"<br>
        "delivery_country": "US"<br>
        "estimated_delivery_date": "<%=(String) session.getAttribute("delivery-date")%>"<br>

    </body>
</html>
