package utad.inso.dise�o.pociones;

import utad.inso.dise�o.estados.EstadoQuemado;
import utad.inso.dise�o.personajes.Personaje;

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

	@Override
	public float getValue() {
		return 0.0f;
	}
}
