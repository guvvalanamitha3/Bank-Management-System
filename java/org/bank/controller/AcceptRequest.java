package org.bank.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsp.DAO.*;
@WebServlet("/acceptrequest")
public class AcceptRequest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempid=request.getParameter("userid");
		int id=Integer.parseInt(tempid);
		Random random=new Random();
		int pin=random.nextInt(10000);
		if(pin<1000)
		{
			pin+=1000;
		}
		int accountnumber=random.nextInt(1000000);
		if(accountnumber<100000)
		{
			accountnumber+=100000;
		}
		BankUserDAO bankuserDAO=new BankUserDAOImpl();
		int number=bankuserDAO.updateUserPinAndAccountNumber(id, pin, accountnumber);
		if(number!=0)
		{
			System.out.println("Updated");
		}
		else
		{
			System.out.println("Not Updated");
		}
	}

}
