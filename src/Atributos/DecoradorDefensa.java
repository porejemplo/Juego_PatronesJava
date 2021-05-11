package Atributos;

public abstract class DecoradorDefensa {
	public abstract float getDefensa();
	public abstract DecoradorDefensa setDefensa(float valor);
	public abstract String toString(float modificador);
}
