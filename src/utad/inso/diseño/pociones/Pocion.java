package utad.inso.diseño.pociones;

import utad.inso.diseño.personajes.Personaje;

public interface Pocion {
	// Se le va a pasar la referencia del propio personaje y cada pocion hara su porio efecto.
	void utiliar (Personaje person);
	public boolean isAtaque();
	public String toString();
	public float getValue();
}
