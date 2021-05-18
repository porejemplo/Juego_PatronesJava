package Personajes;

import java.util.ArrayList;
import java.util.Random;

import Atributos.*;
import Estados.Estado;
import Pociones.Pocion;

public abstract class Personaje {
	private static float porDesafiladoBloqueo = 0.2f;
	private static float porDesafilado = 0.1f;

	private DecoradorDano decoradorDano;
	// Porcentage el dano del arma que no se peirde en afilado.
	private float fuerza;
	private DecoradorVida decoradorVida;
	private float defensa;
	private DecoradorAgilidad decoradorAgilidad;
	private String nombre;
	public boolean paralizado = false;
	private Estado estado;
	private boolean cubierto;
	private ArrayList<Pocion> pociones = new ArrayList<Pocion>();

	// Contructor
	public Personaje (int fuerza, int vida, int agilidad, String nombre){
		this.fuerza = ((float)fuerza)/10;
		this.decoradorVida = new Vida(vida);
		this.defensa = (float)vida/10;
		decoradorAgilidad = new Agilidad(agilidad);
		this.nombre = nombre;
	}

	// Get y Set -----------------------------------------------------------------------------
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public DecoradorDano getDecoradorDano() {
		return decoradorDano;
	}
	protected void setDecoradorDano(DecoradorDano decoradorDano) {
		this.decoradorDano = decoradorDano;
	}
	public void addDecoradorDano (ModificadorDano modificadorDano){
		modificadorDano.setDecoradorDano(this.decoradorDano);
		this.decoradorDano = modificadorDano;
	}
	public void addDecoradorDano (Arma arma) {
		decoradorDano = arma;
	}
	
	public DecoradorVida getDecoradorVida() {
		return decoradorVida;
	}
	protected void setDecoradorVida(DecoradorVida decoradorVida) {
		this.decoradorVida = decoradorVida;
	}
	public void addDecoradorVida (ModificadorVida decoradorVida) {
		decoradorVida.setDecoradorVida(this.decoradorVida);;
		this.decoradorVida = decoradorVida;
	}
	
	public DecoradorAgilidad getAgilidad() {
		return decoradorAgilidad;
	}
	protected void setAgilidad(DecoradorAgilidad decoradorAgilidad) {
		this.decoradorAgilidad = decoradorAgilidad;
	}
	public void addAgilidad (ModificadorAgilidad modificadorAgilidad) {
		modificadorAgilidad.setDecoradorAgilidad(decoradorAgilidad);
		decoradorAgilidad = modificadorAgilidad;
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
		if (estado != null && estado.getDuracion() < 1) {
			estado = null;
		}
		return estado;
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

	public boolean getQuemado(){
		return getEstado() instanceof Estados.EstadoQuemado;
	}
	
	// Funciones---------------------------------------------------------------------------------
	public abstract void usarPocion(Pocion pocion);
	public abstract String accion();
	
	public String toString() {
		String aux = this.getNombre();
		if (getEstado() != null)
			aux += "\t" + getEstado().toString();

		aux += "\n" + getDecoradorDano().toString();
		aux += " || " + getDecoradorVida().toString();
		aux += " || " + getAgilidad().toString();

		return aux;
	}

	public boolean estaMuerto(){
		return decoradorVida.getValue() <= 0;
	}
	
	public void curar(float valor){
		decoradorVida.darVida(valor);
	}

	public void danar(float valor){
		if (cubierto)
			valor -= (valor * defensa);
			decoradorVida = getDecoradorVida().quitarVida(valor);
	}

	public void turno(){
		this.paralizado = false;
		this.cubierto = false;
		decoradorAgilidad = decoradorAgilidad.consumir();
		if (estado != null && estado.getDuracion() > 0)
			this.estado.actuar(this);
	}

	public String calcularAfilado(Personaje otro) {
		Random r = new Random();
		if (r.nextInt((int)(otro.getDefensa()*10+getFuerza()*10)) >= (getFuerza()*10)) {
			float aux = ((otro.getCubierto()) ? decoradorDano.getValue() * porDesafiladoBloqueo : decoradorDano.getValue() * porDesafilado);
			// si se rompe el decorador se pasa la referencia al siguente decorador.
			decoradorDano = decoradorDano.desafilar(aux);
			return String.format(" y ha perdido %.02f afilado.", aux);
		}
		return "";
	}
}
