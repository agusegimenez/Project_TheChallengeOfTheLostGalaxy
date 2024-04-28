package jugador;

import Nave.*;

public class Jugador {
	private String idJugador;
	private Nave nave;
	private int cantidadUadeCoins = 0;
	
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
	
	public void disparar() {
	}
	
	public void recargarCombustible() {
	}
	
	public void visitarPlaneta() {
	}
	public Nave getNave() {
		return(this.nave);
	}
	
	public String getId() {
		return(this.idJugador);
	}
}
