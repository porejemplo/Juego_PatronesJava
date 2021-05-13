package Pociones;

import Personajes.Personaje;

public class PocionAfilado implements Pocion {
    private int valor;

    public PocionAfilado(int valor){
        this.valor = valor;
    }

    @Override
    public void utiliar(Personaje person) {
        person.getDano().afilar(valor);
    }

    @Override
    public boolean isAtaque() {
        return false;
    }

    @Override
    public String toString(){
        return "Pocion de Afilado: " + Integer.toString(valor) + " puntos.";
    }    
}
