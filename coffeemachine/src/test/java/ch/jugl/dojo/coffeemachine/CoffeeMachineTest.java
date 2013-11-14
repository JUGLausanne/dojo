package ch.jugl.dojo.coffeemachine;

import junit.framework.TestCase;
import ch.jugl.dojo.coffeemachine.CoffeeMachine.Beverage;

public class CoffeeMachineTest extends TestCase {

	private CoffeeMachine cf;

	public void setUp() {
		cf = new CoffeeMachine();
		cf.setMoney(100);
	}
	
	public void testOrderTeaWhithoutSugar() {
		assertEquals("T::", cf.order(Beverage.TEA, 0));
	}
	
	public void testOrderTeaWhithOneSugar() {
		assertEquals("T:1:0", cf.order(Beverage.TEA, 1));
	}
	
	public void testOrderTeaWhithTwoSugar() {
		assertEquals("T:2:0", cf.order(Beverage.TEA, 2));
	}
	
	public void testOrderChocolateWhithoutSugar() {
		assertEquals("H::", cf.order(Beverage.CHOCOLATE, 0));
	}

	public void testOrderChocolateWhithOneSugar() {
		assertEquals("H:1:0", cf.order(Beverage.CHOCOLATE, 1));
	}
	
	public void testOrderCoffeeWhithoutSugar() {
		assertEquals("C::", cf.order(Beverage.COFFEE, 0));
	}
	
	public void testOrderCoffeeWithOneSugar() {
		assertEquals("C:1:0", cf.order(Beverage.COFFEE, 1));
	}
	
	public void testShowMessage(){
		assertEquals("M:message", cf.sendMessage("message"));
	}

	public void testNoMoneyNoTea() { 
		cf.setMoney(0);
		assertEquals("M:0,40 missing", cf.order(Beverage.TEA, 1));
	}
	
	public void testNotEnoughMoneyForATea() { 
		cf.setMoney(30);
		assertEquals("M:0,10 missing", cf.order(Beverage.TEA, 1));
	}
	
	
	public void testNotEnoughMoneyForACoffee() { 
		cf.setMoney(30);
		assertEquals("M:0,30 missing", cf.order(Beverage.COFFEE, 1));
	}
	
	public void testNotEnoughMoneyForAChocolate() { 
		cf.setMoney(00);
		assertEquals("M:0,50 missing", cf.order(Beverage.CHOCOLATE, 1));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}










