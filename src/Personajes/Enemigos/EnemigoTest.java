package Personajes.Enemigos;

import Atributos.Arma;
import Pociones.*;

public class EnemigoTest extends Enemigo {
	private int contador = 0;
	private int posPocion = -1;
	
	public EnemigoTest(catEnemigo cEnemigo) {
		super(cEnemigo);
		setNombre("Marioneta " + getNombre());
		setDano(new Arma("Punito", 1, getFuerza()));
	}

	@Override
	public String accion() {
		turno();
		contador++;
		if (paralizado)
			return getNombre() + " esta paralizado y no pudo moverse";
		else {
			switch (contador) {
				case 1:
					// posPocion = buscarPocion(PocionInflamable.class);
					// if (posPocion < 0) {
					// 	return  getNombre() + " no tiene la pocion.";
					// }
					// return usarPocion(posPocion);
				case 2:
				case 3:
					//return atacar();
				case 4:
					return defender();
				default:
					return "Se han acabado las aciones del enemigo " + getNombre();
			}
		}
	}
}