package ch.jugl.dojo.coffeemachine;

import junit.framework.TestCase;
import static ch.jugl.dojo.coffeemachine.Beverage.*;
import static ch.jugl.dojo.coffeemachine.Temperature.*;

public class CoffeeMachineTest extends TestCase {

	private CoffeeMachine cf;

	public void setUp() {
		cf = new CoffeeMachine();
		cf.setMoney(100);
	}

	public void testOrderTeaWhithoutSugar() {
		assertEquals("T::", cf.order(TEA));
	}

	public void testOrderTeaWhithOneSugar() {
		assertEquals("T:1:0", cf.order(TEA, 1));
	}

	public void testOrderTeaWhithTwoSugar() {
		assertEquals("T:2:0", cf.order(TEA, 2));
	}

	public void testOrderChocolateWhithoutSugar() {
		assertEquals("H::", cf.order(CHOCOLATE));
	}

	public void testOrderChocolateWhithOneSugar() {
		assertEquals("H:1:0", cf.order(CHOCOLATE, 1));
	}

	public void testOrderCoffeeWhithoutSugar() {
		assertEquals("C::", cf.order(COFFEE));
	}

	public void testOrderCoffeeWithOneSugar() {
		assertEquals("C:1:0", cf.order(COFFEE, 1));
	}

	public void testShowMessage() {
		assertEquals("M:message", cf.sendMessage("message"));
	}

	public void testNoMoneyNoTea() {
		cf.setMoney(0);
		assertEquals("M:0,40 missing", cf.order(TEA, 1));
	}

	public void testNotEnoughMoneyForATea() {
		cf.setMoney(30);
		assertEquals("M:0,10 missing", cf.order(TEA, 1));
	}

	public void testNotEnoughMoneyForACoffee() {
		cf.setMoney(30);
		assertEquals("M:0,30 missing", cf.order(COFFEE, 1));
	}

	public void testNotEnoughMoneyForAChocolate() {
		cf.setMoney(00);
		assertEquals("M:0,50 missing", cf.order(CHOCOLATE, 1));
	}

	public void testWithExactMoneyForAChocolate() {
		cf.setMoney(50);
		assertEquals("H:1:0", cf.order(CHOCOLATE, 1));
	}

	public void testThatWeCannotBuyTwoCoffeesAtOnce() {
		cf.setMoney(10000);
		cf.order(COFFEE);
		assertEquals("M:0,60 missing", cf.order(COFFEE, 1));
	}

	public void testOrderOrangeJuice() {
		assertEquals("O::", cf.order(ORANGE_JUICE));
	}

	public void testNotEnoughMoneyForOrangeJuice() {
		cf.setMoney(30);
		assertEquals("M:0,30 missing", cf.order(ORANGE_JUICE));
	}

	public void testOrderExtraHotBeverage() {
		assertEquals("Ch:1:0", cf.order(COFFEE, 1, EXTRA_HOT));
		cf.setMoney(40);
		assertEquals("Th:1:0", cf.order(TEA, 1, EXTRA_HOT));

	}
	
	public void testRevenue() {
		cf.order(COFFEE);
		assertEquals(COFFEE.price, cf.getRevenue());
	}	

}
