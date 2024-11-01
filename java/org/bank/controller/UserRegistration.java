package org.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsp.DAO.BankUserDAO;
import org.jsp.DAO.BankUserDAOImpl;
import org.jsp.model.BankUserDetails;
@WebServlet("/registration")
public class UserRegistration extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String emailid=request.getParameter("emailid");
		String mobilenumber=request.getParameter("mb");
		Long mobile=Long.parseLong(mobilenumber);
		String aadharnumber=request.getParameter("an");
		Long adhar=Long.parseLong(aadharnumber);
		String address=request.getParameter("address");
		String pannumber=request.getParameter("pn");
		String money=request.getParameter("amount");
		Double amount=Double.parseDouble(money);
		String gender=request.getParameter("gender");
		BankUserDetails bankuserdetails=new BankUserDetails();
		bankuserdetails.setName(name);
		bankuserdetails.setEmailid(emailid);
		bankuserdetails.setMobilenumber(mobile);
		bankuserdetails.setAdhar(adhar);
		bankuserdetails.setAddress(address);
		bankuserdetails.setPannumber(pannumber);
		bankuserdetails.setAmount(amount);
		bankuserdetails.setGender(gender);
		BankUserDAO bankuserDAO=new BankUserDAOImpl();
		int userdetails=bankuserDAO.insertBankUserDetails(bankuserdetails);
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		if(userdetails!=0)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			writer.println("<center><h2 style=color:green>Registration Successfully</h2></center>");
		}
		else
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("UserRegistration.jsp");
			dispatcher.forward(request, response);
			writer.println("<center><h2>Server 420</h2></center>");
		}
		
	}
	

}
