<%@page import="org.jsp.model.BankUserDetails"%>
<%@page import="org.jsp.DAO.BankUserDAOImpl"%>
<%@page import="org.jsp.DAO.BankUserDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.jsp.DAO.AdminDAOImpl"%>
<%@page import="org.jsp.DAO.AdminDAO"%>
<html>
<body>
<center>
<h2 style="color:blue">Bank Management System</h2>
<table>
<td>
<h2 style="color:blue">User Login</h2>
<%!String umsg; %>
<%if(umsg!=null){ %>
<%=umsg %>
<%} %>
<form action="userlogin">
<input placeholder="Enter your Email Id" name="useremailid">
<br><br>
<input placeholder="Enter your password" name="userpassword">
<br><br>
<input type="submit" value="login">
</form>
<br>
<a href="UserRegistration.jsp">New Account..?</a>
<a href="*">Forgot Password...</a>
</td>
<td>
<h2 style="color:blue">Admin Login</h2>
<form>
<input placeholder="Enter your Email Id" name="adminemailid">
<br>
<br>
<input placeholder="Enter your password" name="adminpassword">
<br>
<br>
<input type="submit" value="login">
</form>
<%!String msg; %>
<%if(msg!=null){ %>
<%=msg %>
<%} %>
</td>
</table>
<%
String emailid=request.getParameter("adminemailid");
String password=request.getParameter("adminpassword");
if(emailid!=null&&password!=null){
AdminDAO adminDAO=new AdminDAOImpl();
	if(adminDAO.adminlogin(emailid, password))
	{
		RequestDispatcher dispatcher=request.getRequestDispatcher("AdminRegistration.jsp");
		dispatcher.forward(request, response);
	}
else
{
	msg="Invalid data";
}
}
%>
<%
String useremailid=request.getParameter("useremailid");
String userpassword=request.getParameter("userpassword");
if(useremailid!=null && userpassword!=null)
{
	out.print(useremailid);
out.print(userpassword);
    int pin=Integer.parseInt(userpassword);
	BankUserDAO bankuserDAO=new BankUserDAOImpl();
	/*BankUserDetails bankuserdetails=bankuserDAO.userlogin(emailid, pin);*/
	if(useremailid!=null)
	{
		/*session.setAttribute("userdetails",bankuserdetails);*/
		RequestDispatcher dispatcher=request.getRequestDispatcher("Home.jsp");
		dispatcher.forward(request, response);
	}
	/*else
	{
		umsg="Invalid data";
	}*/
}
%>
</center>
</body>
</html>
