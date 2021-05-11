package Personajes;

import java.util.Random;

public abstract class Enemigo extends Personaje {
	
	private int agresividad;
	
	public Enemigo(catEnemigo enemigo, int agresividad) {
		// No se como sacar el nombre de la variable.
		// TODO Hay que meter el modificador dependeindo del mundo.
		super(enemigo.getResistencia(), enemigo.getFuerza(), enemigo.getFuerza(), "Name");
		this.agresividad = agresividad;
	}

	@Override
	public void accion() {
		
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
	}
	
	abstract void atacar();
	abstract void defender();
	abstract void tomarPocion();
	
}
