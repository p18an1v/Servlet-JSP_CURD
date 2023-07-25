<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
*{
    padding:0;
    margin:0;
    box-sizing: border-box;
    font-family: 'Quicksand', sans-serif;
    list-style: none;
    text-decoration: none;
    scroll-behavior: smooth;
}
:root{
    --bg-color:#020312;
    --text-color:#fff;
    --main-color:#1caca4;
    --second-color:gray;
    --other-color:#12141c;
    --h1-font: 5.2rem;
    --h2-font:3.5rem;
    --p-font:1.1rem;
}
body{
    background-color: #020312;
    color: #fff;
}
header{
    position: fixed;
    right: 0;
    top: 0;
    width: 100%;
    z-index: 1000;
    display: flex;
    align-items: center;
    justify-content: space-between;
    background:transparent;
    padding: 22px 16%;
    border-bottom: 1px solid transparent;
    transition: all .40 ease;
}
.logo img{
    width: 175px;
    height: auto;
}
.navbar{
    display: flex;
}
.navbar a{
    color:gray;
    font-size: 1.1rem;
    font-weight: 600;
    padding: 10px 25px;
    margin: 0 2px;
    border-radius: 0.5rem;
    transition: all .40 ease;
}
.navbar a:hover{
    background:#1caca4;
    color: #fff;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
<a href="#" class="logo"><img src="logo.png"></a>
<div class="bx bx-menu" id="menu-icon"></div>

<ul class="navbar">
<li><a href="RegisterView.jsp">Registration</a><li>
<li><a href="login.jsp">Login</a><li>
<li><a href="search.jsp">SearchRecord</a><li>
<li><a href="delete.jsp">DeleteRecord</a><li>
<li><a href="DisplayServlet.jsp">DisplayAll</a><li>
</ul>
</header>
</body>
</html>