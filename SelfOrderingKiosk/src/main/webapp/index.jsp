<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Start page</title>
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
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .button-container img {
      width: 100px;
      height: auto;
      margin-right: 20px;
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

    .adminbtn {
      background-image: url('images/user.png');
      background-size: contain;
      background-position: center;
      background-repeat: no-repeat;
      border: none;
      width: 30px;
      height: 30px;
      cursor: pointer;
      color: white;
      text-align: center;
      line-height: 50px;
    }

    footer {
      display: flex;
      justify-content: center;
      align-items: center;
      padding: 20px;
      color: white;
      position: fixed;
      bottom: 0;
      left: 0;
      width: 100%;
    }

  </style>
</head>
<body>
<div class="button-container">

  <img src="images/plate-utensils.png" alt="Dine In">
  <button onclick="window.location.href='/SelfOrderingKiosk-1.0-SNAPSHOT/dine_in?section=oferte'">DINE IN</button>

  <img src="images/grocery-bag.png" alt="Take Away">
  <button onclick="window.location.href='/SelfOrderingKiosk-1.0-SNAPSHOT/take_away?section=oferte'">TAKE AWAY</button>

  <footer>
  <button class="adminbtn" onclick="window.location.href='/SelfOrderingKiosk-1.0-SNAPSHOT/login.jsp'"></button>
  </footer>
</div>
</body>
</html>
