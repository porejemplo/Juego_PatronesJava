package Estados;

import Personajes.Personaje;

public class EstadoQuemado implements Estado{

	private int fuerza;
	private int duracion;
	
	public EstadoQuemado(int fuerza, int duracion) {
		this.fuerza = fuerza;
		this.duracion = duracion;
	}
	
	@Override
	public void actuar(Personaje personaje) {
		personaje.danar(fuerza);
		setDuracion(getDuracion() - 1);
	}

	@Override
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

	@Override
	public String toString(){
		return "Quemadura " + Integer.toString(fuerza) + "DPS y duracion: " + Integer.toString(duracion); 
	}
}
