package Atributos;

public class Arma implements DecoradorDano {
	private String nombre;
	private float dano;
	private float danoMinimo;
	private float danoMaximo;

	// Se le pasa la fuerza ente 0-1
	public Arma(String nombre, float dano, float fuerza){
		this.nombre = nombre;
		this.dano = dano;
		danoMinimo = dano * fuerza;
		danoMaximo = dano;
	}

	@Override
	public float getValue(float i) {
		return dano + i;
	}

	@Override
	public float getDanoMaximo(float danoMaximo) {
		return danoMaximo + this.danoMaximo;
	}

	@Override
	public void desafilar(float val){
		this.dano -= val;
		if (dano < this.danoMinimo)
			this.dano = danoMinimo;
	}
	
	@Override
	public float afilar(float val) {
		if (dano == danoMaximo)
			return val;
			
		dano += val;
		if (dano>danoMaximo) {
			val = dano - danoMaximo;
			dano = danoMaximo;
			return val;
		}
		return 0;
	}

	@Override
	public String toString(float modificador, float danoMaximo) {
		return nombre + ": " + Float.toString(dano + modificador) + "/" + Float.toString(danoMaximo) + " " + Float.toString(modificador);
	}	
}
