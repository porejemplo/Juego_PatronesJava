package Personajes;

public class EnemigoFiftyFifty extends Enemigo{

	public EnemigoFiftyFifty(catEnemigo enemigo, int agresividad) {
		super(enemigo, 50);
		// TODO Auto-generated constructor stub
	}

	@Override
	void atacar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void defender() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void tomarPocion() {
		// TODO Auto-generated method stub
	}

	@Override
	public String toString() {
		return "Mago" + getDano().toString(0) + "\n" + getVida().toString(0) + "\n" + getAgilidad().toString(0);
	}
}
