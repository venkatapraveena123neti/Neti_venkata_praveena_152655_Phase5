package com.cg.walletapplication.controller;



import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.walletapplication.beans.Customer;
import com.cg.walletapplication.beans.Transaction;
import com.cg.walletapplication.service.IWalletService;

@RestController
public class WalletController {
@Autowired
private IWalletService service;

@RequestMapping(value="/addcustomer",method=RequestMethod.POST)
public void addCustomer(@RequestBody Customer customer) {
	service.addCustomer(customer);
}

@RequestMapping("/showbalance/{mobileno}")
public BigDecimal showBalance(@PathVariable String mobileno) {
	return service.showBalance(mobileno);
}

@RequestMapping("/deposit/{mobileno}/{password}/{amount}")
public String deposit(@PathVariable String mobileno,@PathVariable String password,@PathVariable BigDecimal amount) {
	return service.deposit(mobileno,password,amount);
}

@RequestMapping("/show/{mobileno}")
public Customer showCustomer(@PathVariable String mobileno) {
	return service.showCustomer(mobileno);
}

@RequestMapping("/withdraw/{mobileno}/{password}/{amount}")
public String withdraw(@PathVariable String mobileno,@PathVariable String password,@PathVariable BigDecimal amount) {
	return service.withdraw(mobileno,password,amount);
}
@RequestMapping("/fundtransfer/{targetmobileno}/{sourcemobileno}/{password}/{amount}")
public String fundtrasfer(@PathVariable String targetmobileno,@PathVariable String sourcemobileno,@PathVariable String password,@PathVariable BigDecimal amount) {
	return service.fundtransfer(targetmobileno,sourcemobileno,password,amount);
}
@RequestMapping("/printtransactions/{mobileno}/{password}")
public LinkedHashSet<Transaction> printTransactions(@PathVariable String mobileno , @PathVariable String password) {
	Set<Transaction> mytransactions=service.printTransactions(mobileno,password);
	List<Transaction> transac=new  LinkedList<Transaction>(mytransactions);
	LinkedHashSet<Transaction> result = new LinkedHashSet<>();
	Collections.sort(transac,  new Comparator<Transaction>() {
		   

		public int compare(Transaction o1, Transaction o2) {
			// TODO Auto-generated method stub
			return o1.getDateOfTrans().compareTo(o2.getDateOfTrans());
		}
	});
	Iterator<Transaction> iterator = transac.iterator();
	while (iterator.hasNext()) {
		result.add( iterator.next());
		/*System.out.println(
				transaction.getDateOfTrans() +"     "+ transaction.getType() +"  "+ transaction.getAmount()+"   "+transaction.getBalance());
		System.out.println("--------------------------------------------------------------");*/
	}
	return result;
}
    
}


