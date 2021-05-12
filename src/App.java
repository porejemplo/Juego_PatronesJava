import Personajes.*;
import SingletonPattern.*;

public class App {
	public static void main(String[] args) {
		// Se llama para que el game manager se encarge de iniciar el jeugo.
		GameManager.getInstance().inicioJuego(new EnemigoTest(catEnemigo.hechicero));
		// Con el juego iniciado empieza el combate.
		GameManager.getInstance().Combate();
	}
}