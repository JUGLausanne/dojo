package ch.jugl.dojo.coffeemachine;

import static ch.jugl.dojo.coffeemachine.Beverage.*; 
import junit.framework.TestCase;

public class SalesReportingTest extends TestCase {

	public SalesReporting sr;
	
	public void setUp() {
		sr = new SalesReporting();	
	}
	
	public void testRevenueForZeroCoffee() {
		assertEquals(0, sr.getRevenue());
	}

	public void testRevenueForOneCoffee() {
		sr.add(COFFEE);
		assertEquals(COFFEE.price, sr.getRevenue());
	}

	public void testSalesReportingShouldSumRevenue() {
		sr.add(COFFEE);
		sr.add(CHOCOLATE);
		assertEquals(COFFEE.price + CHOCOLATE.price, sr.getRevenue());
	} 
	
	public void testBeverageCountForZeroBeverage() {
		assertEquals(0, sr.getCount(COFFEE));
	}
	
	public void testBeverageCountForSomeBeverages() {
		sr.add(COFFEE);
		sr.add(CHOCOLATE);
		assertEquals(1, sr.getCount(COFFEE));
		assertEquals(0, sr.getCount(TEA));
		assertEquals(1, sr.getCount(CHOCOLATE));
	}
}
