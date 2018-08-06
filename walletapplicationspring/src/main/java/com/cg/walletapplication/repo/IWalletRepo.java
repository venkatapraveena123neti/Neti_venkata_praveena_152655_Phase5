package com.cg.walletapplication.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.walletapplication.beans.Customer;

@Repository("walletrepo")
public interface IWalletRepo extends CrudRepository<Customer, String> {

}
