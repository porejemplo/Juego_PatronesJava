package Personajes.Enemigos;

import java.util.Collection;
import java.util.Random;
import java.util.ArrayList;

import Atributos.ModificadorDano;
import Atributos.ModificadorVida;
import Pociones.Pocion;

public class FabricaEnemigos {

	//funcion que crea enemigos
	public Enemigo crearEnemigo(catEnemigo enemigo) {
		Random r = new Random();
		Random tipoEnemigo = new Random();
		int auxInt = r.nextInt(3);
		int tipo = tipoEnemigo.nextInt(1);
		//crea un enemigo aleatorio
		switch (auxInt) {
			case 0:
				enemigo = catEnemigo.guerrero;
				//una vez creado tambien se elige aleatoriamente la naturaleza del enemigo
				if(tipo == 0) {
					Enemigo enemigoAgresivo = new EnemigoAgresivo(enemigo);
					decorarEnemigo(enemigoAgresivo);
					return enemigoAgresivo;
				}else {
					Enemigo enemigoPasivo = new EnemigoPasivo(enemigo);
					decorarEnemigo(enemigoPasivo);
					return enemigoPasivo;
				}
			case 1:
				enemigo = catEnemigo.hechicero;
				if(tipo == 0) {
					Enemigo enemigoAgresivo = new EnemigoAgresivo(enemigo);
					decorarEnemigo(enemigoAgresivo);
					return enemigoAgresivo;
				}else {
					Enemigo enemigoPasivo = new EnemigoPasivo(enemigo);
					decorarEnemigo(enemigoPasivo);
					return enemigoPasivo;
				}
			default:
				enemigo = catEnemigo.mutante;
				if(tipo == 0) {
					Enemigo enemigoAgresivo = new EnemigoAgresivo(enemigo);
					decorarEnemigo(enemigoAgresivo);
					return enemigoAgresivo;
				}else {
					Enemigo enemigoPasivo = new EnemigoPasivo(enemigo);
					decorarEnemigo(enemigoPasivo);
					return enemigoPasivo;
				}
		}
	}
	
	public void decorarEnemigo(Enemigo enemigo) {
		// Por ultimo tenemos que llamar para que le den los decoradores.
		// decorador de armas
		Random r = new Random();
		int auxInt;
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
	}

	private ArrayList<Pocion> darObjetosDefensa() {
		// TODO Auto-generated method stub
		return null;
	}

	private ArrayList<Pocion> darObjetosAtaque() {
		// TODO Auto-generated method stub
		return null;
	}

	private ArrayList<Pocion> darObjetosBasicos() {
		// TODO Auto-generated method stub
		return null;
	}

	private ModificadorVida darArmaduraXArmadura() {
		// TODO Auto-generated method stub
		return null;
	}

	private ModificadorVida darArmaduraXArma() {
		// TODO Auto-generated method stub
		return null;
	}

	private ModificadorDano darArmaXArmadura() {
		// TODO Auto-generated method stub
		return null;
	}

	private ModificadorDano darArmaXArma() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
