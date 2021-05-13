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
	public DecoradorDano desafilar(float valor){
		this.dano -= valor;
		if (dano < this.danoMinimo)
			this.dano = danoMinimo;
		return this;
	}
	
	@Override
	public float afilar(float valor) {
		if (dano == danoMaximo)
			return valor;
			
		dano += valor;
		if (dano>danoMaximo) {
			valor = dano - danoMaximo;
			dano = danoMaximo;
			return valor;
		}
		return 0;
	}

	@Override
	public String toString(float modificador, float danoRestante) {
		return nombre + ": " + Float.toString(dano + modificador) + "/" + Float.toString(this.danoMaximo) + " +" + Float.toString(danoRestante);
	}

	@Override
	public String toString(){
		return toString(0, danoMaximo - dano);
	}
}
