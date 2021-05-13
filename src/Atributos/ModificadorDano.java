package Atributos;

public class ModificadorDano implements DecoradorDano {
	private float dano;
	private float danoMinimo;
	private float danoMaximo;
	private DecoradorDano decoradorDano;

	public ModificadorDano(float dano, float fuerza, DecoradorDano decoradorDano){
		this.dano = dano;
		this.decoradorDano = decoradorDano;
		danoMinimo = dano * fuerza;
		danoMaximo = dano;
	}

	@Override
	public float getValue(float i) {
		return decoradorDano.getValue(dano + i);
	}
	
	@Override
	public float getDanoMaximo(float danoMaximo) {
		return decoradorDano.getDanoMaximo(danoMaximo + this.danoMaximo);
	}

	@Override
	public void desafilar(float val){
		if (dano > danoMinimo) {
			this.dano -= val;
			if (dano < this.danoMinimo){
				val = danoMinimo - dano;
				dano = danoMinimo;
			}
		}
		decoradorDano.desafilar(val);
	}
	
	@Override
	public float afilar(float val) {
		if (dano == danoMaximo)
			return val;

		dano += val;
		if (dano>danoMaximo) {
			val = dano - danoMaximo;
			dano = danoMaximo;
			return val;
		}
		return 0;
	}

	@Override
	public String toString(float modificador, float danoMaximo) {
		return decoradorDano.toString(dano + modificador, danoMaximo + this.danoMaximo);
	}

}
