package utad.inso.diseño.pociones;

import utad.inso.diseño.estados.EstadoQuemado;
import utad.inso.diseño.personajes.Personaje;

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
