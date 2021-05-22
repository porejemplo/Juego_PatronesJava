package utad.inso.diseño.enemigos;

import java.util.Random;

import utad.inso.diseño.pociones.PocionAfilado;
import utad.inso.diseño.pociones.PocionAgilidad;
import utad.inso.diseño.pociones.PocionAntiInflamable;
import utad.inso.diseño.pociones.PocionAntiParalisis;
import utad.inso.diseño.pociones.PocionVida;

public class EnemigoPasivo extends Enemigo{
	private int posPocion = -1;
	
	public EnemigoPasivo(catEnemigo cEnemigo) {
		super(cEnemigo);
		setNombre(getNombre() + " pasivo");
	}

	@Override
	public String accion() {
		Random probabilidad = new Random();
		int r = probabilidad.nextInt(100);
		if (r < 40) {
			//Probabilidad de atacar 10%
			//probabilidad de usar pociones 30%
			if (r < 30) {
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
			//40% de usar pociones
			//20% de defender
			if (r < 80) {
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
