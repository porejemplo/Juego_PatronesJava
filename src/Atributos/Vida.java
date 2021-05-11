package Atributos;

public class Vida extends DecoradorDefensa {
	private float valor;
	private float maxVida;

	public Vida (int vida){
		this.valor = vida;
		maxVida = vida;
	}

	@Override
	public float getDefensa() {
		return valor;
	}

	@Override
	public DecoradorDefensa setDefensa(float valor) {
		this.valor -= valor;
		if(this.valor <= 0){
			// TODO meter una llamada al game manager para terminar el juego.
			System.out.println("Personaje muerto.");
		}
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
		return Float.toString(modificador) + " " + Float.toString(valor) + "/" + Float.toString(maxVida);
	}

}
