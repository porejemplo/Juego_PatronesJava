package Personajes;

public class EstadoQuemado implements Estado{

	private int fuerza;
	private int duracion;
	
	public EstadoQuemado(int fuerza, int duracion) {
		this.fuerza = fuerza;
		this.duracion = duracion;
	}
	
	@Override
	public void actuar(Personajes personaje) {
		personaje.getDefensa().setDefensa(fuerza);
		setDuracion(getDuracion() - 1);
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
}
