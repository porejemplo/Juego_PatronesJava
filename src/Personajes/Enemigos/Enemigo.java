package Personajes.Enemigos;

import Personajes.Personaje;
import Pociones.Pocion;
import SingletonPattern.GameManager;

public abstract class Enemigo extends Personaje {

	public Enemigo(catEnemigo cEnemigo) {
		super(cEnemigo.getFuerza(), cEnemigo.getResistencia(), cEnemigo.getAgilidad(), cEnemigo.name());
	}

	@Override
	public void usarPocion(Pocion pocion) {
		if(pocion.isAtaque())
			pocion.utiliar(GameManager.getInstance().getJugador());
		else
			pocion.utiliar(this);
	}

	// Acciones que puede hacer el enemigo.
	protected String atacar(){
		GameManager.getInstance().getJugador().danar(getDecoradorDano().getValue());
		return this.getNombre() + " ataca" + calcularAfilado(GameManager.getInstance().getJugador());
	}

	protected String defender() {
		this.setCubierto();
		return this.getNombre() + " se Defiende";
	}

	protected int buscarPocion(Class clazz){
		int posicion = -1;
		for (int i = 0; i < getPociones().size(); i++) {
			if (getPociones().get(i).getClass() == clazz) {
				posicion = i;
				break;
			}
		}
		return posicion;
	}

	// Se utiliza para buscar una pocion de attaque.
	protected int buscarPocion() {
		int posicion = -1;
		for (int i = 0; i < getPociones().size(); i++) {
			if (getPociones().get(i).isAtaque()) {
				posicion = i;
				break;
			}
		}
		return posicion;
	}

	protected String usarPocion(int pocion) {
		usarPocion(getPociones().get(pocion));
		String auxString = this.getNombre() + " usa " + getPociones().get(pocion).toString();
		getPociones().remove(pocion);
		return auxString;
	}
}
