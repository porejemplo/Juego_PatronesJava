package Personajes;

public class EnemigoPasivo extends Enemigo{

	public EnemigoPasivo(catEnemigo enemigo, int agresividad) {
		super(enemigo, 30);
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
