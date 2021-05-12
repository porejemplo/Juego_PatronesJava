package Atributos;

public class Arma extends DecoradorDano {
	private String nombre;
	private int dano;
	private int danoMinimo;

	public Arma(String nombre, double dano, double fuerza){
		this.nombre = nombre;
		this.dano = (int) dano;
		danoMinimo = (int) (dano * fuerza);
	}

	@Override
	public int getValue(int i) {
		return dano + i;
	}

	public void desafilar(int val){
		this.dano -= val;
		if (dano < this.danoMinimo)
			this.dano = danoMinimo;
	}

	@Override
	public String toString(int modificador) {
		return nombre + ": " +Integer.toString(dano + modificador) + " " + Integer.toString(modificador);
	}
	
}
