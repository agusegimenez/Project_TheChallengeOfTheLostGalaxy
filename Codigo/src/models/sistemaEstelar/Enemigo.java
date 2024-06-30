package models.sistemaEstelar;

import models.Nave.*;
import view.EnemigoView;

public class  Enemigo {
	private int poderDeAtaque;
	private int uadeCoin;
	private int vida = 100;
	private int vidaMaxima;

	public int getPoderAtaque() {
		return(this.poderDeAtaque);
	}

	public int getVida() {
		return(this.vida);
	}

	public int getUadeCoins() {
		return(this.uadeCoin);
	}


	public Enemigo(int poderAtaque) {
		this.poderDeAtaque = poderAtaque;
		this.uadeCoin = calcularCantidadDeUadeCoins();
		this.vidaMaxima = vida;
	}

	public void atacar(Nave nave) {
		int ataqueEnemigo = getPoderAtaque();
		nave.recibirDaño(ataqueEnemigo);
	}	
	
	public void recibirDaño(int daño) {
		this.vida = this.vida - daño;
	}
	
	private int calcularCantidadDeUadeCoins() {
		return(this.poderDeAtaque*2);
	}
	
//	public void imprimirEstadoEnemigo() {
//		System.out.println("Vida actual enemigo "+this.vida);
//	}

	public EnemigoView toView(){
		return new EnemigoView(poderDeAtaque,uadeCoin,vidaMaxima);
	}
	
}
