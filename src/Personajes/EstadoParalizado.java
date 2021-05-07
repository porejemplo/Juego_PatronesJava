package Personajes;

import java.util.Random;

public class EstadoParalizado implements Estado{

	@Override
	public void actuar(Personajes personaje) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int numAleatorio = r.nextInt(100);
		if(numAleatorio == 0) {
			personaje.setParalizado(true);
		}
	}

}
