package Personajes;

public class Mago extends Personaje{

	public Mago() {
		super(60, 10, 17, "Mago");
	}

	@Override
	public void accion() {
		System.out.println("Ellecion de accion del mago");
	}

	@Override
	public String toString() {
		return "Mago" + getDano().toString(0) + "\n" + getVida().toString(0) + "\n" + getAgilidad().toString(0);
	}
}
