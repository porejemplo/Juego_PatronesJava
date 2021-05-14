import Atributos.Arma;
import Personajes.Enemigos.*;
import SingletonPattern.*;

public class App {
	public static void main(String[] args) {
		Enemigo enemigo = new EnemigoAgresivo(catEnemigo.hechicero);
		enemigo.addDecoradorDano(new Arma("Punito", 2, enemigo.getFuerza()));
		// Se llama para que el game manager se encarge de iniciar el jeugo.
		GameManager.getInstance().inicioJuego(enemigo);
		// Con el juego iniciado empieza el combate.
		GameManager.getInstance().Combate();
	}
}