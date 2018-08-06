package com.cg.walletapplication.service;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cg.walletapplication.beans.Customer;
import com.cg.walletapplication.beans.Transaction;
import com.cg.walletapplication.repo.IWalletRepo;
//------------------------    Wallet Application --------------------------
		/*******************************************************************************************************
		 - Class Name	        :	         <WalletServiceImpl>
		 - Input Parameters	:	<null>
		 - Return Type		:	<null> <data type>
		 - Throws			:  	<Application_name>Exception
		 - Author			:	<Neti_venkata_praveena>
		 - Creation Date	:	06/08/2018
		 - Description		:	methods implementing from interface
		 ********************************************************************************************************/
@Service("walletservice")


public class WalletServiceImpl implements IWalletService{

	@Autowired
	private IWalletRepo repo;
	
	


	public void addCustomer(Customer customer) {
		
		repo.save(customer);
	}

	@Override
	public BigDecimal showBalance(String mobileno) {
	Customer customer = repo.findById(mobileno).get();
	return customer.getWallet().getBalance();
	}

	@Override
	@ModelAttribute("Transaction")
	public String deposit(String mobileno, String password, BigDecimal amount) {
		String result= null;
		Customer customer = repo.findById(mobileno).get();
		if(password.equals(customer.getPassword())) {
			customer.getWallet().setBalance(customer.getWallet().getBalance().add(amount));
			Transaction transaction = new Transaction();
		    transaction.setType("Debited");
		    transaction.setAmount(amount);
		    transaction.setBalance(customer.getWallet().getBalance());
		    java.util.Date today = new java.util.Date();
			transaction.setDateOfTrans( new java.sql.Timestamp(today.getTime()));
			transaction.setCustomer(customer);
			customer.addTransaction(transaction);
			repo.save(customer);
			result="Deposited Succesfully and your current balance is :" + customer.getWallet().getBalance();
			
		}
		return result;
	}

	@Override
	public Customer showCustomer(String mobileno) {
		return repo.findById(mobileno).get();
	}

	@Override
	@ModelAttribute("Transaction")
	public String withdraw(String mobileno, String password, BigDecimal amount) {
		String result= null;
		Customer customer = repo.findById(mobileno).get();
		if(password.equals(customer.getPassword()) && customer.getWallet().getBalance().compareTo(amount)>=0) {
			customer.getWallet().setBalance(customer.getWallet().getBalance().subtract(amount));
			Transaction transaction = new Transaction();
		    transaction.setType("Credited");
		    transaction.setAmount(amount);
		    transaction.setBalance(customer.getWallet().getBalance());
		    java.util.Date today = new java.util.Date();
			transaction.setDateOfTrans( new java.sql.Timestamp(today.getTime()));
			transaction.setCustomer(customer);
			customer.addTransaction(transaction);
			repo.save(customer);
			result="Withdrawn Succesfully and your current balance is :" + customer.getWallet().getBalance();
		}
		return result;
	}

	@Override
	public String fundtransfer(String targetmobileno, String sourcemobileno, String password, BigDecimal amount) {
		String result=null;
		if(repo.findById(targetmobileno).get()!=null)
		{
			Customer source = repo.findById(sourcemobileno).get();
			if(source!=null&& withdraw(sourcemobileno, password, amount)!=null) {
				deposit(targetmobileno, repo.findById(targetmobileno).get().getPassword(), amount);
				result="Transferred Succesfully and your current balance is :" + source.getWallet().getBalance();
			}
		}
		return result;
	}

	@Override
	public Set<Transaction> printTransactions(String mobileno, String password) {
		Customer customer = repo.findById(mobileno).get();
		if(password.equals(customer.getPassword())) {
			return customer.getTransactions();
		}
		return null;
	}
	
}
