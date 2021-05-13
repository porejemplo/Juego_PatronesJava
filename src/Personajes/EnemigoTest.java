package Personajes;

import Atributos.Arma;
import Pociones.Pocion;
import SingletonPattern.*;

public class EnemigoTest extends Personaje {
	private int contador = 0;
    
    public EnemigoTest(catEnemigo cEnemigo) {
        super(cEnemigo.getFuerza(), cEnemigo.getResistencia(), cEnemigo.getAgilidad(), "Marioneta " + cEnemigo.name());
        this.setDano(new Arma("Punito", 1, getFuerza()));
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
				case 2:
				case 3:
					GameManager.getInstance().getJugador().danar(getDano().getValue(0));
					return this.getNombre() + " ataca" + calcularAfilado(GameManager.getInstance().getJugador());
				default:
					return "Se han acabado las aciones del enemigo " + getNombre();
			}
        }
	}

	@Override
	public void usarPocion(Pocion pocion) {
		if(pocion.isAtaque())
			pocion.utiliar(GameManager.getInstance().getJugador());
		else
			pocion.utiliar(this);
	}
}