package Atributos;

public class ModificadorDano implements DecoradorDano {
	private float dano;
	private float danoMaximo;
	private DecoradorDano decoradorDano;

	public ModificadorDano(float dano){
		this.dano = dano;
		danoMaximo = dano;
	}

	public void setDecoradorDano(DecoradorDano decoradorDano) {
		this.decoradorDano = decoradorDano;
	}

	@Override
	public float getValue() {
		return decoradorDano.getValue() + dano;
	}
	
	@Override
	public float getDanoMaximo() {
		return decoradorDano.getDanoMaximo() + danoMaximo;
	}

	@Override
	public DecoradorDano desafilar(float valor){
		// se realiza la operacion
		dano -= valor;
		// ... si se ha terminado la duracion del decorador ...
		if(dano <= 0){
			// ... se le pasa el resto del valor al siguente deorador ...
			return decoradorDano.desafilar(-dano);
		}
		// Si no se ha destruido el decorador se devuleve este,
		// y de esta manera mantenera descartar los decoradores rotos.
		return this;
	}
	
	// Aumenta el afilado del arma y los decoradores desde la base.
	@Override
	public float afilar(float valor) {
		valor = decoradorDano.afilar(valor);
		// si el decorador esta afilado
		if (dano == danoMaximo)
			return valor;

		dano += valor;
		// Si se ha sobre afilado se calcula el sobrante y se pasa al siguiente.
		if (dano>danoMaximo) {
			valor = dano - danoMaximo;
			dano = danoMaximo;
			return valor;
		}
		return 0;
	}

	@Override
	public String toString(float modificador, float danoRestante) {
		return decoradorDano.toString(dano + modificador, danoRestante);
	}

	@Override
	public String toString(){
		return toString(0, danoMaximo - dano);
	}
}
