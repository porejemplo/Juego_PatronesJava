package Atributos;

public class Vida implements DecoradorVida {
	private float vida;
	private float maxVida;

	public Vida (int vida){
		this.vida = vida;
		maxVida = vida;
	}

	@Override
	public float getVida() {
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

	// Funciones
	// public void curar(float valor){
	// 	vida += valor;
	// 	if (vida > maxVida){
	// 		vida = maxVida;
	// 	}
	// }

	@Override
	public String toString(float modificador, float vidaRestante) {
		return Float.toString(vida + modificador) + "/" + Float.toString(maxVida) + " +" + Float.toString(vidaRestante);
	}

	@Override
	public String toString(){
		return toString(0, maxVida - vida);
	}
}
