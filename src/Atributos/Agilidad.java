package Atributos;

public class Agilidad implements DecoradorAgilidad {
	private int value;

	public Agilidad (int value){
		this.value = value;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return toString(0);
	}

	@Override
	public String toString(int modificador) {
		return Integer.toString(value + modificador) + "/" + Integer.toString(value);
	}

	@Override
	public DecoradorAgilidad consumir() {
		return this;
	}
}
