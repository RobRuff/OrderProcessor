package com.paymentServiceTests;

import java.util.HashMap;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.paymentService.Book;
import com.paymentService.Entity;
import com.paymentService.Membership;
import com.paymentService.Payment;
import com.paymentService.ProductTypeEnum;
import com.paymentService.Video;

public class PaymentServiceTest {	
	
	@Test
	public void test_payBook()
	{
		HashMap<Object, ProductTypeEnum> products = new HashMap<>();
		products.put(new Book("Wizard of Oz"), ProductTypeEnum.BOOK);
		Payment payment = new Payment();
		payment.setProducts(products);
		
		Optional<Entity> agent = Optional.of(new Entity("123 Road, UK"));
		
		payment.setAgentWhoMadeSale(agent);
		
		Assert.assertTrue(payment.purchase() == 1);
		Assert.assertTrue(agent.get().getAmountPaid() ==  40);
	}
	
	@Test
	public void test_payVideo()
	{
		HashMap<Object, ProductTypeEnum> products = new HashMap<>();
		products.put(new Video("Learning to Ski"), ProductTypeEnum.VIDEO);
		Payment payment = new Payment();
		payment.setProducts(products);
		
		Optional<Entity> agent = Optional.of(new Entity("123 Road, UK"));
		
		payment.setAgentWhoMadeSale(agent);
		
		Assert.assertTrue(payment.purchase() == 1);
		Assert.assertTrue(agent.get().getAmountPaid() ==  40);
	}
	
	@Test
	public void test_activateMembership()
	{
		HashMap<Object, ProductTypeEnum> products = new HashMap<>();
		Membership membership = new Membership(true, "Santa", "hohoho@northpole.ca");
		Assert.assertTrue(!membership.isActive());
		products.put(membership, ProductTypeEnum.MEMBERSHIP);
		Payment payment = new Payment();
		payment.setProducts(products);
		
		Assert.assertTrue(payment.purchase() == 1);
		Assert.assertTrue(membership.isActive());
	}
	
	@Test
	public void test_upgradeMembership()
	{
		HashMap<Object, ProductTypeEnum> products = new HashMap<>();
		Membership membership = new Membership(false, "Santa", "hohoho@northpole.ca");
		Assert.assertTrue(!membership.isUpgraded());
		products.put(membership, ProductTypeEnum.MEMBERSHIP);
		Payment payment = new Payment();
		payment.setProducts(products);
		
		Assert.assertTrue(payment.purchase() == 1);
		Assert.assertTrue(membership.isUpgraded());
	}
	
	@Test
	public void test_payBookVideoMembership()
	{
		HashMap<Object, ProductTypeEnum> products = new HashMap<>();
		products.put(new Book("Wizard of Oz"), ProductTypeEnum.BOOK);
		Payment payment = new Payment();

		products.put(new Video("Learning to Ski"), ProductTypeEnum.VIDEO);
		
		Membership membership = new Membership(false, "Santa", "hohoho@northpole.ca");
		Assert.assertTrue(!membership.isUpgraded());
		products.put(membership, ProductTypeEnum.MEMBERSHIP);
				
		Optional<Entity> agent = Optional.of(new Entity("123 Road, UK"));
		
		payment.setAgentWhoMadeSale(agent);
		payment.setProducts(products);
		
		Assert.assertTrue(payment.purchase() == 3);
		Assert.assertTrue(agent.get().getAmountPaid() ==  80);
		Assert.assertTrue(membership.isUpgraded());
	}
	
}
