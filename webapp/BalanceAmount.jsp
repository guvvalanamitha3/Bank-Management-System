<%@page import="org.jsp.model.BankStatementDetails"%>
<%@page import="org.jsp.DAO.BankUserDAOImpl"%>
<%@page import="org.jsp.DAO.BankUserDAO"%>
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
<%BankUserDetails bankuserdetails=(BankUserDetails)session.getAttribute("userdetails"); %>
<center>
<div id="accountcontainer">
<h3>Balance Amount</h3>
<form>
<input placeholder="Enter Account Number" name="accountnumber">
<input type="submit">
</form>
</div>
<%
String accountnumber=request.getParameter("accountnumber");
if(accountnumber!=null)
{
	int useraccountnumber=Integer.parseInt(accountnumber);
	BankUserDAO bankuserDAO=new BankUserDAOImpl();
	double balanceamount=bankuserdetails.getAmount();
	if(bankuserdetails.getAccountnumber()==useraccountnumber)
	{
		%>
		<h1>Dear <%=bankuserdetails.getName() %> Your Balance Amount is-<%=bankuserdetails.getAmount() %></h1>
<% 
	}
}%>
</center>
</body>
</html>