package Personajes;

public class Enemigo extends Personajes {

	public Enemigo(catEnemigo enemigo) {
		// No se como sacar el nombre de la variable.
		// TODO Hay que meter el modificador dependeindo del mundo.
		super(enemigo.getResistencia(), enemigo.getFuerza(), enemigo.getFuerza(), "Name");
	}

	@Override
	void accion() {
		
	}	
}
