<%@page import="org.jsp.DAO.BankStatementDAO"%>
<%@page import="org.jsp.DAO.BankStatementDAOImpl"%>
<%@page import="org.jsp.DAO.BankUserDAO"%>
<%@page import="org.jsp.DAO.BankUserDAOImpl"%>
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
<% BankUserDetails bankuserdetails=(BankUserDetails)session.getAttribute("userdetails");
double amount=(Double)session.getAttribute("useramount");
%>
<center>
<div id="amountcontainer">
<h3>Amount</h3>
<form>
<input placeholder="Enter Amount" id="uamount">
<input value=<%=bankuserdetails.getAmount() %> id="damount" hidden="true">
<input type="button" value="submit" onclick="validation()">
</div>
</form>
<p id="display" style="color:red"></p>
<div id="accountcontainer" style="display:none;">
<h3>Account Number</h3>
<form>
<input placeholder="Enter Account Number" name="accountnumber"><br>
<input id="displayuseramount" hidden="true" name="useramount">
<input type="submit" value="Proceed">
</form>
</div>
<%
String uaccountnumber=request.getParameter("accountnumber");
String uamount=request.getParameter("useramount");
if(uaccountnumber!=null && uamount!=null)
{
	int useraccountnumber=Integer.parseInt(uaccountnumber);
	double useramount=Double.parseDouble(uamount);
	if(bankuserdetails.getAccountnumber()==useraccountnumber)
	{
		double balanceamount=bankuserdetails.getAmount()-useramount;
		BankUserDAO bankuserDAO=new BankUserDAOImpl();
		int result=bankuserDAO.updateAmountByUsingAccountNumber(balanceamount, useraccountnumber);
		if(result!=0)
		{
			BankStatementDAO bankstatementDAO=new BankStatementDAOImpl();
			if(bankstatementDAO.insertStatementDetails("DEBIT", useramount, useraccountnumber, balanceamount))
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("Home.jsp");
				dispatcher.forward(request, response);
			}
		}
		else
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		%>
		<% 
	}
}
%>
</center>
<script type="text/javascript">
function validation()
{
	var uamount=document.getElementById("uamount").value
	var useramount=parseInt(uamount);
	console.log(uamount);
	var damount=document.getElementById("damount").value
	console.log(damount);
	var databaseamount=parseInt(damount);
	console.log(databaseamount);
	if(uamount>=0)
		{
		if(uamount<=damount)
			{
			document.getElementById("amountcontainer").style.display="none"
			document.getElementById("accountcontainer").style.display="block"
			console.log(uamount);
			var useramount=document.getElementById("displayuseramount").value=useramount;
			
			}
		else
			{
			window.alert("In-sufficient balance");
			}
		}
	else
		{
		window.alert("Invalid amount");
		}
	}
</script>
</body>
</html>