package Pociones;

import Personajes.EstadoParalizado;
import Personajes.Personaje;

public class PocionAntiParalisis implements Pocion {
	public PocionAntiParalisis (){}

	@Override
	public void utiliar(Personaje person) {
        if (person.getEstado() instanceof EstadoParalizado)
		    person.setEstado(null);
	}

	@Override
	public boolean getAtaque() {
		return false;
	}

	@Override
	public String toString(){
		return "Pocion anti Paralisis";
	}
}
