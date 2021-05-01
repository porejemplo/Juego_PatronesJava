package Personajes;

import java.util.Scanner;
import java.util.InputMismatchException;

public class testPersonajes {
	
	public static void main(String[] argc) {
		Scanner input = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		
		while(!salir){
		
			System.out.println("1. Caballero");
			System.out.println("2. Mago");
			System.out.println("3. Arquero");
			opcion = input.nextInt();
			try {
				switch(opcion) {
				case 1:
					System.out.println("Eres Caballero");
					Caballero jugador = new Caballero();
					System.out.println(jugador.getVida() + " " + jugador.getAtaque() + " " + jugador.getVida());
					break;
				case 2:
					System.out.println("Eres Mago");
					break;
				case 3:
					System.out.println("Eres Arquero");
					break;
				default:
					System.out.println("No es una opcion");
				}
			}catch(InputMismatchException e) {
				System.out.println("num pls");
				input.next();
			}
		}
	}
	
}
