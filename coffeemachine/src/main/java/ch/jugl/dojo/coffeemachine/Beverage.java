package ch.jugl.dojo.coffeemachine;

public  enum Beverage {
	TEA("T",40), CHOCOLATE("H",50), COFFEE("C",60), ORANGE_JUICE("O",60);
	String code;
	int price;
	private Beverage(String code, int price) {
		this.code = code;
		this.price = price;
	}
}


