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
	private boolean cubierto;

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
	
	public DecoradorAgilidad getAgilidad() {
		return agilidad;
	}
	protected void setAgilidad(DecoradorAgilidad agilidad) {
		this.agilidad = agilidad;
	}

	public void setCubierto(){
		cubierto = true;
	}

	public boolean getParalizado() {
		return paralizado;
	}
	public void setParalizado(boolean paralizado) {
		this.paralizado = paralizado;
	}
	
	// Funciones---------------------------------------------------------------------------------
	public boolean estaMuerto(){
		return vida.getVida() <= 0;
	}
	
	public abstract void accion();

	public void curar(float valor){
		DecoradorVida defensaAux = this.getVida();

        while (defensaAux instanceof ModificadorVida) {
            defensaAux = ((ModificadorVida) defensaAux).getDecoradorVida();
        }
        ((Vida)defensaAux).curar(valor);
	}

	public void danar(float valor){
		if (cubierto) valor -= valor * defensa;
		this.setVida(getVida().setVida(valor));
	}

	public abstract String toString();

	public void turno(){
		this.paralizado = false;
		this.cubierto = false;
		if (estado.getDuracion() <= 0)
			this.estado.actuar(this);
	}
}
