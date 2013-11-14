package ch.jugl.dojo.coffeemachine;

public class CoffeeMachine {
	
	public int money = 0;
	public SalesReporting reporting = new SalesReporting();
	
	public void setMoney(int sous) {
		this.money = sous;
	}
	
	public String order(Beverage beverage) {
		return order(beverage, 0);
	}

	public String order(Beverage beverage, int sugarQuantity) {
		return order(beverage, sugarQuantity, Temperature.NORMAL);
	}

	public String order(Beverage beverage, int sugarQuantity, Temperature temperature) {
		if (money < beverage.price) {
			return sendMessage("0," + (beverage.price - money) + " missing");
		}
		
		money = 0;
		reporting.add(beverage);
		
		return beverage.code + temperature.code + ":"+ (sugarQuantity > 0 ? sugarQuantity +":0" : ":");
	}

	public String sendMessage(String string) {
		return "M:"+string;
	}

	public int getRevenue() {
		return reporting.getRevenue();
	}
	
	

}

