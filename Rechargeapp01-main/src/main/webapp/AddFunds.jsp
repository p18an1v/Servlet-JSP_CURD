<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Wallet - Add Funds</title>
    <style>
        /* styles here */
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
        <form method="post" action="AddFundsController">
            <label for="amount">Amount:</label>
            <input type="text" name="amount" id="amount">
            <input type="submit" value="Add">
        </form>
    </div>
</body>
</html>
