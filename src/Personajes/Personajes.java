package Personajes;

import Atributos.*;

public abstract class Personajes {
	
	private DecoradorDano dano;
	private float fuerza;
	private DecoradorDefensa defensa;
	private DecoradorAgilidad agilidad;
	private String nombre;
	public boolean paralizado = false;
	private Estado estado;

	// Contructor
	public Personajes (float fuerza, int vida, int agilidad, String nombre){
		this.fuerza = fuerza;
		this.defensa = new Vida(vida);
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
	
	protected DecoradorDefensa getDefensa() {
		return defensa;
	}
	protected void setDefensa(DecoradorDefensa defensa) {
		this.defensa = defensa;
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
		DecoradorDefensa defensaAux = this.getDefensa();

        while (defensaAux instanceof ModificadorDefensa) {
            defensaAux = ((ModificadorDefensa) defensaAux).getDecoradorDefensa();
        }
        ((Vida)defensaAux).curar(valor);
	}
}
/*
Clase abstracta que sirve como base de todos los personajes,
	El jugador elegira al principio de la partida uno de estos.
*/
