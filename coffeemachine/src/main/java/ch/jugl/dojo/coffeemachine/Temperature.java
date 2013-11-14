package ch.jugl.dojo.coffeemachine;

public enum Temperature {
	NORMAL(""), EXTRA_HOT("h");
	String code;

	private Temperature(String code) {
		this.code = code;
	}
}
