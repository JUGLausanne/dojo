package ch.jugl.dojo.coffeemachine;

public class CoffeeMachine {
	
	public int sous = 0;
	
	public void setMoney(int sous) {
		this.sous = sous;
	}
	
	public static enum Beverage {
		TEA("T",40), CHOCOLATE("H",50), COFFEE("C",60);
		String code;
		int price;
		private Beverage(String code, int price) {
			this.code = code;
			this.price = price;
		}
	}; 
	
	public String order(Beverage beverage, int sugarQuantity) {
		if(sous<beverage.price) {
			return sendMessage("0," + (beverage.price - sous) + " missing");
		}
		return beverage.code + ":"+ (sugarQuantity > 0 ? sugarQuantity +":0" : ":");
	}

	public String sendMessage(String string) {
		return "M:"+string;
	}
	
	

}

