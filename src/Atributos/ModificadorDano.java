package Atributos;

public class ModificadorDano extends DecoradorDano {
	private float dano;
	private DecoradorDano decoradorDano;

	public ModificadorDano(float dano, DecoradorDano decoradorDano){
		this.dano = dano;
		this.decoradorDano = decoradorDano;
	}

	@Override
	public float getValue(float i) {
		return decoradorDano.getValue(dano + i);
	}

	@Override
	public String toString(float modificador) {
		return decoradorDano.toString(dano + modificador);
	}
}
