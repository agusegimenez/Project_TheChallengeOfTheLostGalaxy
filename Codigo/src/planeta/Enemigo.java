package planeta;

import Nave.*;

public class Enemigo {
	private int poderDeAtaque;
	private int uadeCoin;
	private int vida = 100;
	
	public Enemigo(int poderAtaque) {
		this.poderDeAtaque = poderAtaque;
		this.uadeCoin = calcularCantidadDeUadeCoins();
	}
	
	public int getPoderAtaque() {
		return(this.poderDeAtaque);
	}
	
	public int getVida() {
		return(this.vida);
	}
	
	public void atacar(Nave nave) {
		int ataqueEnemigo = getPoderAtaque();
		nave.recibirDaño(ataqueEnemigo);
	}	
	
	public void recibirDaño(int daño) {
		this.vida -= daño;
	}
	
	private int calcularCantidadDeUadeCoins() {
		return(this.poderDeAtaque*2);
	}
	
}
