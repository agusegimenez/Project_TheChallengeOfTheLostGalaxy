package jugador;

import Nave.*;
import planeta.*;


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
		this.cantidadUadeCoins += nave.getArma().getPrecio();
	}
	//Es el precio de la cantidad de escudo 1 a 1 con las monedas?
	public void venderEscudo() {
		this.cantidadUadeCoins += nave.getEscudo().getPrecio();
		nave.getEscudo().setProteccion(0);
	}
	
	public void disparar(Enemigo enemigo) {
		int poderAtaqueNave = nave.getPoderDeAtaque();
		enemigo.recibirDaño(poderAtaqueNave);
	}
	
	public void recargarCombustible(int cantidadCombustible) {
		if(this.cantidadUadeCoins >= cantidadCombustible) {
			if(estoyEnPlanetaNeutral()) {
				nave.cargarCombustible(cantidadCombustible);
				this.cantidadUadeCoins = this.cantidadUadeCoins - cantidadCombustible;
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
}
