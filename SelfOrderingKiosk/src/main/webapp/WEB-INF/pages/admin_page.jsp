<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String activeSection = (String) request.getAttribute("activeSection");
%>
<html>
<head>
    <title>Admin Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            display: inline-block;
            white-space: nowrap;
            font-size: 18px;
            border-radius: 8px;
            cursor: pointer;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.2);
            transition: transform 0.2s, box-shadow 0.2s;
        }
        button:hover {
            transform: scale(1.1);
            box-shadow: 0px 6px 10px rgba(0, 0, 0, 0.3);
        }
        button:active {
            transform: scale(1.05);
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
        }
        footer {
            background-color: white;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            bottom: 0;
            width: 100%;
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
        .delete{
            background: darkred;
        }
    </style>
</head>
<body>

<div class="menu-bar">
    <ul>
        <li><a href="AdminPage?section=add_products">Adauga produse</a></li>
        <li><a href="AdminPage?section=modify_products">Modifica produse</a></li>
        <li><a href="AdminPage?section=delete_products">Sterge produse</a></li>
        <li><a href="AdminPage?section=see_orders">Vezi comenzile</a></li>
    </ul>
</div>


<div class="content">
    <% if ("add_products".equals(activeSection)) { %>
    <h2>Add products</h2>
    <% } else if ("modify_products".equals(activeSection)) { %>
    <h2>Modifica produse</h2>
    <% } else if ("delete_products".equals(activeSection)) { %>
    <h2>Sterge produse</h2>
    <form method="post" action="${pageContext.request.contextPath}/AdminPage">
        <button class="delete" type="submit">DELETE</button>
<div>
    <c:forEach var="product" items="${products}">
            <div class="row">
                <div>
                       <input type="checkbox" name="products_ids" value="${product.id}">
                </div>
                <div>
                    <img src="${product.image}" alt="${product.name}" style="width: 200px; height: auto;">
                </div>
                <div >
                        ${product.name}
                </div>
                <div>
                        ${product.description}
                </div>
                <div>
                        ${product.price}
                </div>

                <br>
                <br>
            </div>
    </c:forEach>
</div>
</form>

    <% } else if ("see_orders".equals(activeSection)) { %>
    <h2>Vezi comenzile</h2>
    <% } %>
</div>

<footer>
    <form action="${pageContext.request.contextPath}/Logout" method="post">
        <button class="btn btn-lg btn-primary btn-block" type="submit">LOGOUT</button>
    </form>
</footer>
</body>
</html>
