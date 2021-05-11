package Personajes;

public class Caballero extends Personaje{
	
	public Caballero() {
		super(90, 13, 7, "Caballero");
	}
	
	@Override
	void accion() {
		System.out.println("Accion del Mago");
	}
}
