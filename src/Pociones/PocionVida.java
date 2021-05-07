package Pociones;

import Personajes.Personajes;

public class PocionVida implements Pocion {
	public int cantidad = 0;

	public PocionVida (int cantidad){
		this.cantidad = cantidad;
	}

	@Override
	public void utiliar(Personajes person) {
		person.setVida(cantidad);
	}
}
