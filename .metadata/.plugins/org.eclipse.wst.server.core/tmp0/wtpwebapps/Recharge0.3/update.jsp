<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update User Account Data</title>
</head>
<body>
    <h1>Update User Account Data</h1>
    <form action="updateController">
      <!--   <label for="updateOption">Select data to update:</label>
         <select name="updateOption">
            <option value="accId">Account ID</option>
            <option value="userName">Username</option>
            <option value="phoneNo">Phone Number</option>
            <option value="accBal">Account Balance</option>
            <option value="password">Password</option>
        </select>
        <br>
        <label for="accId">Account ID:</label>
        <input type="number" name="accId" required>
        <br>
        <label for="newValue">New Value:</label>
        <input type="text" name="newValue" required>
        <br>
        <input type="submit" value="Update">
        
        
      Enter your Name <br>
     <input type="text"  name="userName" ><br>
       Phone No <br>
    <br>
    -->
     Enter your AccId<br>
     <input type="text"  name="accId"><br>
     User Name<br>
     <input type="text" name="userName"><br>
     Account Balance<br>
     <input type="text"  name="accBal"><br>
     Phone No <br>
      <input type="text"  name="phoneNo"><br>
      Password<br>
       <input type="text"  name="password"><br>
       <input type="submit" value = "Update Account"><br>
    </form>
</body>
</html>
    