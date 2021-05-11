package Atributos;

public class ModificadorDefensa extends DecoradorDefensa {
	private int valor;
	private DecoradorDefensa decoradorDefensa;

	// Contructor
	public ModificadorDefensa(int valor, DecoradorDefensa decoradorDefensa){
		this.valor = valor;
		this.decoradorDefensa = decoradorDefensa;
	}

	// Getters y setters
	@Override
	public float getDefensa() {
		return decoradorDefensa.getDefensa() + valor;
	}
	@Override
	public DecoradorDefensa setDefensa(float valor) {
		// se realiza la operacion
		this.valor -= valor;
		// ... si se ha terminado la duraciondel decorador ...
		if(this.valor <= 0){
			// ... se le pasa el resto del valor al siguente deorador ...
			return decoradorDefensa.setDefensa(-this.valor);
		}
		// Si no se ha destruido el decorador se devuleve este,
		// y de esta manera mantenera descartar los decoradores rotos.
		return this;
	}

	public DecoradorDefensa getDecoradorDefensa(){
		return this.decoradorDefensa;
	}

	// Funciones
	@Override
	public String toString(float modificador) {
		return decoradorDefensa.toString(valor + modificador);
	}
}
