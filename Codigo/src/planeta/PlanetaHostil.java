package planeta;

import java.util.Random;
import equipamiento.*;

public class PlanetaHostil extends Planeta{
	private Enemigo enemigo;
	private boolean tieneTesoro;

	public PlanetaHostil(String id, int costo) {
		super(id, costo);
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

	@Override
	public Arma getArma() {
		throw new IllegalArgumentException("No soy un planeta neutral");
	}

	@Override
	public Escudo getEscudo() {
		throw new IllegalArgumentException("No soy un planeta neutral");
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
	
	public boolean soyHostil() {
		return(true);
	}
	public boolean soyNeutral() {
		return(false);
	}
	
}
