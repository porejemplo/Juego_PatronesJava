package utad.inso.diseño.atributos;

public class Vida implements DecoradorVida {
	private float vida;
	private float maxVida;

	public Vida (int vida){
		this.vida = vida;
		maxVida = vida;
	}

	@Override
	public float getValue() {
		return vida;
	}

	@Override
	public float getDiferencia() {
		return maxVida - vida;
	}

	@Override
	public DecoradorVida quitarVida(float valor) {
		vida -= valor;
		return this;
	}

	@Override
	public float darVida (float valor) {
		if (vida == maxVida)
			return valor;

		vida += valor;
		if (vida>maxVida) {
			valor = vida - maxVida;
			vida = maxVida;
			return valor;
		}
		return 0;
	}
	
	@Override
	public String toString(){
		return toString(0);
	}

	private String toString(float modificador) {
		return String.format("%.02f/%.0f", vida + modificador, maxVida);
	}

	@Override
	public String toString(float modificador, float vidaRestante) {
		return toString(modificador) + String.format(" +%.02f", vidaRestante);
	}
}
