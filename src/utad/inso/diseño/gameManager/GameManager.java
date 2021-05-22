package utad.inso.diseño.gameManager;

import java.util.Random;
import java.util.Scanner;

import utad.inso.diseño.personajes.Jugador;
import utad.inso.diseño.enemigos.Enemigo;
import utad.inso.diseño.enemigos.FabricaEnemigos;

public class GameManager {
	// Patron Singleton
	private static GameManager gameManager = new GameManager();
	private GameManager(){}
	public static GameManager getInstance(){
		return gameManager;
	}

	private Enemigo enemigo;
	private Jugador jugador;
	private Scanner scannerGameManager = new Scanner(System.in);
	private FabricaEnemigos fabricaEnemigos = new FabricaEnemigos();
	
	public Enemigo getEnemigo(){
		return enemigo;
	}
	public Jugador getJugador(){
		return jugador;
	}

	// Funciones -----------------------------------------------------------
	public void inicioJuego(){
		creacionJugador();
		this.enemigo = fabricaEnemigos.crearEnemigo();
	}

	public void inicioJuego(Enemigo enemigo){
		creacionJugador();
		this.enemigo = enemigo;
	}

	private void creacionJugador (){
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

		this.jugador = new Jugador(fuerza, vida, agilidad, nombre);
	}

	public void Combate() {
		int contador = 0;				//Contador para las rondas que dura el juego.
		String descripcionCombate;
		scannerGameManager.nextLine();	// Sino no coge la primera entrada para la pausa.

		while (!jugador.estaMuerto()) {
			if (enemigo.estaMuerto()) {
				System.out.println("Vamos a ver que tenia el enemigo:");
				// Gestion del arma del enemigo.
				jugador.cogerArmaNueva(enemigo.getDecoradorDano());
				// Gestion de los pociones del enemigo.
				if (enemigo.getPociones().size() > 0){
					String auxString = "Enhorabuena " + jugador.getNombre() + " has conseguido:\n\t";
					for (int i = 0; i < enemigo.getPociones().size(); i++) {
						auxString += Integer.toString(i) + ") " + enemigo.getPociones().get(i).toString();
						if (i+1 < enemigo.getPociones().size()) {
							if (i%2 == 1)
								auxString += "\n\t";
							else
								auxString += " || ";
						}
					}
					System.out.println(auxString);
					jugador.getPociones().addAll(enemigo.getPociones());
				}
				else {
					System.out.println("Parece que el enemigo no tenia nunguna pocion.");
				}
				// Llamar para crear un nuevo enemigo
				enemigo = fabricaEnemigos.crearEnemigo();
				scannerGameManager.nextLine();
			}

			System.out.println("=======================================================================================================");
			System.out.println(enemigo.toString());
			System.out.println("-------------------------------------------------------------------------------------------------------");
			System.out.println(jugador.toString());
			System.out.println("=======================================================================================================");

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