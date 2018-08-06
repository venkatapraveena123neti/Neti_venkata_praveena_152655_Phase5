package com.cg.walletapplication.service;

import java.math.BigDecimal;
import java.util.Set;

import com.cg.walletapplication.beans.Customer;
import com.cg.walletapplication.beans.Transaction;

public interface IWalletService {

	void addCustomer(Customer customer);

	BigDecimal showBalance(String mobileno);

	String deposit(String mobileno, String password, BigDecimal amount);

	Customer showCustomer(String mobileno);

	String withdraw(String mobileno, String password, BigDecimal amount);

	String fundtransfer(String targetmobileno, String sourcemobileno, String password, BigDecimal amount);

	Set<Transaction> printTransactions(String mobileno, String password);

}
