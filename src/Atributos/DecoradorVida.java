package Atributos;

public interface DecoradorVida {
	public abstract float getVida();
	public abstract float getDiferencia();
	public abstract DecoradorVida setVida(float valor);
	public abstract String toString(float modificador);
}
