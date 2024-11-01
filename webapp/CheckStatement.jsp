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
<%BankUserDetails bankuserdetails=(BankUserDetails)session.getAttribute("userdetails"); 
int accountnumber=(Integer)session.getAttribute("accountnumber");
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
if(bankuserdetails.getAccountnumber()!=0)
{
	int useraccountnumber=Integer.parseInt(uaccountnumber);
	BankStatementDAO bankstatementDAO=new BankStatementDAOImpl();
	List<BankStatementDetails> list=bankstatementDAO.listAllStatementDetails();
	for(BankStatementDetails bankstatementdetails:list)
	{
	if(bankstatementdetails.getAccountnumber()==useraccountnumber)
	{%>
	<tr>
	<td><%=bankstatementdetails.getTransactiontype() %></td>
	<td><%=bankstatementdetails.getTransactionamount() %></td>
	<td><%=bankstatementdetails.getTransactiondate() %></td>
	<td><%=bankstatementdetails.getTransactiontime() %></td>
	<td><%=bankstatementdetails.getAccountnumber() %></td>
	<td><%=bankstatementdetails.getBalanceamount() %></td>
	</tr>
	<% 
	}
	}
}
%>
</center>
</body>
</html>