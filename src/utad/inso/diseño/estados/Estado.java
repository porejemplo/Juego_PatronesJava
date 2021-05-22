package utad.inso.dise�o.estados;

import utad.inso.dise�o.personajes.Personaje;

public interface Estado {
	void actuar (Personaje personaje);
	public int getDuracion();
	public String toString();
}