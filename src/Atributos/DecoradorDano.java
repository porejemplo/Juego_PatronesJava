package Atributos;

public interface DecoradorDano {
    public abstract float getValue();
    public abstract float getDanoMaximo();
    public abstract String toString();
    public abstract String toString(float modificador, float danoRestante);
    public abstract DecoradorDano desafilar(float val);
    public abstract float afilar(float val);
}