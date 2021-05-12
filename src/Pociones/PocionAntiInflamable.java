package Pociones;

import Personajes.EstadoQuemado;
import Personajes.Personaje;

public class PocionAntiInflamable implements Pocion {
	public PocionAntiInflamable (){}

	@Override
	public void utiliar(Personaje person) {
        if (person.getEstado() instanceof EstadoQuemado)
		    person.setEstado(null);
	}

	@Override
	public boolean getAtaque() {
		return false;
	}

	@Override
	public String toString(){
		return "Pocion anti fuego";
	}
}
