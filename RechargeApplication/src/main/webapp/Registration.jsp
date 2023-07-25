<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="java.util.Date" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
  <link rel="stylesheet1" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script></head>
<body  style="background-color:#c0c0c0">

 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
                                
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">ADMIN LOGIN</a></li>
       
        
		
      </ul>
     
    </div>
  </div>
</nav>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        
                        
                     <form action="RegistrationController" method="get">
                      
						<%=new Date() %>
                        
                        <fieldset class="form-group">
                            <label>Name</label> <input type="text" placeholder="Enter Name"  class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Mobile No(Bank Account linked):</label> <input type="text" placeholder="Enter Mob-No" class="form-control" name="mobno" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Gmail:</label> <input type="text" placeholder="Enter Gmail"  class="form-control" name="gmail" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>City:</label> <input type="text" placeholder="Enter City" class="form-control" name="city" required="required">
                        </fieldset>
                        

                        <fieldset class="form-group">
                            <label>Password</label> <input type="password" placeholder="Enter Password" class="form-control" name="password" required="required">
                        </fieldset>

                      

                        <button type="submit" class="btn btn-success">Register</button>
                         <span class="psw">${error}</span>
                        
                        </form>
                    </div>
                </div>
            </div>

</body>
</html>