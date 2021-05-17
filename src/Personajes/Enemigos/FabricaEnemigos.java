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
		int auxInt = r.nextInt(2);
		//crea un enemigo aleatorio
		switch (auxInt) {
			case 0:
				enemigo = catEnemigo.guerrero;
				return naturalezaEnemigo(enemigo);
			case 1:
				enemigo = catEnemigo.hechicero;
				return naturalezaEnemigo(enemigo);
			default:
				enemigo = catEnemigo.mutante;
				return naturalezaEnemigo(enemigo);
		}
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
		// Por ultimo tenemos que llamar para que le den los decoradores.
		// decorador de armas y decorador de armaduras
		Random r = new Random();
		int auxInt;
		auxInt = r.nextInt(1);
		if (auxInt < 1) {
			enemigo.addDecoradorDano(darArmaXArma());
			enemigo.addDecoradorVida(darArmaduraXArma());
		} else {
			enemigo.addDecoradorDano(darArmaXArmadura());
			enemigo.addDecoradorVida(darArmaduraXArmadura());
		}

		// Anadir objetos
		auxInt = r.nextInt(3);
		enemigo.getPociones().addAll(darObjetosBasicos());
		if (auxInt > 1) {
			enemigo.getPociones().addAll(darObjetosAtaque());
			enemigo.getPociones().addAll(darObjetosDefensa());
		} else {
			auxInt = r.nextInt(1);
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
