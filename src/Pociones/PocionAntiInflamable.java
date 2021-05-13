package Pociones;

import Estados.EstadoQuemado;
import Personajes.Personaje;

public class PocionAntiInflamable implements Pocion {
	public PocionAntiInflamable (){}

	@Override
	public void utiliar(Personaje person) {
        if (person.getEstado() instanceof EstadoQuemado)
		    person.setEstado(null);
	}

	@Override
	public boolean isAtaque() {
		return false;
	}

	@Override
	public String toString(){
		return "Pocion anti-quemaduras";
	}
}
