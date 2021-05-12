import Atributos.*;
import Pociones.*;
import Atributos.*;
import Personajes.*;
import SingletonPattern.*;

public class App {
	public static void main(String[] args) {
		GameManager.getInstance().inicioJuego(new EnemigoTest(catEnemigo.hechicero));
	}
}