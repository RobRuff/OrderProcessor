package com.paymentService;

import java.util.Optional;

public interface ActionStrategy <T>{
	void purchase(T product);
	void purchase(T product, Optional<Entity> agentWhoMadeSale);
}
