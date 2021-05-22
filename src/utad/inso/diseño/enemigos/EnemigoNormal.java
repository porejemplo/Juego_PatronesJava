package utad.inso.diseño.enemigos;

import java.util.Random;

import utad.inso.diseño.pociones.*;

public class EnemigoNormal extends Enemigo {
	private int posPocion = -1;
	
	public EnemigoNormal(catEnemigo cEnemigo) {
		super(cEnemigo);
		setNombre(getNombre() + " agresivo");
	}

	@Override
	public String accion() {
		Random probabilidad = new Random();
		int r = probabilidad.nextInt(100);
		if (r < 50) {
			//25% de probabilidad de atacar o usar pociones
			if (r < 25) {
				// utilizar pocion de agilidad si se tiene.
				posPocion = buscarPocion(PocionAgilidad.class);
				if (posPocion > 0) {
					return usarPocion(posPocion);
				}
				// utilizar pocion de ataque si se tiene
				posPocion = buscarPocion();
				if (posPocion > 0) {
					return usarPocion(posPocion);
				}
				// utilizar pocion de afilado si se tiene y se puede.
				posPocion = buscarPocion(PocionAfilado.class);
				if (posPocion > 0 && (getDecoradorDano().getDanoMaximo() - getDecoradorDano().getValue()) >= getPociones().get(posPocion).getValue()) {
					return usarPocion(posPocion);
				}
			}
			// Sino se ataca.
			return atacar();
		}
		else {
			//25% de atacar o usar pociones defensivas
			if (r < 75) {
				// Curarse de paralisis si estas paralizado.
				posPocion = (getParalizado()) ? buscarPocion(PocionAntiParalisis.class) : -1;
				if (posPocion > 0) {
					return usarPocion(posPocion);
				}
				// Curarse las quemaduraas si se esta quemado.
				posPocion = (getQuemado()) ? buscarPocion(PocionAntiInflamable.class) : -1;
				if (posPocion > 0) {
					return usarPocion(posPocion);
				}
				// utilizar pocion de afilado si se tiene y se puede.
				posPocion = buscarPocion(PocionVida.class);
				if (posPocion > 0 && (getDecoradorVida().getDiferencia()) >= getPociones().get(posPocion).getValue()) {
					return usarPocion(posPocion);
				}
				// utilizar pocion de agilidad si se tiene.
				posPocion = buscarPocion(PocionAgilidad.class);
				if (posPocion > 0) {
					return usarPocion(posPocion);
				}
			}
			// Sino se cubre
			return defender();
		}
	}
}