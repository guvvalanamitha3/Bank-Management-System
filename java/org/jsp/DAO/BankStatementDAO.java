package org.jsp.DAO;

import java.util.List;

import org.jsp.model.BankStatementDetails;
import org.jsp.model.BankUserDetails;

public interface BankStatementDAO {
	boolean insertStatementDetails(String transactiontype, double transactionamount, int accountnumber, double balanceamount);
	List<BankStatementDetails> listAllStatementDetails();
}
