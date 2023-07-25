<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Wallet</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }
        
        h1 {
            text-align: center;
            margin-top: 50px;
        }
        
        table {
            border-collapse: collapse;
            margin: 0 auto;
        }
        
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ccc;
        }
        
        th {
            background-color: #4CAF50;
            color: #fff;
        }
        
        .add-funds-form {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-top: 50px;
        }
        
        input[type=text] {
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 100%;
        }
        
        input[type=submit] {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px;
            margin-top: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }
        
        input[type=submit]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>My Wallet</h1>
    <table>
        <tr>
            <th>Balance</th>
            <th>Actions</th>
        </tr>
        <tr>
            <td><%= session.getAttribute("balance") %></td>
            <td>
                <form method="post" action="AddFunds.jsp">
                    <input type="submit" value="Add Funds">
                </form>
            </td>
        </tr>
    </table>
    
    <div class="add-funds-form">
        <h2>Add Funds</h2>
        <form method="post" action="AddFunds.jsp">
            <label for="amount">Amount:</label>
            <input type="text" name="amount" id="amount">
            <input type="submit" value="Add">
        </form>
    </div>
</body>
</html>
