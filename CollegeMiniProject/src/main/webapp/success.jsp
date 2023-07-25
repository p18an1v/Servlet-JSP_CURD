<%@page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.Date" %>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Recharge Successful</title>
<style>
body {
  font-family: sans-serif;
  font-size: 16px;
  margin: 0;
  padding: 0;
}

.container {
  width: 500px;
  margin: 0 auto;
}

.message {
  padding: 20px;
  background-color: #d9edf7;
  border-radius: 10px;
  margin-top: 20px;
}

.message h1 {
  font-size: 24px;
  margin-bottom: 10px;
}

.message p {
  margin-bottom: 10px;
}

.message button {
  background-color: #337ab7;
  color: white;
  font-size: 16px;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
}
</style>
</head>
<body>
<div class="container">
  <div class="message">
    <h1>Order is Successful</h1>
    <p>Your book will be delivered as soon as possible.</p>
    <button onclick="window.location.href='BookDownloader.jsp'">Back to Home</button>

  </div>
</div>
</body>
</html>
