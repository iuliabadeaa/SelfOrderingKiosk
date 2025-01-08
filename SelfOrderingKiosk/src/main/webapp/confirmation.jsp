<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Confirmation</title>
    <style>
        .notification {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #4CAF50;
            color: white;
            padding: 20px 40px;
            border-radius: 10px;
            font-size: 100px;
            text-align: center;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
<%
    String orderNumber = (String) request.getAttribute("orderNumber");
%>
<div class="notification">
    Order <span><%= orderNumber != null ? orderNumber : "unknown" %></span> placed successfully!
</div>

<script>
    setTimeout(() => {
        window.location.href = 'index.jsp';
    }, 6000);
</script>
</body>
</html>
