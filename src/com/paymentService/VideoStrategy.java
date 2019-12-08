package com.paymentService;

import java.util.Optional;

public class VideoStrategy implements ActionStrategy<Video> {

	@Override
	public void purchase(Video product) {
		PackagingManager packagingManager = new PackagingManager();
		PackagingSlip packaging = new PackagingSlip(SystemProperties.SHIPPING);
		if(product.getName() != null && product.getName().equals("Learning to Ski"))
		{
			packaging.addBonusVideo(new Video("First Aid"));
		}
		packagingManager.sendPackagingSlip(packaging);
	}

	@Override
	public void purchase(Video product, Optional<Entity> agentWhoMadeSale) {
		PackagingManager packagingManager = new PackagingManager();
		PackagingSlip packaging = new PackagingSlip(SystemProperties.SHIPPING);
		if(product.getName() != null && product.getName().equals("Learning to Ski"))
		{
			packaging.addBonusVideo(new Video("First Aid"));
		}
		packagingManager.sendPackagingSlip(packaging);
		
		if(agentWhoMadeSale.isPresent())
		{
			CommissionProcessor commissionProcessor = new CommissionProcessor();
			CommissionPayment commission = new CommissionPayment(40);
			
			commissionProcessor.payAgent(agentWhoMadeSale.get(), commission);
		}
	}

}
