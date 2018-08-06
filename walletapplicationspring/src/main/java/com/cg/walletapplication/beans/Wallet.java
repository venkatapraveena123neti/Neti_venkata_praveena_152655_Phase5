package com.cg.walletapplication.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
            //------------------------    Wallet Application --------------------------
		/*******************************************************************************************************
		 - Class Name	        :	         <Wallet>
		 - Input Parameters	:	<null>
		 - Return Type		:	<null> <data type>
		 - Throws			:  	<Application_name>Exception
		 - Author			:	<Neti_venkata_praveena>
		 - Creation Date	:	06/08/2018
		 - Description		:	bean class to connect to database embedded to customer class
		 ********************************************************************************************************/
@Embeddable
public class Wallet implements Serializable {
	private static final long serialVersionUID = 1156737872192523305L;
	@Column(name="Balance")
	private BigDecimal balance;
	
	public Wallet() {
		this.balance=BigDecimal.valueOf(0.0);
	}

	
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
