package utad.inso.dise�o.pociones;

import utad.inso.dise�o.atributos.ModificadorAgilidad;
import utad.inso.dise�o.personajes.Personaje;

public class PocionAgilidad implements Pocion {
	private int valor;
	private int duracion;

	public PocionAgilidad(int valor, int duracion) {
		this.valor = valor;
		this.duracion = duracion;
	}

	@Override
	public void utiliar(Personaje person) {
		person.addAgilidad(new ModificadorAgilidad(valor, duracion));
	}

	@Override
	public boolean isAtaque() {
		if (valor < 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString(){
		String auxString = "Pocion Agilidad ";
		if (valor > 0) {
			auxString += "+";
		}
		auxString += Integer.toString(valor) + " y duracion: " + Integer.toString(duracion);
		return auxString;
	}

	@Override
	public float getValue() {
		return (float)valor;
	}
}
