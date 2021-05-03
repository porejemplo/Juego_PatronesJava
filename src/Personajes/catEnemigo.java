package Personajes;

public enum catEnemigo {
	guerrero(1,2,3),
	hechicero (1,1,2),
	mutante (3,2,1);

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
