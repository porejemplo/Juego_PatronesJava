package Atributos;

public abstract class DecoradorVida {
	public abstract float getVida();
	public abstract DecoradorVida setVida(float valor);
	public abstract String toString(float modificador);
}
