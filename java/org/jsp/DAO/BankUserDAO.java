package org.jsp.DAO;

import java.util.List;

import org.jsp.model.BankUserDetails;

public interface BankUserDAO {
 int insertBankUserDetails(BankUserDetails bankuserdetails);
 List<BankUserDetails> getAllUsersDetails();
 int updateUserPinAndAccountNumber(int id, int pin, int accountnumber);
 List<BankUserDetails> getUserDetailsByFilterData(String filter);
 BankUserDetails userlogin(String emailid,int pin);
 int updateAmountByUsingAccountNumber(double amount,int accountnumber);
}
