package Pociones;

import Personajes.Personaje;

public class PocionVida implements Pocion {
	private float valor;

	public PocionVida (float valor){
		this.valor = valor;
	}

	@Override
	public void utiliar(Personaje person) {
		person.curar(this.valor);
	}

	@Override
	public boolean getAtaque() {
		return false;
	}
}
