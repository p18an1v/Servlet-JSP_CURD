<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to your Dashboard</h1>
    <table border="3">
        <tr>
            <th>Account ID</th>
            <th>Username</th>
            <th>Phone Number</th>
            <th>Account Balance</th>
            <th>Account password</th>
        </tr>
        <tr>
            <td>${stored_data.accId}</td>
            <td>${stored_data.userName}</td>
            <td>${stored_data.phoneNo}</td>
            <td>${stored_data.accBal}</td>
            <td>${stored_data.password }</td>
            </tr>
    </table>
        <a href="update.jsp">
    <input type="submit" value="Update" />
        </a>
         <br>
    <!--  <a href="display_All">
    <input type="submit" value="display" />
        </a>
        <br>-->
    <a href="delete.html">
    <input type="submit" value="delete" />
        </a>
</body>
</html>