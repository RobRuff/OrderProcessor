package com.paymentService;

public class CommissionPayment {
	private int amount;
	
	public CommissionPayment(int amount)
	{
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	} 
}
