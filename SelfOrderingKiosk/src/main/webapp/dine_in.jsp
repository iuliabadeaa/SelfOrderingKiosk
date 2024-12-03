<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String activeSection = (String) request.getAttribute("activeSection");
%>
<html>
<head>
    <title>Dine in menu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .menu-bar {
            width: 200px;
            background-color: #f4f4f4;
            position: fixed;
            height: 100%;
            box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
        }
        .menu-bar ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }
        .menu-bar ul li {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        .menu-bar ul li a {
            text-decoration: none;
            color: #333;
            display: block;
        }
        .menu-bar ul li a:hover {
            background-color: #ddd;
            color: #000;
        }
        .content {
            margin-left: 220px;
            padding: 20px;
        }
    </style>
</head>
<body>
<div class="menu-bar">
    <ul>
        <li><a href="dine_in?section=oferte">Oferte</a></li>
        <li><a href="dine_in?section=meniuri">Meniuri</a></li>
        <li><a href="dine_in?section=deserturi">Deserturi</a></li>
        <li><a href="dine_in?section=bauturi">Băuturi</a></li>
        <li><a href="dine_in?section=sandwich-uri">Sandwich-uri</a></li>
    </ul>
</div>
<div class="content">
    <% if ("oferte".equals(activeSection)) { %>
    <h2>Oferte</h2>
    <p>Aici se afișează meniul cu oferte speciale.</p>
    <% } else if ("meniuri".equals(activeSection)) { %>
    <h2>Meniuri</h2>
    <p>Aici se afișează lista meniurilor disponibile.</p>
    <% } else if ("deserturi".equals(activeSection)) { %>
    <h2>Deserturi</h2>
    <p>Aici se afișează lista deserturilor.</p>
    <% } else if ("bauturi".equals(activeSection)) { %>
    <h2>Băuturi</h2>
    <p>Aici se afișează lista băuturilor disponibile.</p>
    <% } else if ("sandwich-uri".equals(activeSection)) { %>
    <h2>Sandwich-uri</h2>
    <p>Aici se afișează lista sandwich-urilor.</p>
    <% } %>
</div>
</body>
</html>
