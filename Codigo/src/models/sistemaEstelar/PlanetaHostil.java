package models.sistemaEstelar;

import java.util.Random;
import models.equipamiento.*;

public class PlanetaHostil extends Planeta{
	private Enemigo enemigo;
	private boolean tieneTesoro;

	public PlanetaHostil(String id) {
		super(id);
		this.costoDeCombustible = 20;
		this.tieneTesoro = definirSiTieneTesoro();
		this.enemigo = crearEnemigo(); //Planeta crea su propio enemigo generado de manera 
									   // aleatoria asi como pide el programa.
	}

	public Enemigo getEnemigo() {
		return enemigo;
	}
	public boolean tieneTesoro() {
		return tieneTesoro;
	}
	public boolean soyHostil() {
		return(true);
	}
	public boolean soyNeutral() {
		return(false);
	}
	public boolean soyAliado(){ return (false);}
	@Override
	public Arma getArma() {
		throw new IllegalArgumentException("No soy un Planeta Neutral");
	}
	@Override
	public Escudo getEscudo() {
		throw new IllegalArgumentException("No soy un Planeta Neutral");
	}

	private boolean definirSiTieneTesoro() {
		Random numeroAleatorio = new Random();
		int numero = numeroAleatorio.nextInt(6);
		return(numero == 1);
	}

	//Crea y asigna de manera aleatoria el poderDeAtaque del enemigo
	private Enemigo crearEnemigo() {  
		Random randomNumber = new Random();
		int poderAtaqueAleatorio = randomNumber.nextInt(101) + 50; // Entre 50 y 150
		Enemigo enemigo = new Enemigo(poderAtaqueAleatorio);
		return(enemigo);
	}
	
}
