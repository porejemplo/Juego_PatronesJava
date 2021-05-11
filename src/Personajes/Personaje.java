package Personajes;

import Atributos.*;

public abstract class Personaje {
	private DecoradorDano dano;
	// Porcentage el dano del arma que no se peirde en afilado.
	private float fuerza;
	private DecoradorVida vida;
	// provabilidad de parar un ataque al defenderse.
	private float defensa;
	private DecoradorAgilidad agilidad;
	private String nombre;
	public boolean paralizado = false;
	private Estado estado;

	// Contructor
	public Personaje (int fuerza, int vida, int agilidad, String nombre){
		this.fuerza = ((float)fuerza)/10;
		this.vida = new Vida((int)vida);
		this.defensa = vida;
		this.agilidad = new Agilidad(agilidad);
		this.nombre = nombre;
	}

	// Get y Set -----------------------------------------------------------------------------
	public String getNombre() {
		return nombre;
	}
	
	protected DecoradorDano getDano() {
		return this.dano;
	}
	protected void setDano(DecoradorDano dano) {
		this.dano = dano;
	}
	
	protected DecoradorVida getVida() {
		return vida;
	}
	protected void setVida(DecoradorVida vida) {
		this.vida = vida;
	}
	
	protected DecoradorAgilidad getAgilidad() {
		return agilidad;
	}
	protected void setAgilidad(DecoradorAgilidad agilidad) {
		this.agilidad = agilidad;
	}

	// Funciones---------------------------------------------------------------------------------
	public boolean isParalizado() {
		return paralizado;
	}

	public void setParalizado(boolean paralizado) {
		this.paralizado = paralizado;
	}

	protected void morir(){
		System.out.println("Muerto");
	}
	
	abstract void accion();

	public void curar(float valor){
		DecoradorVida defensaAux = this.getVida();

        while (defensaAux instanceof ModificadorVida) {
            defensaAux = ((ModificadorVida) defensaAux).getDecoradorVida();
        }
        ((Vida)defensaAux).curar(valor);
	}

	public void danar(float valor){
		this.setVida(getVida().setVida(valor));
	}
}
/*
Clase abstracta que sirve como base de todos los personajes,
	El jugador elegira al principio de la partida uno de estos.
*/
