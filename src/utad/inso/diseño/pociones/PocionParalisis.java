package utad.inso.diseño.pociones;

import utad.inso.diseño.estados.EstadoParalizado;
import utad.inso.diseño.personajes.Personaje;

public class PocionParalisis implements Pocion {
	private int valor;
	private int duracion;

	public PocionParalisis(int valor, int duracion) {
		this.valor = valor;
		this.duracion = duracion;
	}

	@Override
	public void utiliar(Personaje person) {
		person.setEstado(new EstadoParalizado(valor, duracion));
	}

	@Override
	public boolean isAtaque() {
		return true;
	}

	@Override
	public String toString(){
		return "Pocion Agilidad " + Integer.toString(valor) + " y duracion: " + Integer.toString(duracion);
	}

	@Override
	public float getValue() {
		return (float)valor;
	}
}
