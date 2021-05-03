package Personajes;

public class Arquero extends Personajes{

	public Arquero() {
		super(50, 13, 20, "Arquero");
	}
	
	@Override
	void accion() {
		System.out.println("Accion del Mago");
	}
}
