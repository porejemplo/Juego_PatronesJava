package Personajes;

import Pociones.Pocion;
import SingletonPattern.GameManager;
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
	public String accion() {
		//String descAccion = "-";
		turno();
		if (paralizado)
			return getNombre() + "esta paralizado y no pudo moverse";
		else {
			Scanner entrada = new Scanner(System.in);
			int opcion = 0;
			while(true){
				System.out.println("1. Attacar");
				System.out.println("2. Defender");
				System.out.println("3. Objeto");
				opcion = entrada.nextInt();
				
				try {
					switch(opcion) {
					case 1:
						GameManager.getInstance().getEnemigo().danar(getDano().getValue(0));
						return this.getNombre() + " ataca";
					case 2:
						this.setCubierto();
						return this.getNombre() + " se Defiende";
					case 3:
						
						return this.getNombre() + "usa objetos";
					default:
						System.out.println("No es una opcion");
						entrada.next();
					}
				}catch(InputMismatchException e) {
					System.out.println("num pls");
					entrada.next();
				}
			}
		}
	}

	@Override
	public void usarPocion(Pocion pocion) {
		if(pocion.getAtaque())
			pocion.utiliar(GameManager.getInstance().getEnemigo());
		else
			pocion.utiliar(this);
	}

	@Override
	public String toString() {
		String aux = super.toString() + "\n";

		for (int i = 0; i < pociones.size(); i++) {
			aux += pociones.get(i).toString() + "||";
		}

		return aux;
	}
}