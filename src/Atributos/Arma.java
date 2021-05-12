package Atributos;

public class Arma extends DecoradorDano {
	private String nombre;
	private float dano;
	private float danoMinimo;

	// Se le pasa la fuerza ente 0-1
	public Arma(String nombre, float dano, float fuerza){
		this.nombre = nombre;
		this.dano = dano;
		danoMinimo = dano * fuerza;
	}

	@Override
	public float getValue(float i) {
		return dano + i;
	}

	public void desafilar(int val){
		this.dano -= val;
		if (dano < this.danoMinimo)
			this.dano = danoMinimo;
	}

	@Override
	public String toString(float modificador) {
		return nombre + ": " + Float.toString(dano + modificador) + " " + Float.toString(modificador);
	}
	
}
