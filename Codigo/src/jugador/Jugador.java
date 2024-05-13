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
        // Sumamos el precio del arma al total de Uadecoins del jugador
        this.cantidadUadeCoins += nave.getArma().getPrecio();
        // Equipamos automáticamente un arma básica con atributos predeterminados
        this.nave.equiparArma(new Arma(10, 0)); // Por ejemplo, un arma básica con poder 10 y precio 0
    }
    
	//Es el precio de la cantidad de escudo 1 a 1 con las monedas?
    public void venderEscudo() {
        // Sumamos el precio del escudo al total de Uadecoins del jugador
        this.cantidadUadeCoins += nave.getEscudo().getPrecio();
        // Equipamos automáticamente un escudo básico con atributos predeterminados
        this.nave.equiparEscudo(new Escudo(20, 0)); // Por ejemplo, un escudo básica con defensa 20 y precio 0
    }
	
	public void disparar(Enemigo enemigo) {
		int poderAtaqueNave = nave.getPoderDeAtaque();
		enemigo.recibirDaño(poderAtaqueNave);
		System.out.println("Se le inflijo al enemigo"+poderAtaqueNave+"puntos de daño");
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
	
	public Planeta getPlanetaActual() {
		return(this.planetaActual);
	}
}
