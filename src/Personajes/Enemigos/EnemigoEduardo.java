package Personajes.Enemigos;

import java.util.Random;

import Personajes.Personaje;

public abstract class EnemigoEduardo extends Personaje {
	
	private int agresividad;
	
	public EnemigoEduardo(catEnemigo enemigo, int agresividad) {
		super(enemigo.getResistencia(), enemigo.getFuerza(), enemigo.getFuerza(), "Name");
		this.agresividad = agresividad;
	}

	@Override
	public String accion() {
		Random probabilidad = new Random();
		int r = probabilidad.nextInt(100);
		if(!this.paralizado) {
			//if() { compribar que tiene pocion si es true usar la
			if(r < agresividad) {
				atacar();
			}else {
				defender();
			}
			//Implementar si usa pocion quitar el estado
			//usar pocion contador = 0;
			//}
		}
		return "Enemigo realiza accion";
	}
	
	abstract void atacar();
	abstract void defender();
	abstract void tomarPocion();
	
}
