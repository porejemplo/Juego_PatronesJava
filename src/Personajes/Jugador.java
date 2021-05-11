package Personajes;

import Pociones.Pocion;
import Atributos.*;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Jugador extends Personaje {

	ArrayList<Pocion> pociones = new ArrayList<Pocion>();
	
	public Jugador(int ataque, int vida, int agilidad, String nombre) {
		super(ataque, vida, agilidad, nombre);
		this.setDano(new Arma("Punito", 3, 1));
	}

	//Funciones
	@Override
	public void accion() {
		turno();
		if (paralizado)
			System.out.println("Jugador esta paralizado");
		else {
			Scanner entrada = new Scanner(System.in);
			int opcion = 0;
			while(opcion == 0){
				System.out.println("1. Attacar");
				System.out.println("2. Defender");
				System.out.println("3. Objeto");
				opcion = entrada.nextInt();
				
				try {
					switch(opcion) {
					case 1:
						System.out.println(this.getNombre() + "Ataca");
						break;
					case 2:
						System.out.println(this.getNombre() + "se Defiende");
						break;
					case 3:
						System.out.println(this.getNombre() + "Objetos");
						break;
					default:
						System.out.println("No es una opcion");
					}
				}catch(InputMismatchException e) {
					System.out.println("num pls");
					entrada.next();
				}
			}
		}
	}

	public String toString(){
		// TODO: Mostrar lista de items y estado.
		return getDano().toString(0) + "\n" + getVida().toString(0) + "\n" + getAgilidad().toString(0);
	}
}