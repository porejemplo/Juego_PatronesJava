package Atributos;

public class ModificadorDano extends DecoradorDano {
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
	public String toString(float modificador) {
		return decoradorDano.toString(dano + modificador);
	}
}
