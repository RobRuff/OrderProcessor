package com.paymentService;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Optional;

public class Payment {
	private HashMap<Object, ProductTypeEnum> products;
	private Optional<Entity> agentWhoMadeSale;
	
	public HashMap<Object, ProductTypeEnum> getProducts() {
		return products;
	}

	public void setProducts(HashMap<Object, ProductTypeEnum> products) {
		this.products = products;
	}

	public Optional<Entity> getAgentWhoMadeSale() {
		return agentWhoMadeSale;
	}

	public void setAgentWhoMadeSale(Optional<Entity> agentWhoMadeSale) {
		this.agentWhoMadeSale = agentWhoMadeSale;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int purchase()
	{
		int itemsPurchased = 0;
		for(Entry<Object, ProductTypeEnum> entry : products.entrySet())
		{
			ActionStrategy strategy = StrategyFactory.getStrategy(entry.getValue());
			
			if(entry.getValue().equals(ProductTypeEnum.BOOK))
			{
				strategy.purchase((Book)entry.getKey(), agentWhoMadeSale);
			}
			else if(entry.getValue().equals(ProductTypeEnum.VIDEO))
			{
				strategy.purchase((Video)entry.getKey(), agentWhoMadeSale);
			}
			else if(entry.getValue().equals(ProductTypeEnum.MEMBERSHIP))
			{
				strategy.purchase((Membership)entry.getKey());
			}
			itemsPurchased++;
		}
		return itemsPurchased;
	}
}
