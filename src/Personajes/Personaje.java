package Personajes;

import java.util.ArrayList;
import java.util.Random;

import Atributos.*;
import Estados.Estado;
import Pociones.Pocion;

public abstract class Personaje {
	private DecoradorDano dano;
	// Porcentage el dano del arma que no se peirde en afilado.
	private float fuerza;
	private DecoradorVida vida;
	private float defensa;
	private DecoradorAgilidad agilidad;
	private String nombre;
	public boolean paralizado = false;
	private Estado estado;
	private boolean cubierto;
	private ArrayList<Pocion> pociones = new ArrayList<Pocion>();

	// Contructor
	public Personaje (int fuerza, int vida, int agilidad, String nombre){
		this.fuerza = ((float)fuerza)/10;
		this.vida = new Vida(vida);
		this.defensa = (float)vida/10;
		this.agilidad = new Agilidad(agilidad);
		this.nombre = nombre;
	}

	// Get y Set -----------------------------------------------------------------------------
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public DecoradorDano getDano() {
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
	public boolean getCubierto(){
		return cubierto;
	}

	public boolean getParalizado() {
		return paralizado;
	}
	public void setParalizado(boolean paralizado) {
		this.paralizado = paralizado;
	}

	public void setEstado(Estado estado){
		this.estado = estado;
	}
	public Estado getEstado(){
		return this.estado;
	}

	public ArrayList<Pocion> getPociones() {
		return pociones;
	}

	public float getFuerza(){
		return fuerza;
	}

	public float getDefensa(){
		return defensa;
	}
	
	// Funciones---------------------------------------------------------------------------------
	public abstract void usarPocion(Pocion pocion);
	public abstract String accion();
	
	public String toString() {
		String aux = this.getNombre();
		if (getEstado() != null && getEstado().getDuracion() > 0)
			aux += "\t" + getEstado().toString();

		aux += "\n" + getDano().toString(0);
		aux += " || " + getVida().toString(0);
		aux += " || " + getAgilidad().toString(0);

		return aux;
	}

	public boolean estaMuerto(){
		return vida.getVida() <= 0;
	}
	
	public void curar(float valor){
		DecoradorVida defensaAux = this.getVida();

        while (defensaAux instanceof ModificadorVida) {
            defensaAux = ((ModificadorVida) defensaAux).getDecoradorVida();
        }
        ((Vida)defensaAux).curar(valor);
	}

	public void danar(float valor){
		if (cubierto)
			valor -= (valor * defensa);
		this.setVida(getVida().setVida(valor));
	}

	public void turno(){
		this.paralizado = false;
		this.cubierto = false;
		if (estado != null && estado.getDuracion() > 0)
			this.estado.actuar(this);
	}

	public String calcularAfilado(Personaje otro) {
		Random r = new Random();
		if (r.nextInt((int)(otro.getDefensa()*10+getFuerza()*10)) >= (getFuerza()*10)) {
			float aux = ((otro.getCubierto()) ? getVida().getVida() * 0.2f : getVida().getVida() * 0.1f);
			getDano().desafilar(aux);
			return " y ha perdido " + Float.toString(aux) + " de afilado.";
		}
		return "";
	}
}
