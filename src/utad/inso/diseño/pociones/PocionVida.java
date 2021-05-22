package utad.inso.diseño.pociones;

import utad.inso.diseño.personajes.Personaje;

public class PocionVida implements Pocion {
	private int valor;

	public PocionVida (int valor){
		this.valor = valor;
	}

	@Override
	public void utiliar(Personaje person) {
		person.curar(this.valor);
	}

	@Override
	public boolean isAtaque() {
		return false;
	}

	@Override
    public String toString(){
        return "Pocion Curacion: " + Integer.toString(valor) + " puntos.";
    }

	@Override
	public float getValue() {
		return (float)valor;
	}
}
