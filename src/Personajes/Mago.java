package Personajes;

public class Mago extends Personaje{

	public Mago() {
		super(60, 10, 17, "Mago");
	}

	@Override
	void accion() {
		System.out.println("Accion del Mago");
	}

}
