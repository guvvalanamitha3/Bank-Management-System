<%@page import="org.jsp.model.BankUserDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
button
{
border-radius:20px;
font-size:20px;
}
</style>
</head>
<body style="background-color:red;">
<center>
<% BankUserDetails bankuserdetails=(BankUserDetails)session.getAttribute("userdetails"); %>
<h1>Hello:-<%=bankuserdetails.getName() %></h1>
<table>
<tr>
<td><a href="DebitAmount.jsp"><button>Debit</button></a></td>
<td><a href="CheckStatement.jsp"><button>Check Statement</button></a></td>
</tr>
<tr>
<td><a href="CreditAmount.jsp"><button>Credit</button></a></td>
<td><a href="BalanceAmount.jsp"><button>Balance Amount</button></a></td>
</tr>
</table>
</center>
</body>
</html>
