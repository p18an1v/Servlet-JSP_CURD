<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Random" %>
    
<% 
    String mob = (String) session.getAttribute("mobno");
    Random rand = new Random();
    int otp = rand.nextInt(9000) + 1000;
    session.setAttribute("otp", otp);
    System.out.println("otp genrated:"+otp);
    
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>OTP Validation</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        form {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type=text] {
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 100%;
        }

        input[type=button], input[type=submit] {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px;
            margin-top: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        input[type=button]:hover, input[type=submit]:hover {
            background-color: #45a049;
        }

        input[type=button]:disabled, input[type=submit]:disabled {
            background-color: #ddd;
            cursor: not-allowed;
        }
    </style>
</head>
<body>
    <form method="post" action="Home.jsp">
        <input type="text" name="otpp" id="otpp" placeholder="Enter OTP">
        <input type="button" value="Validate OTP" onclick="otpValidate()">
        <input type="submit" value="Home" id="home" class="btn btn-info" disabled="true">
    </form>

    <script>
        function otpValidate() {
            document.getElementById("home").disabled = false;
            var enteredOTP = parseInt(document.getElementById("otpp").value);
            var actualOTP = <%=session.getAttribute("otp")%>;
            if (enteredOTP === actualOTP) {
                alert("OTP validation successful");
            } else {
                alert("Invalid OTP entered");
            }
        }
    </script>
</body>
</html>
