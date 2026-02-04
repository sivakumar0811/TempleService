package com.tutasi.dto;

public class BalanceAmount {

	private Integer balanceAmount;

	

	public Integer getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Integer balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	
	@Override
	public String toString() {
		return "BalanceAmount [balanceAmount=" + balanceAmount + "]";
	}
}
