<%@page import="demo.model.Register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
html {
  height: 100%;
}
body {
  margin:0;
  padding:0;
  font-family: sans-serif;
  background: linear-gradient(#141e30, #243b55);
}

.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: rgba(0,0,0,.5);
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0,0,0,.6);
  border-radius: 10px;
}

.login-box h1 {
  margin: 0 0 30px;
  padding: 0;
  color: #1caca4;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}
.btn{
    display: inline-block;
    padding: 14px 40px;
    border-radius: 0.5rem;
    font-size: 17px;
    font-weight: 500;
    background: #1caca4;
    color:#fff;
    border: 1px solid #1caca4;;
    transition: all .40s ease;
}
.btn:hover{
    transform: scale(1.01) translateY(-5px);
    background: transparent;
    border: 1px solid #1caca4;;
}
</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="login-box">
	<form action="SearchController">
	<h1>Search Record</h1>
		<div class="user-box">
<input type="text" placeholder="Registration Number" name="regNo">
</div>
<button class="btn" input type="submit" >Search</button>
	</form>

</div>

</body>
</html>