package Personajes;

import Pociones.Pocion;
import SingletonPattern.GameManager;
import Atributos.*;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Jugador extends Personaje {

	private Scanner scannerAccionJugador = new Scanner(System.in);
	
	public Jugador(int ataque, int vida, int agilidad, String nombre) {
		super(ataque, vida, agilidad, nombre);
		this.setDano(new Arma("Punito", 3, getFuerza()));
	}

	//Funciones
	@Override
	public String accion() {
		turno();
		if (paralizado)
			return getNombre() + "esta paralizado y no pudo moverse";
		else {
			int opcion;
			while(true){
				System.out.println("1. Atacar");
				System.out.println("2. Defender");
				System.out.println("3. Objeto");
				opcion = scannerAccionJugador.nextInt();
				
				try {
					switch(opcion) {
					case 1:
						GameManager.getInstance().getEnemigo().danar(getDano().getValue(0));
						return this.getNombre() + " ataca";
					case 2:
						this.setCubierto();
						return this.getNombre() + " se Defiende";
					case 3:
						System.out.print("Que objeto quieres usar: ");
						opcion = scannerAccionJugador.nextInt();
						if (opcion > 0 && opcion < getPociones().size()){
							usarPocion(getPociones().get(opcion));
							String auxString = this.getNombre() + " usa " + getPociones().get(opcion).toString();
							getPociones().remove(opcion);
							return auxString;
						}
					default:
						System.out.println("No es una opcion");
						scannerAccionJugador.next();
					}
				}catch(InputMismatchException e) {
					System.out.println("num pls");
					scannerAccionJugador.next();
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
		String aux = super.toString();

		if (getPociones().size() > 0){
			aux += "\nPociones:\n\t";
			for (int i = 0; i < getPociones().size(); i++) {
				aux += Integer.toString(i) + "- " + getPociones().get(i).toString();
				if (i%2 == 1)
					aux += "\n\t";
				else if (i+1 < getPociones().size())
					aux += " || ";
			}
		}
		return aux;
	}
}