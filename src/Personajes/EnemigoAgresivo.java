package Personajes;

public class EnemigoAgresivo extends Enemigo{

	public EnemigoAgresivo(catEnemigo enemigo) {
		super(enemigo, 70);
		// TODO Auto-generated constructor stub
	}

	@Override
	void atacar() {
		// TODO Auto-generated method stub
		//Llamar al game manager para atacar
	}

	@Override
	void defender() {
		// TODO Auto-generated method stub
		//Llamar al game manager para defender
	}

	@Override
	void tomarPocion() {
		// TODO Auto-generated method stub
		//Llamar al game managar para tomar poci�n
	}

	@Override
	public String toString() {
		return "Agresivo" + getDano().toString(0) + "\n" + getVida().toString(0) + "\n" + getAgilidad().toString(0);
	}
}
