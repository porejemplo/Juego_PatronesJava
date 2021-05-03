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

	public void recivirDano(int dano){
		vida -= dano;
		if (vida<=0)
			morir();
	}

	public void morir(){
		System.out.println("Muerto");
	}
	
	protected int getVida() {
		return vida;
	}

	protected void setVida(int vida) {
		this.vida = vida;
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
