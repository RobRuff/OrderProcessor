package com.paymentService;

public class StrategyFactory {
	
	@SuppressWarnings("rawtypes")
	public static ActionStrategy getStrategy(ProductTypeEnum productType)
	{
		if(productType.equals(ProductTypeEnum.BOOK))
		{
			return new BookStrategy();	
		}
		else if(productType.equals(ProductTypeEnum.VIDEO))
		{
			return new VideoStrategy();
		}
		else if(productType.equals(ProductTypeEnum.MEMBERSHIP))
		{
			return new MembershipStrategy();
		}
		// Only gets here if a new product was added
		return null;
	}
}
