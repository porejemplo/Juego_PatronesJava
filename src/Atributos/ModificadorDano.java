package Atributos;

public class ModificadorDano extends DecoradorDano {
	private int dano;
	private DecoradorDano decoradorDano;

	public ModificadorDano(int dano, DecoradorDano decoradorDano){
		this.dano = dano;
		this.decoradorDano = decoradorDano;
	}

	@Override
	public int getValue(int i) {
		return decoradorDano.getValue(dano + i);
	}

	@Override
	public String toString(int modificador) {
		return decoradorDano.toString(dano + modificador);
	}
}
