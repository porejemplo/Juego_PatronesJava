package utad.inso.dise�o.pociones;

import utad.inso.dise�o.estados.EstadoParalizado;
import utad.inso.dise�o.personajes.Personaje;

public class PocionAntiParalisis implements Pocion {
	public PocionAntiParalisis (){}

	@Override
	public void utiliar(Personaje person) {
        if (person.getEstado() instanceof EstadoParalizado)
		    person.setEstado(null);
	}

	@Override
	public boolean isAtaque() {
		return false;
	}

	@Override
	public String toString(){
		return "Pocion anti-Paralisis";
	}

	@Override
	public float getValue() {
		return 0.0f;
	}
}
