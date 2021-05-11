package Personajes;

public enum catEnemigo {
	guerrero(4,4,7),
	hechicero (4,7,4),
	mutante (7,4,4);

	private final int fuerza;
	private final int resistencia;
	private final int agilidad;

	catEnemigo(int fuerza, int resistencia, int agilidad){
		this.fuerza = fuerza;
		this.resistencia = resistencia;
		this.agilidad = agilidad;
	}

	public int getAgilidad() {
		return agilidad;
	}

	public int getResistencia() {
		return resistencia;
	}

	public int getFuerza() {
		return fuerza;
	}
}
