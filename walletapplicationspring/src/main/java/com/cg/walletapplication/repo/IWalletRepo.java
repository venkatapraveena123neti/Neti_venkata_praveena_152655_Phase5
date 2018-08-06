package com.cg.walletapplication.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.walletapplication.beans.Customer;
  //------------------------    Wallet Application --------------------------
		/*******************************************************************************************************
		 - Interface Name	        :	         <IWalletRepo>
		 - Input Parameters	:	<null>
		 - Return Type		:	<null> <data type>
		 - Throws			:  	<Application_name>Exception
		 - Author			:	<Neti_venkata_praveena>
		 - Creation Date	:	06/08/2018
		 - Description		:	interface extends Crud to perform operations
		 ********************************************************************************************************/
@Repository("walletrepo")
public interface IWalletRepo extends CrudRepository<Customer, String> {

}
