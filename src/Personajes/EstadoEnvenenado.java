package Personajes;

public class EstadoEnvenenado implements Estado{

	private int fuerza;
	private int duracion;
	
	public EstadoEnvenenado(int fuerza, int duracion) {
		// TODO Auto-generated constructor stub
		this.fuerza = fuerza;
		this.duracion = duracion;
	}
	
	@Override
	public void actuar(Personajes personaje) {
		// TODO Auto-generated method stub
		personaje.setVida(-fuerza);
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
