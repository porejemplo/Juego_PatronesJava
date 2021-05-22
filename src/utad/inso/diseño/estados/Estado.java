package utad.inso.diseño.estados;

import utad.inso.diseño.personajes.Personaje;

public interface Estado {
	void actuar (Personaje personaje);
	public int getDuracion();
	public String toString();
}