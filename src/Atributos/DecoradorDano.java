package Atributos;

public abstract class DecoradorDano {
    public abstract float getValue(float i);
    public abstract String toString(float modificador);
    public abstract void desafilar(float val);
    public abstract float afilar(float val);
}