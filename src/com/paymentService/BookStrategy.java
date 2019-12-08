package com.paymentService;

import java.util.Optional;


public class BookStrategy implements ActionStrategy<Book>{

	@Override
	public void purchase(Book product) {
		PackagingManager packagingManager = new PackagingManager();
		PackagingSlip packaging = new PackagingSlip(SystemProperties.SHIPPING);
		packagingManager.sendPackagingSlip(packaging);
		packaging.setRecipient(SystemProperties.ROYALTY_DEPARTMENT);
		packagingManager.sendPackagingSlip(packaging);
	}

	@Override
	public void purchase(Book product, Optional<Entity> agentWhoMadeSale) {
		PackagingManager packagingManager = new PackagingManager();
		PackagingSlip packaging = new PackagingSlip(SystemProperties.SHIPPING);
		packagingManager.sendPackagingSlip(packaging);
		packaging.setRecipient(SystemProperties.ROYALTY_DEPARTMENT);
		packagingManager.sendPackagingSlip(packaging);
		
		if(agentWhoMadeSale.isPresent())
		{
			CommissionProcessor commissionProcessor = new CommissionProcessor();
			CommissionPayment commission = new CommissionPayment(40);
			
			commissionProcessor.payAgent(agentWhoMadeSale.get(), commission);
		}
	}

}
