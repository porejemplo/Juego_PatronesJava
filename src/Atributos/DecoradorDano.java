package Atributos;

public interface DecoradorDano {
    public abstract float getValue(float i);
    public abstract float getDanoMaximo(float danoMaximo);
    public abstract String toString(float modificador, float danoMaximo);
    public abstract void desafilar(float val);
    public abstract float afilar(float val);
}