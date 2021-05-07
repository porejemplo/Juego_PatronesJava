package Personajes;

public abstract class Personajes {
	
	private int vida;
	private int ataque;
	private int agilidad;
	private String nombre;

	public Personajes(int vida, int ataque, int agilidad, String nombre) {
		this.vida = vida;
		this.ataque = ataque;
		this.agilidad = agilidad;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	protected void morir(){
		System.out.println("Muerto");
	}
	
	protected int getVida() {
		return vida;
	}

    // No pone la cantidad de vida sino que modifica la vida de pendiendo de la cantidad.
	public void setVida(int cantidar) {
		vida += cantidar;
		if (vida<=0)
			morir();
	}

	protected int getAtaque() {
		return ataque;
	}

	protected void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getAgilidad() {
		return agilidad;
	}

	protected void setAgilidad(int agilidad) {
		this.agilidad = agilidad;
	}

	abstract void accion();
	
}
/*
Clase abstracta que sirve como base de todos los personajes,
	El jugador elegira al principio de la partida uno de estos.
*/
