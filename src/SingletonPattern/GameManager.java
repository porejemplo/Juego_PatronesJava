package SingletonPattern;

import java.util.Scanner;

import Personajes.*;

public class GameManager {
	// Patron Singleton
	private static GameManager gameManager = new GameManager();
	private GameManager(){}
	public static GameManager getInstance(){
		return gameManager;
	}

	private Personaje enemigo;
	private Jugador jugador;

	public void inicioJuego(){
		// llamar a la fabrica de enemigos por primera vez.
	}

	public void inicioJuego(Personaje enemigo){
		// Creacion del Jugador
		Scanner entrada = new Scanner(System.in);
		int fuerza;
		int vida;
		int agilidad;
		String nombre;

		do {
			System.out.print("Nombre: ");
			nombre = entrada.next();
			System.out.println("\nAtributos (fuerza, defensa y agilidad)");
			System.out.println("Tienes un maximo de 15 puntos a repartir, peinsa como hacerlo.");
			System.out.println("Tiene que haber entre 1 y 10 puntos en cada atributo.");
			System.out.print("Fuerza: ");
			fuerza = entrada.nextInt();
			System.out.print("Vida: ");
			vida = entrada.nextInt();
			System.out.print("Agilidad: ");
			agilidad = entrada.nextInt();
			System.out.flush();
		} while (fuerza + vida + agilidad > 15 || fuerza<1 || vida<1 || agilidad<1 || fuerza>10 || vida>10 || agilidad>10);

		inicioJuego(enemigo, new Jugador(fuerza, vida, agilidad, nombre));
	}

	public void inicioJuego(Personaje enemigo, Jugador jugador){
		this.enemigo = enemigo;
		System.out.println(jugador.toString());
		this.jugador = jugador;
	}
}