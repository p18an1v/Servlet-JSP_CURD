<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
           <%@page import="java.util.Date" %>
           <%@page import="com.model.Register" %>
           <%@page import="com.dao.RegisterDao" %>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">

<title>Home page</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#c0c0c0">

	<%
	 	Register r = (Register) session.getAttribute("user");
	
	 	RegisterDao rd = new RegisterDao();
		Register reg = null;
		
		if (r != null) {
			reg = rd.displayRecord(r.getMobno());
			session.setAttribute("user", reg);
		}


	%>
         
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">UserManager</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="Home.jsp">Home</a></li>
       
        <li><a href="Recharge.jsp">Recharge</a></li>
        <li><a href="RechargeHistory.jsp">Recharge History</a></li>
		<li><a href="Wallet.jsp">Wallet</a></li>
		
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li class="btn btn-outline-success"><a class="d-flex" href="#!" data-toggle="modal" data-target="#ProfileModal">Profile</a></li>
		<li class="btn btn-outline-success"><a href="#">Logout</a></li>
		
	
	</ul>
		
	<!-- 
	<li><a href="DeleteUserJsp.jsp">DeleteUser</a></li>
		<li><a href="UpdateUserJsp.jsp">UpdateUser</a></li>
	 -->	
		<li><a href="#"></a></li>
		
		 <li style="color:white"><%=new Date() %></li>
		
      </ul>
     
    </div>
  </div>
</nav>  


<!-- Modal -->
<div class="modal fade" id="ProfileModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Profile</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      
        <h5 class="modal-title" id="exampleModalLabel"></h5>
        <div id="profile-details">
                <table class="table">

                    <tbody>
                        <tr>
                            <th scope="row"> Name :</th>
                            <td> <%= reg.getName()%></td>

                        </tr>
                        <tr>
                            <th scope="row"> Mobno : </th>
                            <td><%= reg.getMobno()%></td>

                        </tr>
                        <tr>
                            <th scope="row">Gmail :</th>
                            <td><%= reg.getGmail()%></td>

                        </tr>      
                    </tbody>
                </table>
           </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>        

</body>
</html>