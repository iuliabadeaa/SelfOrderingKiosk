<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
            flex: 3;
            padding: 20px;
        }
        .content-container {
            display: flex;
            justify-content: space-between;
            margin-left: 220px;
        }
        .cart {
            flex: 1;
            background-color: #f9f9f9;
            padding: 20px;
            border-left: 1px solid #ddd;
            box-shadow: -2px 0 5px rgba(0, 0, 0, 0.1);
        }

        .cart h2 {
            font-size: 18px;
            margin-bottom: 10px;
            color: #4CAF50;
        }
        .quantity-input {
            width: 50px;
            height: 30px;
        }
        .add-to-cart {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            margin: 10px;
            font-size: 16px;
            border-radius: 8px;
            cursor: pointer;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.2);
            transition: transform 0.2s, box-shadow 0.2s;
        }
        .add-to-cart:hover {
            transform: scale(1.1);
            box-shadow: 0px 6px 10px rgba(0, 0, 0, 0.3);
        }
        .add-to-cart:active {
            transform: scale(1.05);
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
        }
        #cart-items {
            list-style: none;
            padding: 0;
        }

        #cart-items li {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        #discount{
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
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
<div class="content-container">
<div class="content">
    <% if ("oferte".equals(activeSection)) { %>
    <h2>Oferte</h2>
    <div class="meniu_oferte">
        <c:forEach var="product" items="${products}">
            <c:if test="${product.category == 'Oferte'}">
            <div class="row">
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

                <div>
                    <form action="add_to_cart" method="post">
                        <input type="hidden" name="productName" value="${product.name}">
                        <input type="hidden" name="productPrice" value="${product.price}">
                        <input type="number" name="quantity" class="quantity-input" min="1" value="1">
                        <button class="add-to-cart" type="submit">ADD TO CART</button>
                    </form>
                </div>

                <br>
                <br>
            </div>
            </c:if>
        </c:forEach>
    </div>
    <% } else if ("meniuri".equals(activeSection)) { %>
    <h2>Meniuri fast food</h2>
    <div class="meniuri">
        <c:forEach var="product" items="${products}">
            <c:if test="${product.category == 'Meniuri'}">
                <div class="row">
                    <div>
                        <img src="${product.image}" alt="${product.name}" style="width: 200px; height: auto;">
                    </div>
                    <div class="column">
                            ${product.name}
                    </div>
                    <div>
                            ${product.description}
                    </div>
                    <div>
                            ${product.price}
                    </div>

                    <div>
                        <form action="add_to_cart" method="post">
                            <input type="hidden" name="productName" value="${product.name}">
                            <input type="hidden" name="productPrice" value="${product.price}">
                            <input type="number" name="quantity" class="quantity-input" min="1" value="1">
                            <button class="add-to-cart" type="submit">ADD TO CART</button>
                        </form>
                    </div>

                    <br>
                    <br>
                </div>
            </c:if>
        </c:forEach>
    </div>

    <% } else if ("deserturi".equals(activeSection)) { %>
    <h2>Deserturi</h2>
    <div class="meniuri">
        <c:forEach var="product" items="${products}">
            <c:if test="${product.category == 'Deserturi'}">
                <div class="row">
                    <div>
                        <img src="${product.image}" alt="${product.name}" style="width: 200px; height: auto;">
                    </div>
                    <div class="column">
                            ${product.name}
                    </div>
                    <div>
                            ${product.description}
                    </div>
                    <div>
                            ${product.price}
                    </div>

                    <div>
                        <form action="add_to_cart" method="post">
                            <input type="hidden" name="productName" value="${product.name}">
                            <input type="hidden" name="productPrice" value="${product.price}">
                            <input type="number" name="quantity" class="quantity-input" min="1" value="1">
                            <button class="add-to-cart" type="submit">ADD TO CART</button>
                        </form>
                    </div>

                    <br>
                    <br>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <% } else if ("bauturi".equals(activeSection)) { %>
    <h2>Băuturi</h2>
    <div class="meniuri">
        <c:forEach var="product" items="${products}">
            <c:if test="${product.category == 'Bauturi'}">
                <div class="row">
                    <div>
                        <img src="${product.image}" alt="${product.name}" style="width: 200px; height: auto;">
                    </div>
                    <div class="column">
                            ${product.name}
                    </div>
                    <div>
                            ${product.description}
                    </div>
                    <div>
                            ${product.price}
                    </div>

                    <div>
                        <form action="add_to_cart" method="post">
                            <input type="hidden" name="productName" value="${product.name}">
                            <input type="hidden" name="productPrice" value="${product.price}">
                            <input type="number" name="quantity" class="quantity-input" min="1" value="1">
                            <button class="add-to-cart" type="submit">ADD TO CART</button>
                        </form>
                    </div>

                    <br>
                    <br>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <% } else if ("sandwich-uri".equals(activeSection)) { %>
    <h2>Sandwich-uri</h2>
    <div class="meniuri">
        <c:forEach var="product" items="${products}">
            <c:if test="${product.category == 'Sandwich-uri'}">
                <div class="row">
                    <div>
                        <img src="${product.image}" alt="${product.name}" style="width: 200px; height: auto;">
                    </div>
                    <div class="column">
                            ${product.name}
                    </div>
                    <div>
                            ${product.description}
                    </div>
                    <div>
                            ${product.price}
                    </div>

                    <div>
                        <form action="add_to_cart" method="post">
                            <input type="hidden" name="productName" value="${product.name}">
                            <input type="hidden" name="productPrice" value="${product.price}">
                            <input type="number" name="quantity" class="quantity-input" min="1" value="1">
                            <button class="add-to-cart" type="submit">ADD TO CART</button>
                        </form>
                    </div>

                    <br>
                    <br>
                </div>
            </c:if>
        </c:forEach>
    </div>    <% } %>
</div>
<div class="cart">
    <h3>Comanda dumneavoastră</h3>
    <ul>
        <c:forEach var="item" items="${sessionScope.cart}">
            <li>
                    ${item.name} - ${item.quantity} x ${item.price} =
                <strong>${item.quantity * item.price}</strong>
            </li>
        </c:forEach>
    </ul>
    <c:if test="${not empty sessionScope.cart}">
        <strong>Total:</strong>
        <c:if test="${not empty total}">
            <fmt:formatNumber value="${total}" type="number" maxFractionDigits="2" minFractionDigits="2" />
        </c:if>

        <c:if test="${not empty errorMessage}">
            <div style="color: red;">${errorMessage}</div>
        </c:if>
        <div>
            <form action="${pageContext.request.contextPath}/ApplyDiscount" method="post">
                <input type="hidden" name="total" value="${total}" />
                <input type="text" id="discount" name="discountCode" placeholder="Introduceți codul de reducere">
                <button class="add-to-cart" type="submit">APLICĂ CODUL</button>
            </form>
            <form action="place_order" method="post">
                <input type="hidden" name="total" value="${formattedTotal}" />
                <button class="add-to-cart" type="submit">PLACE ORDER</button>
            </form>
        </div>
    </c:if>

</div>
</div>
</body>
</html>
