package Pociones;

import Personajes.Personajes;

public class PocionVida implements Pocion {
	public float cantidad = 0;

	public PocionVida (float cantidad){
		this.cantidad = cantidad;
	}

	@Override
	public void utiliar(Personajes person) {
		person.curar(this.cantidad);
	}
}
