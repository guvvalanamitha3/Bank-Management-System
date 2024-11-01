<%@page import="org.jsp.model.BankUserDetails"%>
<%@page import="java.util.List"%>
<%@page import="org.jsp.DAO.BankUserDAOImpl"%>
<%@page import="org.jsp.DAO.BankUserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!List<BankUserDetails> list; %>
<%List<BankUserDetails> alluserslist=(List<BankUserDetails>)session.getAttribute("alluserdetails");
if(alluserslist==null)
{
	BankUserDAO bankuserDAO=new BankUserDAOImpl();
	list=bankuserDAO.getAllUsersDetails();
}
else
{
	list=alluserslist;
}
%>
<center>
<form action="filteruserdata" method="get">
<input placeholder="Enter value" name="filter">
<input type="submit" value="search">
</form>
<table border="1">
<tr>
<th>Name</th>
<th>Emailid</th>
<th>Mobile Number</th>
<th>Aadhar Number</th>
<th>Pan Number</th>
<th>Address</th>
</tr>
<%BankUserDAO bankuserDAO=new BankUserDAOImpl(); 
for(BankUserDetails bankuserdetails: list)
{
%>
<tr>
<td><%=bankuserdetails.getName() %></td>
<td><%=bankuserdetails.getEmailid() %></td>
<td><%=bankuserdetails.getMobilenumber() %></td>
<td><%=bankuserdetails.getAdhar() %></td>
<td><%=bankuserdetails.getPannumber() %></td>
<td><%=bankuserdetails.getAddress() %></td>
</tr>
<%}%>
</table>
</center>
</body>
</html>