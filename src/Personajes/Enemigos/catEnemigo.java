package Personajes.Enemigos;

public enum catEnemigo {
	guerrero(4,4,7,"Guerrero"),
	hechicero (4,7,4,"Hechicero"),
	mutante (7,4,4,"Mutante");

	private final int fuerza;
	private final int resistencia;
	private final int agilidad;
	private final String name;

	catEnemigo(int fuerza, int resistencia, int agilidad, String name){
		this.fuerza = fuerza;
		this.resistencia = resistencia;
		this.agilidad = agilidad;
		this.name = name;
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

	public String getName(){
		return name;
	}
}