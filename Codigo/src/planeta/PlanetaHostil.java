package planeta;

import java.util.Random;

public class PlanetaHostil extends Planeta{
	private Enemigo enemigo;
	private boolean tieneTesoro;

	public PlanetaHostil(String id, int costo) {
		super(id, costo);
		tieneTesoro = definirSiTieneTesoro();
		this.enemigo = crearEnemigo();
	}

	public Enemigo getEnemigo() {
		return enemigo;
	}

	public boolean tieneTesoro() {
		return tieneTesoro;
	}
	
	private boolean definirSiTieneTesoro() {
		Random numeroAleatorio = new Random();
		int numero = numeroAleatorio.nextInt(6);
		return( numero == 1);
	}
	
	private Enemigo crearEnemigo() {
		Random randomNumber = new Random();
		int numeroAleatorio = randomNumber.nextInt(101) + 50;
		Enemigo enemigo = new Enemigo(numeroAleatorio);
		return(enemigo);
	}
	
}
