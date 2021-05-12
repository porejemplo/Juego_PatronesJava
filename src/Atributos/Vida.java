package Atributos;

public class Vida extends DecoradorVida {
	private float valor;
	private float maxVida;

	public Vida (int vida){
		this.valor = vida;
		maxVida = vida;
	}

	@Override
	public float getVida() {
		return valor;
	}

	@Override
	public DecoradorVida setVida(float valor) {
		this.valor -= valor;
		return this;
	}

	// Funciones
	public void curar(float valor){
		this.valor += valor;
		if (this.valor > maxVida){
			this.valor = maxVida;
		}
	}

	@Override
	public String toString(float modificador) {
		return Float.toString(modificador) + " " + Float.toString(valor) + "/" + Integer.toString((int)maxVida);
	}

}
