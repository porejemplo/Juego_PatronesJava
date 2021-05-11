package Atributos;

public class Agilidad extends DecoradorAgilidad {
	private int value;

	public Agilidad (int value){
		this.value = value;
	}

	@Override
	public int getAgilidad() {
		return value;
	}

	@Override
	public String toString(int modificador) {
		return Integer.toString(value + modificador) + "\t +" + Integer.toString(modificador);
	}
}
