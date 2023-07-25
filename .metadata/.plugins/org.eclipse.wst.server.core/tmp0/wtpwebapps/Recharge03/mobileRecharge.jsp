<%@ page import="com.entity.login" %>
<%@ page import="com.entity.account" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mobile Recharge</title>
</head>
<body>
    <div class="form">
        <%
        login l = (login) session.getAttribute("login");
        %>
    </div>
    <br>
    
    <% 
    if (l != null) {
        int accNo = l.getAccNo();
    %>
    
   <form action="mobileRecharge">
        <label for="cname">Enter Phone Number:</label>
        <input type="text" name="phoneNo">
        <br>
        <label for="uname">Enter Recharge Amount:</label>
        <input type="text" name="recAmt">
        <br>
        <label for="accno">Enter Service Provider:</label>
        <input type="text" name="service_provider">
        <br>
        <input type="hidden" name="accNo" value="<%=accNo%>">
        <input type="submit" value="Recharge">
        <br>
    </form>
    <% } %>
</body>
</html>
