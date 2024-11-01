package org.jsp.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class BankStatementDetails 
{
	private int id;
	private String transactiontype;
	private double transactionamount;
	private LocalDate transactiondate;
	private LocalTime transactiontime;
	private int accountnumber;
	private double balanceamount;
	 public BankStatementDetails()
	 {
		 
	 }
	
}
