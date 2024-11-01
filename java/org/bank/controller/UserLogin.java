package org.bank.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jsp.model.BankUserDetails;
import org.jsp.DAO.*;
@WebServlet("/userlogin")
public class UserLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailid=request.getParameter("useremailid");
		String password=request.getParameter("userpassword");
			int pin=Integer.parseInt(password);
			BankUserDAO bankuserDAO=new BankUserDAOImpl();
			HttpSession session=request.getSession();
			BankUserDetails userlogin = bankuserDAO.userlogin(emailid, pin);
			 session.setAttribute("userdetails",userlogin);
			if(bankuserDAO.userlogin(emailid, pin)!=null)
			{
		               //session.setAttribute("userdetails",bankuserdetails);
		        		RequestDispatcher dispatcher=request.getRequestDispatcher("Home.jsp");
		        		dispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
        		dispatcher.forward(request, response);
			}
	}
}
