package org.jsp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jsp.model.BankUserDetails;

public class BankUserDAOImpl implements BankUserDAO{
	private Connection connection;
	private static final String select="select * from bank_user_details";
	private static final String insert="insert into bank_user_details(Name, Emailid, Mobile_Number, Aadhar_Number, Address, Amount, Gender, IFSC_Code, Branch, Pan_Number, Status) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String update="update bank_user_details set Pin=?, Account_Number=? ,status=? where id=?";
	private static final String url="jdbc:mysql://localhost:3307/teca62projects?user=root&password=root";
	private static final String select_user_data="select * from bank_user_details where Name=? or Emailid=? or Mobile_Number=? or Aadhar_Number=? or Address=? or Gender=? or Pan_Number=?";
	private static final String user_login="select * from bank_user_details where Emailid=? and Pin=?";
	private static final String update_amount="update bank_user_details set Amount=? where Account_Number=?";
	@Override
	public int insertBankUserDetails(BankUserDetails bankuserdetails) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url);
			PreparedStatement preparestatement=connection.prepareStatement(insert);
			preparestatement.setString(1,bankuserdetails.getName());
			preparestatement.setString(2, bankuserdetails.getEmailid());
			preparestatement.setLong(3, bankuserdetails.getMobilenumber());
			preparestatement.setLong(4, bankuserdetails.getAdhar());
			preparestatement.setString(5, bankuserdetails.getAddress());
			preparestatement.setDouble(6, bankuserdetails.getAmount());
			preparestatement.setString(7, bankuserdetails.getGender());
			preparestatement.setString(8, "TECA62007");
			preparestatement.setString(9, "JNTU");
			preparestatement.setString(10, bankuserdetails.getPannumber());
			preparestatement.setString(11, "pending");
			return preparestatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	@Override
	public List<BankUserDetails> getAllUsersDetails() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url);
			PreparedStatement preparestatement=connection.prepareStatement(select);
			ResultSet result=preparestatement.executeQuery();
			List<BankUserDetails> list=new ArrayList<>();
			if(result.isBeforeFirst())
			{
				while(result.next())
				{
					//id, Name, Emailid, Pin, Mobile_Number, Aadhar_Number, Address, Amount, Gender, Account_Number, IFSC_Code, Branch, Pan_Number, Status
					BankUserDetails bankuserdetails=new BankUserDetails();
					bankuserdetails.setId(result.getInt("id"));
					bankuserdetails.setName(result.getString("Name"));
					bankuserdetails.setEmailid(result.getString("Emailid"));
					bankuserdetails.setMobilenumber(result.getLong("Mobile_Number"));
					bankuserdetails.setAdhar(result.getLong("Aadhar_Number"));
					bankuserdetails.setPannumber(result.getString("Pan_Number"));
					bankuserdetails.setAddress(result.getString("Address"));
					bankuserdetails.setStatus(result.getString("Status"));
					list.add(bankuserdetails);
				}
				return list;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
		
	}
	@Override
	public int updateUserPinAndAccountNumber(int id, int pin, int accountnumber) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url);
			PreparedStatement preparestatement=connection.prepareStatement(update);
			preparestatement.setInt(1, pin);
			preparestatement.setInt(2, accountnumber);
			preparestatement.setString(3, "Accepted");
			preparestatement.setInt(4, id);
			return preparestatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public List<BankUserDetails> getUserDetailsByFilterData(String filter) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url);
			PreparedStatement preparestatement=connection.prepareStatement(select_user_data);
			preparestatement.setString(1, filter);
			preparestatement.setString(2, filter);
			preparestatement.setString(3, filter);
			preparestatement.setString(4, filter);
			preparestatement.setString(5, filter);
			preparestatement.setString(6, filter);
			preparestatement.setString(7, filter);
			ResultSet result=preparestatement.executeQuery();
			List<BankUserDetails> list=new ArrayList<>();
			if(result.isBeforeFirst())
			{
				while(result.next())
				{
					//id, Name, Emailid, Pin, Mobile_Number, Aadhar_Number, Address, Amount, Gender, Account_Number, IFSC_Code, Branch, Pan_Number, Status
					BankUserDetails bankuserdetails=new BankUserDetails();
					bankuserdetails.setId(result.getInt("id"));
					bankuserdetails.setName(result.getString("Name"));
					bankuserdetails.setEmailid(result.getString("Emailid"));
					bankuserdetails.setMobilenumber(result.getLong("Mobile_Number"));
					bankuserdetails.setAdhar(result.getLong("Aadhar_Number"));
					bankuserdetails.setPannumber(result.getString("Pan_Number"));
					bankuserdetails.setAddress(result.getString("Address"));
					bankuserdetails.setStatus(result.getString("Status"));
					list.add(bankuserdetails);
				}
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
		
	}
	@Override
	public BankUserDetails userlogin(String emailid, int pin) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url);
			PreparedStatement preparestatement=connection.prepareStatement(user_login);
			preparestatement.setString(1, emailid);
			preparestatement.setInt(2, pin);
			ResultSet result=preparestatement.executeQuery();
			if(result.next())
			{
				
					BankUserDetails bankuserdetails=new BankUserDetails();
					bankuserdetails.setId(result.getInt("id"));
					bankuserdetails.setName(result.getString("Name"));
					bankuserdetails.setEmailid(result.getString("Emailid"));
					bankuserdetails.setMobilenumber(result.getLong("Mobile_Number"));
					bankuserdetails.setAdhar(result.getLong("Aadhar_Number"));
					bankuserdetails.setPannumber(result.getString("Pan_Number"));
					bankuserdetails.setAddress(result.getString("Address"));
					bankuserdetails.setStatus(result.getString("Status"));
					bankuserdetails.setAccountnumber(result.getInt("Account_Number"));
	                bankuserdetails.setAmount(result.getDouble("Amount"));
	                bankuserdetails.setPin(result.getInt("Pin"));
	                //System.out.println(bankuserdetails);
					return bankuserdetails;
				}
			else
			{
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public int updateAmountByUsingAccountNumber(double amount, int accountnumber) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url);
			PreparedStatement preparestatement=connection.prepareStatement(update_amount);
			preparestatement.setDouble(1, amount);
			preparestatement.setInt(2, accountnumber);
			return preparestatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}
}
