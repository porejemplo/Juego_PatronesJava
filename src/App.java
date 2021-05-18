import Atributos.Arma;
import Personajes.Enemigos.*;
import Pociones.PocionAntiInflamable;
import Pociones.PocionVida;
import SingletonPattern.*;

public class App {
	public static void main(String[] args) {
		// Inicio de jeugo con test de enemigo
		// Enemigo enemigo = new EnemigoAgresivo(catEnemigo.hechicero);
		// Enemigo enemigo = new EnemigoTest(catEnemigo.hechicero);
		// enemigo.addDecoradorDano(new Arma("Punito", 0, enemigo.getFuerza()));
		// enemigo.getPociones().add(new PocionAntiInflamable());
		// enemigo.getPociones().add(new PocionVida(10));
		// GameManager.getInstance().inicioJuego(enemigo);
		// Se llama para que el game manager se encarge de iniciar el jeugo.
		GameManager.getInstance().inicioJuego();
		// Con el juego iniciado empieza el combate.
		GameManager.getInstance().Combate();
	}
}