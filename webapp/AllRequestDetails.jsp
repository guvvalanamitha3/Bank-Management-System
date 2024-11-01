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
<center>
<table border="1">
<tr>
<th>Name</th>
<th>Emailid</th>
<th>Mobile Number</th>
<th>Aadhar Number</th>
<th>Pan Number</th>
<th>Address</th>
<th></th>
</tr>
<% BankUserDAO bankuserDAO=new BankUserDAOImpl(); 
List<BankUserDetails> allusers=bankuserDAO.getAllUsersDetails();
for(BankUserDetails bankuserdetails:allusers){ 
	if(bankuserdetails.getStatus().equalsIgnoreCase("pending"))
	{%>
<tr>
<td><%=bankuserdetails.getName() %></td>
<td><%=bankuserdetails.getEmailid() %></td>
<td><%=bankuserdetails.getMobilenumber() %></td>
<td><%=bankuserdetails.getAdhar() %></td>
<td><%=bankuserdetails.getPannumber() %></td>
<td><%=bankuserdetails.getAddress() %></td>
<td><form action="acceptrequest" method="get">
<input value=<%=bankuserdetails.getId() %> hidden="true" name="userid">
<input type="submit" value="Accept">
</form></td>
</tr>
<%}
}%> 
</table>
</center>
</body>
</html>