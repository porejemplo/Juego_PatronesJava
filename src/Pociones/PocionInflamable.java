package Pociones;

import Personajes.EstadoQuemado;
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
    public boolean getAtaque() {
        return true;
    }
}
