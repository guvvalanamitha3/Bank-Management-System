<%@page import="org.jsp.model.BankStatementDetails"%>
<%@page import="java.util.List"%>
<%@page import="org.jsp.DAO.BankStatementDAOImpl"%>
<%@page import="org.jsp.DAO.BankStatementDAO"%>
<%@page import="org.jsp.model.BankUserDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<%

%>
<div>
<form>
<input placeholder="Enter Account Number" name="accountnumber">
<br>
<input type="submit">
</form>
</div>
<%
String uaccountnumber=request.getParameter("accountnumber");
if(uaccountnumber!=null)
{
	int useraccountnumber=Integer.parseInt(uaccountnumber);
if(useraccountnumber!=0)
{%>
<table border="1">
<tr>
<th>Transaction Type</th>
<th>Transaction Amount</th>
<th>Transaction Date</th>
<th>Transaction Time</th>
<th>Account Number</th>
</tr>
<% BankStatementDAO bankstatementDAO=new BankStatementDAOImpl();
	List<BankStatementDetails> list=bankstatementDAO.listAllStatementDetails(useraccountnumber);
	for(BankStatementDetails bankstatementdetails:list)
	{
	if(bankstatementdetails!=null && bankstatementdetails.getAccountnumber()==useraccountnumber)
	{%>
	<tr>
	<td><%=bankstatementdetails.getTransactiontype() %></td>
	<td><%=bankstatementdetails.getTransactionamount() %></td>
	<td><%=bankstatementdetails.getTransactiondate() %></td>
	<td><%=bankstatementdetails.getTransactiontime() %></td>
	<td><%=bankstatementdetails.getAccountnumber() %></td>
	</tr>
	<% 
	}
	}
}
}
%>
</table>
</center>
</body>
</html>
