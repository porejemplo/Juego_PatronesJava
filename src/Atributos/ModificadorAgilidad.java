package Atributos;

public class ModificadorAgilidad extends DecoradorAgilidad {
	private int valor;
	private DecoradorAgilidad decoradorAgilidad;

	public ModificadorAgilidad(int valor, DecoradorAgilidad decoradorAgilidad){
		this.valor = valor;
		this.decoradorAgilidad = decoradorAgilidad;
	}

	@Override
	public int getAgilidad() {
		return decoradorAgilidad.getAgilidad() + valor;
	}

	@Override
	public String toString(int modificador) {
		return decoradorAgilidad.toString(valor + modificador);
	}
}
