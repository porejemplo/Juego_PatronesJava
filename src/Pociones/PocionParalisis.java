package Pociones;

import Estados.EstadoParalizado;
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
    public boolean isAtaque() {
        return true;
    }

    @Override
    public String toString(){
        return "Pocion Paralisis " + Integer.toString(valor) + "% efectividad y duracion: " + Integer.toString(duracion);
    }
}
