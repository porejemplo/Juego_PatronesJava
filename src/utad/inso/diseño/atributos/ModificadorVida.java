package utad.inso.diseño.atributos;

public class ModificadorVida implements DecoradorVida {
	private int vida;
	private int vidaMaxima;
	private DecoradorVida decoradorVida;

	// Contructor
	public ModificadorVida(int valor){
		vida = valor;
		vidaMaxima = valor;
	}

	public void setDecoradorVida ( DecoradorVida decoradorVida) {
		this.decoradorVida = decoradorVida;
	}

	// Getters y setters
	@Override
	public float getDiferencia() {
		return vidaMaxima - vida;
	}

	@Override
	public float getValue() {
		return decoradorVida.getValue() + vida;
	}
	@Override
	public DecoradorVida quitarVida(float valor) {
		// se realiza la operacion
		vida -= valor;
		// ... si se ha terminado la duraciondel decorador ...
		if(vida <= 0){
			// ... se le pasa el resto del valor al siguente deorador ...
			return decoradorVida.quitarVida(-vida);
		}
		// Si no se ha destruido el decorador se devuleve este,
		// y de esta manera mantenera descartar los decoradores rotos.
		return this;
	}

	@Override
	public float darVida (float valor) {
		valor = decoradorVida.darVida(valor);
		if (valor > 1) {
			if (vida == vidaMaxima)
				return valor;
	
			vida += valor;
			if (vida>vidaMaxima) {
				valor = vida - vidaMaxima;
				vida = vidaMaxima;
				return valor;
			}
		}
		return 0;
	}

	public DecoradorVida getDecoradorVida(){
		return this.decoradorVida;
	}

	// Funciones
	@Override
	public String toString(float modificador, float vidaRestante) {
		return decoradorVida.toString(vida + modificador, vidaRestante);
	}

	@Override
	public String toString(){
		return toString(0, vidaMaxima - vida);
	}
}
