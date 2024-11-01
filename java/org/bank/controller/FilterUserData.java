package org.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.DAO.*;
import org.jsp.model.BankUserDetails;
@WebServlet("/filteruserdata")
public class FilterUserData extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filter=request.getParameter("filter");
		BankUserDAO bankuserDAO=new BankUserDAOImpl();
	List<BankUserDetails> filterdata=bankuserDAO.getUserDetailsByFilterData(filter);
	HttpSession session=request.getSession();
	session.setAttribute("alluserdetails",filterdata);
	RequestDispatcher dispatcher=request.getRequestDispatcher("AllUserDetails.jsp");
	dispatcher.forward(request, response);
	}
}
