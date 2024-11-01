package org.jsp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
//data-setter,getter and to string methods
//allargsconstructor-constructor with arguements
//noargconstructor-constructor without arguments
//@Setter-only for setter methods
//@Getter-only for getter methods
//@ToString-to string method
public class BankUserDetails {
	private int id;
	private String name;
	private String emailid;
	private long mobilenumber;
	private long adhar;
	private String address;
	private String gender;
	private long accountnumber;
	private double amount;
	private String branch;
	private String pannumber;
	private String status;
	private int pin;
	private String ifsccode;
	
}
