package utad.inso.diseño.atributos;

public class ModificadorAgilidad implements DecoradorAgilidad {
	private int valor;
	private int duracion;
	private DecoradorAgilidad decoradorAgilidad;

	public ModificadorAgilidad(int valor, int duracion){
		this.valor = valor;
		this.duracion = duracion;
	}

	public void setDecoradorAgilidad (DecoradorAgilidad decoradorAgilidad){
		this.decoradorAgilidad = decoradorAgilidad;
	}

	@Override
	public int getValue() {
		return decoradorAgilidad.getValue() + valor;
	}

	@Override
	public String toString() {
		return  toString(0);
	}

	@Override
	public String toString(int modificador) {
		String auxString = decoradorAgilidad.toString(valor + modificador) + "\t";
		if (valor > 0) {
			auxString += "+";
		}
		auxString += Integer.toString(valor) + ":" + Integer.toString(duracion);
		return  auxString;
	}

	@Override
	public DecoradorAgilidad consumir() {
		decoradorAgilidad = decoradorAgilidad.consumir();
		duracion--;
		if (duracion > 0) {
			return this;
		}
		return decoradorAgilidad;
	}
}
