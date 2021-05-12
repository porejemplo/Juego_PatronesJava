package Personajes;

import Atributos.Arma;
import Pociones.Pocion;
import SingletonPattern.*;

public class EnemigoTest extends Personaje {
    
    public EnemigoTest(catEnemigo cEnemigo) {
        super(cEnemigo.getFuerza(), cEnemigo.getResistencia(), cEnemigo.getAgilidad(), "Enemigo Pruebas");
        this.setDano(new Arma("Punito", 3, 1));
    }

    @Override
	public String accion() {
        turno();
		if (paralizado)
			return getNombre() + "esta paralizado y no pudo moverse";
		else {
		    return "Ellecion de accion del " + getNombre();
        }
	}

	@Override
	public void usarPocion(Pocion pocion) {
		if(pocion.getAtaque())
			pocion.utiliar(GameManager.getInstance().getJugador());
		else
			pocion.utiliar(this);
	}
}
