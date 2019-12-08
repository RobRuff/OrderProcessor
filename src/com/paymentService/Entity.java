package com.paymentService;

public class Entity {
	private String address;
	private int amountPaid;
	
	public Entity(String address)
	{
		this.setAddress(address);
		amountPaid = 0;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void payEntity(int amount)
	{
		amountPaid += amount;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
}
