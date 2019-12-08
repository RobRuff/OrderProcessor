package com.paymentService;

public class CommissionProcessor {

	public void payAgent(Entity entity, CommissionPayment commision) {
		entity.payEntity(commision.getAmount());
	}
}
