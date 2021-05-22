package utad.inso.diseño.atributos;

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
	public float getValue() {
		return dano;
	}

	@Override
	public float getDanoMaximo() {
		return danoMaximo;
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
	public String toString(){
		return toString(0, dano - danoMinimo);
	}

	@Override
	public String toString(float modificador, float danoRestante) {
		return String.format("%s: %.02f/%.02f +%.02f", nombre, dano + modificador, danoMaximo, danoRestante);
	}
}
