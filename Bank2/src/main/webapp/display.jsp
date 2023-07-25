<!DOCTYPE html>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="entity.mobile_recharge"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
    table {
        border-collapse: collapse;
        width: 100%;
        background-color: black;
        border-color: #ff7200;
        color: white;
    }

    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #ff7200;
    }
</style>

</head>
<body>
<%
List<mobile_recharge> lstmr = (LinkedList<mobile_recharge>)request.getAttribute("transactions");
%>

<table border="1">
<thead>
<tr>
<th>Account No</th>
<th>Phone No</th>
<th>Service Provider</th>
<th>Recharge Amount</th>
<th>Transaction Date</th>
</tr>
</thead>
<tbody>
<%for(mobile_recharge mr:lstmr)
{
%>
<tr>
<td><%=mr.getAccNo() %></td>
<td><%=mr.getPhoneNo() %></td>
<td><%=mr.getServiceProvider() %></td>
<td><%=mr.getRecAmt() %></td>
<td><%=mr.getDate() %></td>
</tr>
<%}%>
</tbody>
</table><br>

</body>
</html>
