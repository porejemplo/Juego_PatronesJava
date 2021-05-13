package Pociones;

import Estados.EstadoQuemado;
import Personajes.Personaje;

public class PocionInflamable implements Pocion {
    private int valor;
    private int duracion;
    
    public PocionInflamable(int valor, int duracion) {
        this.valor = valor;
        this.duracion = duracion;
    }

    @Override
    public void utiliar(Personaje person) {
        person.setEstado(new EstadoQuemado(valor, duracion));
    }

    @Override
    public boolean isAtaque() {
        return true;
    }

    @Override
    public String toString(){
        return "Pocion Inflamable " + Integer.toString(valor) + "-DPS y duracion: " + Integer.toString(duracion);
    }
}
