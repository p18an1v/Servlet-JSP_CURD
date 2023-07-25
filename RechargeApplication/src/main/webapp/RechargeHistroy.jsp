<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
                   <%@page import="java.util.Date" %>
           <%@page import="com.controller.RechargeHistoryController" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
	<link rel="stylesheet1" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script></head></head>
<body  style="background-color:#c0c0c0">
<form action="HistoryController">

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="Home.jsp">Home</a></li>
        <li><a href="#"></a></li>
        		<li><a href="#"></a></li>
        		<li><a href="#"></a></li>
        
        <li style="color:white"><%=new Date() %></li>
       </ul>
     
    </div>
  </div>
</nav>
            	<br>

           		 <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Users</h3>
                    
                    <hr>
                    
                    <br>
                     
                    <table class="table table-bordered" >
                        <thead>
                            <tr style="background-color: #6c757d"
                            style="text-color: #f8f9fa">
                                <th >Mob-No</th>
                                <th>State</th>
                                <th>Date</th>
                                <th>Plan</th>
                                <th>Operator</th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${listUser}">

                                <tr>
                                    <td>
                                    
                                        <c:out value="${user.mobno}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.state}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.date}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.plan}" />
                                    </td>
                                    
                                     <td>
                                        <c:out value="${user.operator}" />
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
</form>
</body>
</html>