package utad.inso.dise�o.atributos;

public interface DecoradorAgilidad {
	public abstract int getValue();
	public abstract String toString(int modificador);
	public abstract String toString();
	public abstract DecoradorAgilidad consumir();
}