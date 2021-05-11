package Atributos;

public class ModificadorVida extends DecoradorVida {
	private int valor;
	private DecoradorVida decoradorVida;

	// Contructor
	public ModificadorVida(int valor, DecoradorVida decoradorVida){
		this.valor = valor;
		this.decoradorVida = decoradorVida;
	}

	// Getters y setters
	@Override
	public float getVida() {
		return decoradorVida.getVida() + valor;
	}
	@Override
	public DecoradorVida setVida(float valor) {
		// se realiza la operacion
		this.valor -= valor;
		// ... si se ha terminado la duraciondel decorador ...
		if(this.valor <= 0){
			// ... se le pasa el resto del valor al siguente deorador ...
			return decoradorVida.setVida(-this.valor);
		}
		// Si no se ha destruido el decorador se devuleve este,
		// y de esta manera mantenera descartar los decoradores rotos.
		return this;
	}

	public DecoradorVida getDecoradorVida(){
		return this.decoradorVida;
	}

	// Funciones
	@Override
	public String toString(float modificador) {
		return decoradorVida.toString(valor + modificador);
	}
}
