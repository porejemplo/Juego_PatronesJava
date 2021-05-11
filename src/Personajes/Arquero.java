package Personajes;

public class Arquero extends Personaje{

	public Arquero() {
		super(50, 13, 20, "Arquero");
	}
	
	@Override
	public void accion() {
		System.out.println("Accion del Arquero");
	}

	@Override
	public String toString() {
		return "Arquero" + getDano().toString(0) + "\n" + getVida().toString(0) + "\n" + getAgilidad().toString(0);
	}
}
