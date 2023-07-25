<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@page import="com.model.Register" %>
    
               <%@page import="java.util.Date" %>
               <%@page import="com.controller.RechargeController" %>
               
               
               
               
             <%int wallet=1000; %>
    
<!DOCTYPE html>
<html>
<head>
<script>let wallet=10;</script>

<meta charset="ISO-8859-1">
<title>User Form</title>
       <link rel="stylesheet1" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <% Register reg=(Register)session.getAttribute("user");
  	 session.setAttribute("mobno", reg.getMobno());
  %>
  <% int otp=1111; %>
  
  
  <script type="text/javascript">
  function verifyAnswer(){
	  var mylist = document.getElementById("operator");
	  var result = mylist.options[mylist.selectedIndex].text;
	    if (result == 'AIRTEL') {
	    	//disable all the radio button 
	  	document.getElementById("airtelplan").disabled = false;
	  	document.getElementById("jioplan").disabled = true;
	  	document.getElementById("viplan").disabled = true;
	  	document.getElementById("bsnlplan").disabled = true;
	  
	    } 
	    else if(result == 'JIO')
	    {
	    	//enable all the radio button
	    	document.getElementById("jioplan").disabled = false;
	    	document.getElementById("viplan").disabled = true;
		  	document.getElementById("bsnlplan").disabled = true;
		  	document.getElementById("airtelplan").disabled = true;
	    }
	    else if(result == 'V!')
	    {
	    	//enable all the radio button
	    	document.getElementById("viplan").disabled = false;
		  	document.getElementById("bsnlplan").disabled = true;
		  	document.getElementById("airtelplan").disabled = true;
		  	document.getElementById("jioplan").disabled = true;
	    }
	    else
	    {
	    	//enable all the radio button
	    	document.getElementById("bsnlplan").disabled = false;
	    	document.getElementById("airtelplan").disabled = true;
		  	document.getElementById("jioplan").disabled = true;
		  	document.getElementById("viplan").disabled = true;
	    }
  }
  
  function validateOtp()
  {	  
	  
	  
	  
  }	  
	
  
  
  function otpValidate()
  {
  	var no=parseInt(document.getElementById("inputotp").value);
  	var money=parseInt(document.getElementById("money").value);
  	var balance=document.getElementById('balance').value;
  	if(no == <%=otp %>)
  	{
  		balance = balance + money;			
  	}
  	else
  		alert("Invalid otp entered");
  		
  }
  
  </script>
</head>
<body  style="background-color:#c0c0c0">
  
    
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
      
       
        <li><a href="UserList">UserList</a></li>
        		<li><a href="#"></a></li>
        		<li><a href="#"></a></li>
        		<li><a href="#"></a></li>
        
        <li style="color:white"><%=new Date() %></li>
		
      </ul>
     
    </div>
  </div>
</nav>
  
  
     <br>
     <div class="container col-md-3">
         <div class="card">
             <div class="card-body">
                 
                 
                <form method="post" action="OTP.jsp">
                                  
            <fieldset class="form-group">
            	<label>Name:</label> <input type="text" placeholder="<%=reg.getName() %>" class="form-control" name="username" id="username">
                <label>Mobile No:</label> (+91)<input type="text" placeholder="Mobile No:" class="form-control" name="mobno" id="mobno" required="required">
       
            </fieldset>

            <fieldset class="form-group">
                   <label>Operator *</label> 
			<select id="operator" name="operator" onchange="verifyAnswer()" style="width:150px" class="form-control" required="required">
			    <option value="blank">Select Operator</option>
			    <option value="airtel">AIRTEL</option>
			    <option value="jio">JIO</option>
			    <option value="V!">V!</option>
			    <option value="bsnl">BSNL</option>
			    
			</select>
			<br>
			<table>
				<tr>
					<td> AIRTEL Plans:</td>
					<td>
					<select id="airtelplan" disabled=true name="airtelplan" style="width:300px" class="form-control" required="required">
				    <option value="blank">Select Plan</option>
				  <option value="449(2gb/day=56days)">Rs 449 - 2gb/day for 56 days</option>
				    <option value="599(1.5gb/day=84days)">Rs 599 - 1.5gb/day for 84 days</option>
				    <option value="698(2gb/day=84days)">Rs 698 - 2gb/day for 84 days</option>
				    <option value="250(1gb/day=28days)">Rs 250 - 1gb/day for 28 days</option>
			    
					</select>
					
					
					</td>
				</tr>
				
				<tr>
					<td> JIO Plans:</td>
					<td>
					<select id="jioplan" disabled=true name="jioplan" style="width:300px" class="form-control" required="required">
				    <option value="blank">Select Plan</option>
				    <option value="449(2gb/day=56days)">Rs 449 - 2gb/day for 56 days</option>
				    <option value="599(1.5gb/day=84days)">Rs 599 - 1.5gb/day for 84 days</option>
				    <option value="698(2gb/day=84days)">Rs 698 - 2gb/day for 84 days</option>
				    <option value="250(1gb/day=28days)">Rs 250 - 1gb/day for 28 days</option>
			    
					</select>
					
					
					</td>
				</tr>
				
				<tr>
					<td> V! Plans:</td>
					<td>
					<select id="viplan" disabled=true name="viplan" style="width:300px" class="form-control" required="required">
				    <option value="blank">Select Plan</option>
				    <option value="449(2gb/day=56days)">Rs 449 - 2gb/day for 56 days</option>
				    <option value="599(1.5gb/day=84days)">Rs 599 - 1.5gb/day for 84 days</option>
				    <option value="698(2gb/day=84days)">Rs 698 - 2gb/day for 84 days</option>
				    <option value="250(1gb/day=28days)">Rs 250 - 1gb/day for 28 days</option>
			    
					</select>
					
					
					</td>
				</tr>
				
				<tr>
					<td> BSNL Plans:</td>
					<td>
					<select id="bsnlplan" disabled=true name="bsnlplan" style="width:300px" class="form-control" required="required">
				    <option value="blank">Select Plan</option>
				    <option value="449(2gb/day=56days)">Rs 449 - 2gb/day for 56 days</option>
				    <option value="599(1.5gb/day=84days)">Rs 599 - 1.5gb/day for 84 days</option>
				    <option value="698(2gb/day=84days)">Rs 698 - 2gb/day for 84 days</option>
				    <option value="250(1gb/day=28days)">Rs 250 - 1gb/day for 28 days</option>
			    
					</select>
					
					
					</td>
				</tr>
			
			</table>
			
             </fieldset>
             
             <fieldset class="form-group">
             <label>State/Circle *</label> 
			<select id="state" name="state" style="width:150px" class="form-control" required="required">
			<option value="blank">Select State</option>
			    <option value="Maharashtra">Maharashtra</option>
			    <option value="Karnataka">Karnataka</option>
			    <option value="Rajasthan">Rajasthan</option>
			    <option value="Tamil Nadu">Tamil Nadu</option>
			    
					</select>
               </fieldset>

				<input type="submit" value="Generate OTP" class="btn btn-success">
               
		
                 
                 </form>
             </div>
         </div>
     </div>
     
  
  </body>
</html>
  