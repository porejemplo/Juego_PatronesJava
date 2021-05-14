package Atributos;

public interface DecoradorVida {
	public abstract float getValue();
	public abstract float getDiferencia();
	public abstract DecoradorVida quitarVida(float valor);
	public abstract float darVida(float valor);
	public abstract String toString(float modificador, float vidaRestante);
	public abstract String toString();
}
