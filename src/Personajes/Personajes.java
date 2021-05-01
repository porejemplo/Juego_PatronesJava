package Personajes;

public abstract class Personajes {
	
	private int vida;
	private int ataque;
	private int agilidad;
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getAgilidad() {
		return agilidad;
	}
	public void setAgilidad(int agilidad) {
		this.agilidad = agilidad;
	}
	
	public Personajes(int vida, int ataque, int agilidad) {
		this.vida = vida;
		this.ataque = ataque;
		this.agilidad = agilidad;
	}
	
}
/*
Clase abstracta que sirve como base de todos los personajes,
	El jugador elegira al principio de la partida uno de estos.
*/
