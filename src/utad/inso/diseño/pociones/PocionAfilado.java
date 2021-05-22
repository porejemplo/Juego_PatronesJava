package utad.inso.diseño.pociones;

import utad.inso.diseño.personajes.Personaje;

public class PocionAfilado implements Pocion {
	private int valor;

	public PocionAfilado(int valor){
		this.valor = valor;
	}

	@Override
	public void utiliar(Personaje person) {
		person.getDecoradorDano().afilar(valor);
	}

	@Override
	public boolean isAtaque() {
		return false;
	}

	@Override
	public String toString(){
		return "Pocion de Afilado: " + Integer.toString(valor) + " puntos.";
	}

	@Override
	public float getValue() {
		return (float)valor;
	}
}
