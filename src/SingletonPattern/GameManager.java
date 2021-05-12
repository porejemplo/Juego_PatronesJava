package SingletonPattern;

import java.util.Random;
import java.util.Scanner;

import Personajes.*;
import Pociones.PocionAntiInflamable;
import Pociones.PocionAntiParalisis;
import Pociones.PocionInflamable;
import Pociones.PocionParalisis;
import Pociones.PocionVida;

public class GameManager {
	// Patron Singleton
	private static GameManager gameManager = new GameManager();
	private GameManager(){}
	public static GameManager getInstance(){
		return gameManager;
	}

	private Personaje enemigo;
	private Jugador jugador;
	private Scanner scannerGameManager = new Scanner(System.in);

	public Personaje getEnemigo(){
		return enemigo;
	}
	public Jugador getJugador(){
		return jugador;
	}

	// Funciones -----------------------------------------------------------
	public void inicioJuego(){
		// llamar a la fabrica de enemigos por primera vez.
	}

	public void inicioJuego(Personaje enemigo){
		// Creacion del Jugador
		int fuerza;
		int vida;
		int agilidad;
		String nombre;

		do {
			System.out.print("Nombre: ");
			nombre = scannerGameManager.next();
			System.out.println("\nAtributos (fuerza, defensa y agilidad)");
			System.out.println("Tienes un maximo de 15 puntos a repartir, peinsa como hacerlo.");
			System.out.println("Tiene que haber entre 1 y 10 puntos en cada atributo.");
			System.out.print("Fuerza: ");
			fuerza = scannerGameManager.nextInt();
			System.out.print("Vida: ");
			vida = scannerGameManager.nextInt();
			System.out.print("Agilidad: ");
			agilidad = scannerGameManager.nextInt();
			System.out.flush();
		} while (fuerza + vida + agilidad > 15 || fuerza<1 || vida<1 || agilidad<1 || fuerza>10 || vida>10 || agilidad>10);

		// Porque mierda no se puede cerrar este scanner sin que pete.
		//scannerGameManager.close();
		inicioJuego(enemigo, new Jugador(fuerza, vida, agilidad, nombre));
	}

	public void inicioJuego(Personaje enemigo, Jugador jugador){
		this.enemigo = enemigo;
		this.jugador = jugador;
		this.jugador.getPociones().add(new PocionVida(2));
		this.jugador.getPociones().add(new PocionAntiInflamable());
		this.jugador.getPociones().add(new PocionAntiParalisis());
		this.jugador.getPociones().add(new PocionInflamable(2, 2));
		this.jugador.getPociones().add(new PocionParalisis(2, 2));
	}

	public void Combate(){
		int contador = 0;			//Contador para las rondas que dura el juego.
		String descripcionCombate;
		scannerGameManager.nextLine();	// Sino no coge la primera entrada para la pausa.

		while (!jugador.estaMuerto()) {
			if (enemigo.estaMuerto()) {
				// Llamar para crear un nuevo enemigo
				System.out.println("Enemigo muerto.");
			}

			System.out.println("=====================================================================");
			System.out.println(enemigo.toString());
			System.out.println("---------------------------------------------------------------------");
			System.out.println(jugador.toString());
			System.out.println("=====================================================================");

			//Se calcula la proridad de ataque.
			int maxRandom = enemigo.getAgilidad().getValue() + jugador.getAgilidad().getValue();
			Random probabilidad = new Random();
			int r = probabilidad.nextInt(maxRandom);

			if(r < enemigo.getAgilidad().getValue()){
				// Ataca el enemigo primero
				descripcionCombate = enemigo.accion() + "\n\t";
				descripcionCombate += (jugador.estaMuerto()) ? jugador.getNombre() + " ha muerto a manos de " + enemigo.getNombre() : jugador.accion();
			}
			else {
				// Ataqua el jugador primero.
				descripcionCombate = jugador.accion() + "\n\t";
				descripcionCombate += (enemigo.estaMuerto()) ? "Has derrotado a " + enemigo.getNombre() : enemigo.accion();
			}
			System.out.println("\n\t" + descripcionCombate);
			contador++;
			scannerGameManager.nextLine();
		}
		System.out.println("=========================================");
		System.out.println("| Enhorabuena has aguantado " + Integer.toString(contador) + " rondas\t|");
		System.out.println("=========================================");
	}
}