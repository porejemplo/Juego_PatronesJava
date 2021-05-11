package Atributos;

public class Jugador {
    private DecoradorDano fuerza;
    private DecoradorDefensa defensa;
    private DecoradorAgilidad agilidad;
    
    public DecoradorDano getFuerza(){
        return fuerza;
    }

    public DecoradorAgilidad getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(DecoradorAgilidad agilidad) {
        this.agilidad = agilidad;
    }

    public void setFuerza(DecoradorDano fuerza){
        this.fuerza = fuerza;
    }

    public DecoradorDefensa getDefensa(){
        return defensa;
    }

    public void setDefensa(DecoradorDefensa defensa){
        this.defensa = defensa;
    }

    public String toString(){
        return fuerza.toString(-3) + "\n" + defensa.toString(0) + "\n" + agilidad.toString(0);
    }
}