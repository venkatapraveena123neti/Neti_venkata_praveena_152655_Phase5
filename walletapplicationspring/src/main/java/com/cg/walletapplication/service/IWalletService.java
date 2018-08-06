package com.cg.walletapplication.service;

import java.math.BigDecimal;
import java.util.Set;

import com.cg.walletapplication.beans.Customer;
import com.cg.walletapplication.beans.Transaction;
  //------------------------    Wallet Application --------------------------
		/*******************************************************************************************************
		 - Interface Name	        :	         <IWalletService>
		 - Input Parameters	:	<null>
		 - Return Type		:	<null> <data type>
		 - Throws			:  	<Application_name>Exception
		 - Author			:	<Neti_venkata_praveena>
		 - Creation Date	:	06/08/2018
		 - Description		:	methods declaration
		 ********************************************************************************************************/
public interface IWalletService {

	void addCustomer(Customer customer);

	BigDecimal showBalance(String mobileno);

	String deposit(String mobileno, String password, BigDecimal amount);

	Customer showCustomer(String mobileno);

	String withdraw(String mobileno, String password, BigDecimal amount);

	String fundtransfer(String targetmobileno, String sourcemobileno, String password, BigDecimal amount);

	Set<Transaction> printTransactions(String mobileno, String password);

}
