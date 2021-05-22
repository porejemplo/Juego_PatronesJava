package utad.inso.diseño.personajes;

import utad.inso.diseño.atributos.*;
import utad.inso.diseño.gameManager.GameManager;
import utad.inso.diseño.pociones.Pocion;
import utad.inso.diseño.pociones.PocionAgilidad;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Jugador extends Personaje {

	private Scanner scannerAccionJugador = new Scanner(System.in);
	
	public Jugador(int ataque, int vida, int agilidad, String nombre) {
		super(ataque, vida, agilidad, nombre);
		this.setDecoradorDano(new Arma("Punito", 3, getFuerza()));
		getPociones().add(new PocionAgilidad(2, 4));
		getPociones().add(new PocionAgilidad(-2, 4));
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
						GameManager.getInstance().getEnemigo().danar(getDecoradorDano().getValue());
						return this.getNombre() + " ataca" + calcularAfilado(GameManager.getInstance().getEnemigo());
					case 2:
						this.setCubierto();
						return this.getNombre() + " se Defiende";
					case 3:
						System.out.print("Que objeto quieres usar: ");
						opcion = scannerAccionJugador.nextInt();
						if (opcion >= 0 && opcion < getPociones().size()){
							usarPocion(getPociones().get(opcion));
							String auxString = this.getNombre() + " usa " + getPociones().get(opcion).toString();
							getPociones().remove(opcion);
							return auxString;
						}
					default:
						System.out.println("No es una opcion");
						scannerAccionJugador.nextLine();
					}
				}catch(InputMismatchException e) {
					System.out.println("num pls");
					scannerAccionJugador.nextLine();
				}
			}
		}
	}

	@Override
	public void usarPocion(Pocion pocion) {
		if(pocion.isAtaque())
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
				aux += Integer.toString(i) + ") " + getPociones().get(i).toString();
				if (i+1 < getPociones().size()) {
					if (i%2 == 1)
						aux += "\n\t";
					else
						aux += " || ";
				}
			}
		}
		return aux;
	}

	public void cogerArmaNueva(DecoradorDano decoradorDano) {
		String auxString = "Quieres coger: " ;
		if (decoradorDano instanceof Arma) {
			auxString += decoradorDano.toString(0, decoradorDano.getDanoMaximo()*getFuerza());
		}
		else {
			auxString += decoradorDano.toString();
		}
		auxString += "\n y descartar: " + getDecoradorDano().toString();
		auxString += "\nQue quieres hacer con el arma del enemigo";
		auxString += "\n1-Equipar.\t2-Descartar.";
		System.out.println(auxString);

		int opcion = -1;
		while (opcion != 1 && opcion != 2) {
			try {
				opcion = scannerAccionJugador.nextInt();
				switch (opcion) {
					case 1:
						setDecoradorDano(decoradorDano);
						System.out.println("Nueva arma equipada.");
						break;
					case 2:
						System.out.println("Has descartado el arma.");
						break;
				
					default:
						System.out.println("Opcion no valida.");
						break;
				}
			} catch (InputMismatchException e) {
				System.out.println("num pls");
				scannerAccionJugador.nextLine();
			}
		}
	}
}