package Personajes.Enemigos;

import java.util.ArrayList;
import java.util.Random;

import Atributos.Arma;
import Atributos.ModificadorVida;
import Pociones.Pocion;

public class EjemploCreacionEnemigos {
	// No se si como hay pasos se puede implementar tambien el state patern pero ni idea
	public Enemigo crearEnemigo() {
		// Se ejige una categoria de enmigo para empezar la creacion.
		catEnemigo cE;
		Random r = new Random();
		int auxInt = r.nextInt(3);
		switch (auxInt) {
			case 0:
				cE = catEnemigo.guerrero;
				break;
			case 1:
				cE = catEnemigo.hechicero;
				break;
			default:
				cE = catEnemigo.mutante;
				break;
		}

		// A continuacion se elije aleatoriamente el comportamiento de algua clase Enemigo.
		// No lo hago aleatorio porque solo hay 1
		Enemigo enemigo;
		auxInt = r.nextInt(2);
		switch (auxInt) {
			case 0:
				enemigo = new EnemigoTest(cE);
				break;
			default:
				enemigo = new EnemigoAgresivo(cE);
				break;
		}

		// Por ultimo tenemos que llamar para que le den los decoradores.
		// decorador de armas
		auxInt = r.nextInt(2);
		if (auxInt < 1) {
			enemigo.addDecoradorDano(darArmaXArma());
		} else {
			enemigo.addDecoradorDano(darArmaXArmadura());
		}

		// Decorador de Armadura
		auxInt = r.nextInt(2);
		if (auxInt < 1) {
			enemigo.addDecoradorVida(darArmaduraXArma());
		} else {
			enemigo.addDecoradorVida(darArmaduraXArmadura());
		}

		// Anadir objetos
		auxInt = r.nextInt(3);
		enemigo.getPociones().addAll(darObjetosBasicos());
		if (auxInt > 1) {
			enemigo.getPociones().addAll(darObjetosAtaque());
			enemigo.getPociones().addAll(darObjetosDefensa());
		} else {
			auxInt = r.nextInt(2);
			if (auxInt < 1) {
				enemigo.getPociones().addAll(darObjetosAtaque());
			} else {
				enemigo.getPociones().addAll(darObjetosDefensa());
			}
		}

		return enemigo;
	}

	// Me he dado cuneta de que no tiene porque un arma ser mas fuerte que la otra
	// Sino que dependen de la estrategia en la que este el jugador
	// Si va ful dano o full defensa asi que repartimos estas 2 en 50%
	private Arma darArmaXArma(){
		/*
		jugador = referencia al jugador
		nombre = no se como crear los nombres de las armas.
		float dano = jugador.getDano() * random entre 0.9 - 1.1.
		return new Arma(nombre, dano, fuerza del enemigo);
		*/
	}

	private Arma darArmaXArmadura(){
		/*
		jugador = referencia al jugador
		nombre = no se como crear los nombres de las armas.
		float dano = jugado.getVida.getValue + jugador.getVida.getDiferencia / random de (2, 4);
		return new Arma(nombre, dano, fuerza del enemigo);
		*/
	}

	private ModificadorVida darArmaduraXArma(){
		/*
		jugador = referencia al jugador
		nombre = no se como crear los nombres de las armas.
		float defensa = (jugador.getDanoMaximo() - enemigo.getVida.getValue) / random de (2, 4).
		return new ModificadorVida(nombre, dano, fuerza del enemigo);
		*/
	}

	private ModificadorVida darArmaduraXArmadura(){
		/*
		jugador = referencia al jugador
		nombre = no se como crear los nombres de las armas.
		// tienes que restarle la vida el enemigo porque la armadura es un decorador
		float dano = (jugado.getVida.getValue - enemigo.getVida.getValue) * random de (0.9, 1.1);
		return new ModificadorVida(nombre, dano, fuerza del enemigo);
		*/
	}

	private ArrayList<Pocion> darObjetosBasicos(){
		// Como tu consideres pero solo pociones de vida y pociones de afilado.
	}

	private ArrayList<Pocion> darObjetosAtaque(){
		// Como tu quieras distribuirlos
		// Solo Pociones de paralisis, inflamables y reduccion de agilidad.
	}

	private ArrayList<Pocion> darObjetosDefensa(){
		// Como tu quieras distribuirlos
		// Solo Pociones de Anti-paralisis, anti-inflamables y de aumento de la agilidad.
	}
}
