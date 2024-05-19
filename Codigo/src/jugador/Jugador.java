package jugador;

import Nave.*;
import planeta.*;
import equipamiento.Arma;
import equipamiento.Escudo;


public class Jugador {
	private String idJugador;
	private Nave nave;
	private int cantidadUadeCoins = 50;
	private Planeta planetaActual;
	
	public Jugador(String id) {
		this.idJugador = id;
	}
	//Como hacemos para que objeto Arma de la nave quede vacio despues de la venta
    public void venderArma() {
    	if(estoyEnPlanetaNeutral()) {
    		// Sumamos el precio del arma al total de Uadecoins del jugador
        	this.cantidadUadeCoins += nave.getArma().getPrecio();
        	// Equipamos automáticamente un arma básica con atributos predeterminados
        	this.nave.equiparArma(new Arma(10, 0, "Arma Basica"));
    	}
    }

    public void venderEscudo() {
        if(estoyEnPlanetaNeutral()) {
    	// Sumamos el precio del escudo al total de Uadecoins del jugador
        	this.cantidadUadeCoins += nave.getEscudo().getPrecio();
        // Equipamos automáticamente un escudo básico con atributos predeterminados
        	this.nave.equiparEscudo(new Escudo(20, 0, "Escudo Basico")); // Por ejemplo, un escudo básica con defensa 20 y precio 0
        }
    }
	
	public void disparar(Enemigo enemigo) {
		int poderAtaqueNave = nave.getPoderDeAtaque();
		enemigo.recibirDaño(poderAtaqueNave);
		System.out.println("Se le infringió al enemigo "+ poderAtaqueNave + " puntos de daño");
	}
	
	public void recargarCombustible(int cantidadCombustible) {
		if(this.cantidadUadeCoins >= cantidadCombustible) {
			if(estoyEnPlanetaNeutral()) {
				nave.cargarCombustible(cantidadCombustible);
				restarUadeCoins(cantidadCombustible);
			} 
		}
	
	}
	
	public void visitarPlaneta(Planeta planeta) {
		this.planetaActual = planeta;
	}
	
	public Nave getNave() {
		return(this.nave);
	}
	
	public String getId() {
		return(this.idJugador);
	}
	
	public void setNave(Nave nave) {
		this.nave = nave;
	}
	
	private boolean estoyEnPlanetaNeutral() {
		return(planetaActual.soyNeutral());
	}
	
	public Planeta getPlanetaActual() {
		return(this.planetaActual);
	}
	
	public void sumarUadeCoins(int cantidad, int vidaPerdida) {
		this.cantidadUadeCoins += cantidad - vidaPerdida;
	}
	
	public void comprarArma(Arma arma) {
		if(this.cantidadUadeCoins > arma.getPrecio()) {
			restarUadeCoins(arma.getPrecio());
			this.nave.setArma(arma);
		}else {
			System.out.println("Imposible realizar compra, uadeCoins insuficientes");
		}
	}
	
	public void comprarEscudo(Escudo escudo) {
		if(this.cantidadUadeCoins > escudo.getPrecio()) {
			restarUadeCoins(escudo.getPrecio());
			this.nave.setEscudo(escudo);
		}else {
			System.out.println("Imposible realizar compra, uadeCoins insuficientes");
		}
	}
	
	private void restarUadeCoins(int cantidad) {
		this.cantidadUadeCoins -= cantidad;
	}
	
	public int getUadeCoins() {
		return(this.cantidadUadeCoins);
	}
	
	public void imprimirEstadoActual() {
		System.out.println("Vida actual "+ this.getNave().getVida());
		System.out.println("Escudo actual "+ this.getNave().getEscudo().getProteccion());
		System.out.println("Uadecoins totales " + this.cantidadUadeCoins);
		System.out.println("Poder de ataque de la nave " + this.nave.getPoderDeAtaque());
		System.out.println("Nombre de la nave " + this.nave.getId());
		System.out.println("Nombre del arma " + this.nave.getArma().getId());
		System.out.println("Nombre del escudo " + this.nave.getEscudo().getId());
	}
	
	
	
}
