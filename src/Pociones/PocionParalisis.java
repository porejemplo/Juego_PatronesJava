package Pociones;

import Personajes.EstadoParalizado;
import Personajes.Personaje;

public class PocionParalisis implements Pocion {
    private int valor;
    private int duracion;

    public PocionParalisis(int valor, int duracion) {
        this.valor = valor;
        this.duracion = duracion;
    }

    @Override
    public void utiliar(Personaje person) {
        person.setEstado(new EstadoParalizado(valor, duracion));
    }

    @Override
    public boolean getAtaque() {
        return true;
    }
}
