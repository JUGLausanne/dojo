package ch.jugl.dojo.coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class SalesReporting {

	private Map<Beverage, Integer> sales = new HashMap<Beverage, Integer>();
	
	public void add(Beverage beverage) {
		sales.put(beverage, (sales.get(beverage) == null ? 0 :  sales.get(beverage)) + 1);
	}

	public int getRevenue() {
		int revenue = 0;
		for (Beverage b : sales.keySet()){
			revenue += b.price * sales.get(b);
		}
		return revenue;	
	}
	
	public int getCount(Beverage beverage){
		return sales.get(beverage) == null ? 0 :  sales.get(beverage);
	}
}
