<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  /* CSS styles */
  body {
  	background: linear-gradient(to top, rgba(0,0,0,0.5)50%,rgba(0,0,0,0.5)50%), url(1.jpg);
    font-family: Arial, sans-serif;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    background-color: rgb(68, 75, 81);
    width: 100%;
    background-position: center;
    background-size: cover;
  }

  input[type="submit"] {
    padding: 10px 20px;
    background-color: #ff7200;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  .rech{
  font-size: 3rem;
  color: aliceblue;
  }
  .back{
    color: aliceblue;
    margin-top: 20px;
  }
</style>
</head>
<body>
<div class="rech">
Recharge Successful!<br>
</div>
<div class="back">
    Back to login...
</div>
<br><br>
<input type="submit" value="Login">
</body>
</html>
