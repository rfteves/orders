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
        <style>
            body {
                background-image: url("https://tools.gotkcups.com/orders/logo.png");
            }
        </style>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<script>
		function loaded() {
			setTimeout(function(){ beginCheck(); }, 3000);
		}
		function beginCheck() {
			setInterval(function(){ checkId(); }, 400);
		}
		function checkId() {
			if (document.getElementsByTagName("iframe").length == 0) {
parent.document.getElementsByTagName( 'frameset' )[ 0 ].rows = '0,*' ;			
}
		}
	</script>
    </head>
    <body onload="loaded();">
        <script src="https://apis.google.com/js/platform.js?onload=renderOptIn" async defer></script>

        <script>
            window.renderOptIn = function () {
                window.gapi.load('surveyoptin', function () {
                    window.gapi.surveyoptin.render(
                            {
                                "merchant_id": 111796838,
                                "order_id": "<%=(String) session.getAttribute("order-id")%>",
                                "email": "<%=(String) session.getAttribute("email")%>",
                                "delivery_country": "US",
                                "estimated_delivery_date": "<%=(String) session.getAttribute("delivery-date")%>"
                            });
                });
            }
        </script>
        <!-- BEGIN GCR Language Code -->
        <script>
            window.___gcfg = {
                lang: 'en_US'
            };
        </script>
        <!-- END GCR Language Code -->
    </body>
</html>
