package Personajes.Enemigos;

import java.util.Random;
import java.util.ArrayList;

import Atributos.Arma;
import Atributos.ModificadorVida;
import Personajes.Jugador;
import Pociones.*;
import SingletonPattern.GameManager;

public class FabricaEnemigos {

	//funcion que crea enemigos
	public Enemigo crearEnemigo() {
		Random r = new Random();
		catEnemigo enemigo;
		int auxInt = r.nextInt(2);
		//crea un enemigo aleatorio
		switch (auxInt) {
			case 0:
				enemigo = catEnemigo.guerrero;
				break;
			case 1:
				enemigo = catEnemigo.hechicero;
				break;
			default:
				enemigo = catEnemigo.mutante;
				break;
		}
		return naturalezaEnemigo(enemigo);
	}
	
	//Elige aleatoriamente la naturaleza del enemigo
	public Enemigo naturalezaEnemigo(catEnemigo enemigo) {
		Random tipo = new Random();
		int aux = tipo.nextInt(1);
		
		if(aux == 0) {
			Enemigo enemigoAgresivo = new EnemigoAgresivo(enemigo);
			decorarEnemigo(enemigoAgresivo);
			return enemigoAgresivo;
		}else {
			Enemigo enemigoPasivo = new EnemigoPasivo(enemigo);
			decorarEnemigo(enemigoPasivo);
			return enemigoPasivo;
		}
	}
	
	public void decorarEnemigo(Enemigo enemigo) {
		// decorador de armas
		Random r = new Random();
		int auxInt;
		auxInt = r.nextInt(2);
		if (auxInt < 1) {
			enemigo.addDecoradorDano(darArmaXArma(enemigo));
		} else {
			enemigo.addDecoradorDano(darArmaXArmadura(enemigo));
		}
		
		//Decorador de armaduras
		auxInt = r.nextInt(2);
		if (auxInt < 1) {
			enemigo.addDecoradorVida(darArmaduraXArma(enemigo));
		} else {
			enemigo.addDecoradorVida(darArmaduraXArmadura(enemigo));
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
	}

	private ArrayList<Pocion> darObjetosDefensa() {
		// TODO Auto-generated method stub
		ArrayList<Pocion> lista = new ArrayList<Pocion>();
		Random r = new Random();
		int pocion = r.nextInt(3);
		for(int i = 0; i < pocion; i++) {
			Pocion pocionAntiParalisis = new PocionAntiParalisis();
			lista.add(pocionAntiParalisis);
		}
		pocion = r.nextInt(3);
		for(int i = 0; i < pocion; i++) {
			Pocion pocionAntiInflamable = new PocionAntiInflamable();
			lista.add(pocionAntiInflamable);
		}
		pocion = r.nextInt(3);
		for(int i = 0; i < pocion; i++) {
			Pocion pocionAgilidad = new PocionAgilidad(2,4);
			lista.add(pocionAgilidad);
		}
		return lista;
	}

	private ArrayList<Pocion> darObjetosAtaque() {
		// TODO Auto-generated method stub
		ArrayList<Pocion> lista = new ArrayList<Pocion>();
		Random r = new Random();
		int pocion = r.nextInt(3);
		
		for(int i = 0; i < pocion; i++) {
			Pocion pocionParalisis = new PocionParalisis(65, 3);
			lista.add(pocionParalisis);
		}
		pocion = r.nextInt(3);
		for(int i = 0; i < pocion; i++) {
			Pocion pocionInflamable = new PocionInflamable(2, 4);
			lista.add(pocionInflamable);
		}
		pocion = r.nextInt(3);
		for(int i = 0; i < pocion; i++) {
			Pocion pocionQuitarAgilidad = new PocionAgilidad(-2, 3);
			lista.add(pocionQuitarAgilidad);
		}
		return lista;
	}

	private ArrayList<Pocion> darObjetosBasicos() {
		// TODO Auto-generated method stub
		ArrayList<Pocion> lista = new ArrayList<Pocion>();
		Random r = new Random();
		int pocion = r.nextInt(3);
		for(int i = 0; i < pocion; i++) {
			Pocion pocionVida = new PocionVida(3);
			lista.add(pocionVida);
		}
		pocion = r.nextInt(3);
		for(int i = 0; i < pocion; i++) {
			Pocion pocionAfilado = new PocionAfilado(3);
			lista.add(pocionAfilado);
		}
		return lista;
	}

	private ModificadorVida darArmaduraXArmadura(Enemigo enemigo) {
		// TODO Auto-generated method stub
		Jugador jugador = GameManager.getInstance().getJugador();
		Random r = new Random();
		float valorRandom = (int)0.9 + r.nextInt(3)/10;
		int defensa = (int)((jugador.getDecoradorDano().getDanoMaximo() - enemigo.getDecoradorVida().getValue()) * valorRandom);
		System.out.printf("Aleatorio armaduraXArmadura 0.9-1.1, valor: %f\n", valorRandom);
		return new ModificadorVida(defensa);
	}

	private ModificadorVida darArmaduraXArma(Enemigo enemigo) {
		// TODO Auto-generated method stub
		Jugador jugador = GameManager.getInstance().getJugador();
		Random r = new Random();
		int valorRandom = 2 + r.nextInt(3);
		int defensa = (int)(jugador.getDecoradorDano().getDanoMaximo() - enemigo.getDecoradorVida().getValue()) / valorRandom;
		System.out.printf("Aleatorio armaduraXArma 2-4, valor: %d\n", valorRandom);
		return new ModificadorVida(defensa);
	}

	private Arma darArmaXArmadura(Enemigo enemigo) {
		// TODO Auto-generated method stub
		Jugador jugador = GameManager.getInstance().getJugador();
		final String nombreArma = "ArmaXArmadura";
		Random r = new Random();
		float valorRandom = 2 + (float)r.nextInt(3);
		float dano = (jugador.getDecoradorVida().getValue() + jugador.getDecoradorVida().getDiferencia()) / valorRandom;
		System.out.printf("Aleatorio armaXArmadura 2-5, valor: %f\n", valorRandom);
		return new Arma(nombreArma, dano, enemigo.getFuerza());
	}

	private Arma darArmaXArma(Enemigo enemigo) {
		// TODO Auto-generated method stub
		Jugador jugador = GameManager.getInstance().getJugador();
		final String nombreArma = "ArmaXArma";
		Random r = new Random();
		float valorRandom = 0.9f + ((float)r.nextInt(3)/10);
		float dano = jugador.getDecoradorDano().getValue() * valorRandom;
		
		System.out.printf("Aleatorio armaXArma 0.9-1.1, valor: %f\n", valorRandom);
		return new Arma(nombreArma, dano, enemigo.getFuerza());
	}
	
}
