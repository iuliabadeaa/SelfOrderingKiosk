<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <style>
        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 15px 30px;
            font-size: 18px;
            border-radius: 8px;
            cursor: pointer;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.2);
            transition: transform 0.2s, box-shadow 0.2s;
            width: 100%;
            max-width: 300px;
        }
        button:hover {
            transform: scale(1.1);
            box-shadow: 0px 6px 10px rgba(0, 0, 0, 0.3);
        }
        button:active {
            transform: scale(1.05);
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
<footer>
    <form action="${pageContext.request.contextPath}/Logout" method="post">
        <button class="btn btn-lg btn-primary btn-block" type="submit">LOGOUT</button>
    </form>
</footer>
</body>
</html>
