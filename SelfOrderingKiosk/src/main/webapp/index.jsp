<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-color: #f0f0f0;
    }
    .button-container {
      text-align: center;
    }
    button {
      background-color: #4CAF50;
      color: white;
      border: none;
      padding: 15px 30px;
      margin: 10px;
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
  </style>
</head>
<body>
<div class="button-container">
  <button onclick="window.location.href='dine_in.jsp'">DINE IN</button>
  <button onclick="window.location.href='take_away.jsp'">TAKE AWAY</button>
</div>
</body>
</html>
