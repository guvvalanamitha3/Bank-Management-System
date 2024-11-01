package org.jsp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO{
	private Connection connection;
	private static final String select="select * from admin where Admin_Email_Id=? and Password=?";
	private static final String url="jdbc:mysql://localhost:3307/teca62projects?user=root&password=root";
	@Override
	public boolean adminlogin(String emailid, String password) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url);
			PreparedStatement preparestatement=connection.prepareStatement(select);
			preparestatement.setString(1, emailid);
			preparestatement.setString(2, password);
			ResultSet result=preparestatement.executeQuery();
			if(result.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
