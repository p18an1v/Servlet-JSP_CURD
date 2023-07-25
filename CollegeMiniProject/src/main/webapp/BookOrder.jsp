<!DOCTYPE html>
<%@ page import="entity.Login"%>
<%@ page import="controller.Book"%>
<%@ page import="controller.display"%>
<html lang="en">
<head>
    <title>Webpage Design</title>
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
    	  /* Global Styles */
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
        
        /* Navbar Styles */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px;
            background-color: #095a55;
            color: #fff;
        }
        
        .navbar .logo {
            margin: 0;
        }
        
        .navbar ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
        }
        
        .navbar ul li {
            margin-right: 10px;
        }
        
        .navbar ul li a {
            text-decoration: none;
            color: #fff;
        }
        
        /* Content Styles */
        .content {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 80vh;
        }
        
        .form {
            background-color: #f2f2f2;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
        
        .form input[type="text"],
        .form input[type="submit"] {
            padding: 10px;
            margin-bottom: 10px;
            width: 100%;
            box-sizing: border-box;
        }
        
        .form input[type="submit"] {
            background-color: #5C469C;
            text-shadow:black;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        
        .form input[type="submit"]:hover {
            background-color: #555;
        }
        
        /* Features Styles */
        .features {
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
            background-color: #f2f2f2;
        }
        
        .box {
            text-align: center;
            margin: 20px;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            background-color: #fff;
            transition: transform 0.3s ease;
        }
        
        .box:hover {
            transform: scale(1.05);
        }
        
        .box img {
            width: 100px;
            margin-bottom: 10px;
        }
        
        /* Footer Styles */
        .footer {
            background-color: #5C469C;
            color: #fff;
            padding: 20px;
            text-align: center;
        }
        
        .footer-content {
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
            flex-wrap: wrap;
            max-width: 1200px;
            margin: 0 auto;
        }
        
        .footer-section {
            flex-basis: 30%;
            margin-bottom: 20px;
        }
        
        .footer-section h3 {
            margin-bottom: 10px;
        }
        
        .footer-section ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        
        .footer-section ul li {      margin-bottom: 5px;
        }
        
        .footer-section ul li a {
            text-decoration: none;
            color: #fff;
        }
        
        .footer-bottom {
            margin-top: 20px;
            padding-top: 10px;
            border-top: 1px solid #fff;
        }
    </style>
    
</head>
<body>

<div class="main">
    <div class="navbar">
        <div class="icon">
            <h2 class="logo">Library Heaven&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h2>
        </div>

        <div class="menu">
            <ul>
                <li><a href="#">HOME</a></li>
                <li><a href="register.html">REGISTER</a></li>
                <li><a href="#">OFFER'S</a></li>
                <li><a href="#">ABOUT</a></li>
                <li><a href="contact.html">CONTACT</a></li>
            </ul>
        </div>

        <div class="search">
            <input class="srch" type="search" name="" placeholder="Type To text">
            <a href="#"> <button class="btn">Search</button></a>
        </div>

    </div> 
    <div class="content">

        <div class="form">

            <div class="welcome">
            <%! Login l; %>
                <%
                if(!session.isNew()) {
                  l=(Login)session.getAttribute("Login");
                  out.print("Welcome \n"+l.getUserName()); 
                  out.print("!");
                }
                %>
            </div>
            <br>
            <% int accno=l.getAccNo(); %>
            <form action="mobilerecharge" method="post">
                <label for="cname">Enter Phone Number:</label>
                <input type="text" name="phoneno" id="cname">
                <br>
                <label for="uname">Enter  Amount:</label>
                <input type="text" name="recamt" id="uname">
                <br>
                <label for="accno">Enter Service Provider:</label>
                <input type="text" name="isp" id="accno">
                <br>
                <input type="hidden" name="accno" value="<%=accno%>">
                <input type="submit" value="order">
                <br>
            </form>
            <script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>


            <div class="buttonf">
                <form action="display" method="get">
                    <input type="hidden" name="accno" value="<%=accno%>">
                    <input type="submit" value="View Transaction">
                </form>
            </div>

        </div>
    </div>
</div>

<div class="features">
    <div class="box">
        <img src="C://Users//saket//Downloads//Bank2//Bank2//src//main//webapp//WEB-INF//images//feature1.png" alt="Feature 1">
        <h2>Easy Recharge</h2>
        <p>Recharge your mobile phone with Recharge Heaven. It's quick, convenient, and hassle-free. No more standing in queues or searching for recharge shops. With Recharge Heaven, you can recharge anytime, anywhere.</

<p>Recharge your mobile phone with Recharge Heaven. It's quick, convenient, and hassle-free. No more standing in queues or searching for recharge shops. With Recharge Heaven, you can recharge anytime, anywhere.</p>

    </div>
    <div class="box">
        <img src="C://Users//saket//Downloads//Bank2//Bank2//src//main//webapp//WEB-INF//images//feature2.png" alt="Feature 2">
        <h2>Secure Transactions</h2>
        <p>Your security is our top priority. Recharge Heaven ensures secure and encrypted transactions, keeping your personal and financial information safe. Recharge with peace of mind knowing that your data is protected.</p>
    </div>
    <div class="box">
        <img src="C://Users//saket//Downloads//Bank2//Bank2//src//main//webapp//WEB-INF//images//feature3.png" alt="Feature 3">
        <h2>Wide Range of Service Providers</h2>
        <p>Choose from a wide range of service providers available on Recharge Heaven. Whether you want to recharge your prepaid mobile, DTH, or data card, we've got you covered. Enjoy the convenience of recharging multiple services in one place.</p>
    </div>
</div>

<div class="footer">
    <div class="footer-content">
        <div class="footer-section about">
            <h3>About Library Heaven</h3>
            <p>Library Heaven is a leading online platform for mobile Library and bill payments. We provide a seamless Library experience with secure transactions and a wide range of service providers. Recharge your mobile phone, DTH, or data card hassle-free with Recharge Heaven.</p>
        </div>
        <div class="footer-section links">
            <h3>Quick Links</h3>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="register.html">Register</a></li>
                <li><a href="#">Offers</a></li>
                <li><a href="#">About</a></li>
                <li><a href="contact.html">Contact</a></li>
            </ul>
        </div>
        <div class="footer-section contact">
            <h3>Contact Us</h3>
            <ul>
                <li><ion-icon name="location-outline"></ion-icon>123 Street, City, Country</li>
                <li><ion-icon name="mail-outline"></ion-icon>info@Recharge Heaven.com</li>
                <li><ion-icon name="call-outline"></ion-icon>+1234567890</li>
            </ul>
        </div>
    </div>
    <div class="footer-bottom">
        &copy; 2023 Library Heaven. All rights reserved.
    </div>
</div>

</body>
</html>
