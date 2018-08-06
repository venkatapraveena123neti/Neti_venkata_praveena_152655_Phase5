package com.cg.walletapplication.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
