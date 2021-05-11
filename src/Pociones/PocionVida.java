package Pociones;

import Personajes.Personaje;

public class PocionVida implements Pocion {
	public float cantidad = 0;

	public PocionVida (float cantidad){
		this.cantidad = cantidad;
	}

	@Override
	public void utiliar(Personaje person) {
		person.curar(this.cantidad);
	}
}
