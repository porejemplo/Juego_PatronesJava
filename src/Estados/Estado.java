package Estados;

import Personajes.Personaje;

public interface Estado {
	void actuar (Personaje personaje);
	public int getDuracion();
	public String toString();
}