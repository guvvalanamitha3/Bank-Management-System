package org.jsp.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.jsp.model.BankStatementDetails;
import org.jsp.model.BankUserDetails;

public class BankStatementDAOImpl implements BankStatementDAO{
	private Connection connection;
	BankUserDAO bankuserDAO=new BankUserDAOImpl();
	BankUserDetails bankuserdetails=new BankUserDetails();
	private static final String url="jdbc:mysql://localhost:3307/teca62projects?user=root&password=root";
	private static final String insert="insert into bank_statement1(Transaction_Type, Transaction_Amount, Transaction_Date, Transaction_Time, Account_Number, Balance_Amount) values(?,?,?,?,?,?)";
	private static final String select="select * from bank_statement1 where Account_Number=?";
	@Override
	public boolean insertStatementDetails(String transactiontype, double transactionamount, int accountnumber,double balanceamount) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url);
			PreparedStatement preparestatement=connection.prepareStatement(insert);
			preparestatement.setString(1, transactiontype);
			preparestatement.setDouble(2, transactionamount);
			preparestatement.setDate(3, Date.valueOf(LocalDate.now()));
			preparestatement.setTime(4, Time.valueOf(LocalTime.now()));
			preparestatement.setInt(5, accountnumber);
			preparestatement.setDouble(6, balanceamount);
			int result=preparestatement.executeUpdate();
			if(result!=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public List<BankStatementDetails> listAllStatementDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url);
			PreparedStatement preparestatement=connection.prepareStatement(select);
			ResultSet result=preparestatement.executeQuery();
			List<BankStatementDetails> list=new ArrayList<>();
			if(result.isBeforeFirst())
			{
				while(result.next())
				{
					//id, Name, Emailid, Pin, Mobile_Number, Aadhar_Number, Address, Amount, Gender, Account_Number, IFSC_Code, Branch, Pan_Number, Status
					//Transaction_Id, Transaction_Type, Transaction_Amount, Transaction_Date, Transaction_Time, Account_Number, Balance_Amount
					BankStatementDetails bankstatementdetails=new BankStatementDetails();
					bankstatementdetails.setId(result.getInt("Transaction_Id"));
					bankstatementdetails.setTransactiontype(result.getString("Transaction_Type"));
					bankstatementdetails.setTransactionamount(result.getDouble("Transaction_Amount"));
					bankstatementdetails.setTransactiondate(result.getDate("Transaction_Date").toLocalDate());
					bankstatementdetails.setTransactiontime(result.getTime("Transaction_Time").toLocalTime());
					bankstatementdetails.setAccountnumber(result.getInt("Account_Number"));
					list.add(bankstatementdetails);
					
				}
			}
			return list;
			
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

}
