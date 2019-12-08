package com.paymentService;

import java.util.Optional;

public class MembershipStrategy implements ActionStrategy<Membership> {

	@Override
	public void purchase(Membership product) {
		if(product.isActive())
		{
			product.setUpgraded(true);
		}
		else
		{
			product.setActive(true);
		}
		EmailManager emailManager = new EmailManager();
		emailManager.sendEmail(product.getOwnerEmail(), "Your account has been " + (product.isUpgraded() ? " upgraded." : " activated."));
	}

	@Override
	public void purchase(Membership product, Optional<Entity> agentWhoMadeSale) {
		// TODO Auto-generated method stub
		
	}

}
