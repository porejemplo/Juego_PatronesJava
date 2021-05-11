package Personajes;

import java.util.Random;

public class EstadoParalizado implements Estado{

	private int duracion;
	private int fuerza;
	
	public EstadoParalizado(int fuerza, int duracion){
		this.fuerza = fuerza;
		this.setDuracion(duracion);
	}
	
	@Override
	public void actuar(Personaje personaje) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int numAleatorio = r.nextInt(100);
		if(numAleatorio < fuerza) {
			personaje.setParalizado(true);
			setDuracion(getDuracion() - 1);
		}
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

}
