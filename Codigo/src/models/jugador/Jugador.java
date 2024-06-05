package models.jugador;

import models.Nave.*;
import models.sistemaEstelar.*;
import models.equipamiento.Arma;
import models.equipamiento.Escudo;


public class Jugador {
	private String idJugador;
	private Nave nave;
	private int cantidadUadeCoins = 100;
	private Planeta planetaActual;
	private SistemaEstelar sistemaActual;

	public Planeta getPlanetaActual() {
		return(this.planetaActual);
	}
	
	public Jugador(String id) {
		this.idJugador = id;
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

	public int getUadeCoins() {
		return(this.cantidadUadeCoins);
	}


    public void venderArma1() {
    	if(estoyEnPlanetaNeutral()) {
    		// Sumamos el precio del arma1 al total de Uadecoins del models.jugador
        	cantidadUadeCoins += nave.getArma1().getPrecio();
        	// Equipamos automáticamente un arma1 básica con atributos predeterminados
        	nave.setArma1(new Arma(10, 0, "Arma Basica"));
    	}
    }

	public void venderArma2() {
		if(estoyEnPlanetaNeutral()) {
			// Sumamos el precio del arma1 al total de Uadecoins del models.jugador
			this.cantidadUadeCoins += nave.getArma2().getPrecio();
			nave.noTiene2Armas();
			nave.setPoderDeAtaque(nave.calcularDañoNave(nave.getArma1().getPoder()));
		}
	}

    public void venderEscudo() {
        if(estoyEnPlanetaNeutral()) {
    	// Sumamos el precio del escudo al total de Uadecoins del models.jugador
        	this.cantidadUadeCoins += nave.getEscudo().getPrecio();
        // Equipamos automáticamente un escudo básico con atributos predeterminados
        	this.nave.setEscudo(new Escudo(20, 0, "Escudo Basico")); // Por ejemplo, un escudo básica con defensa 20 y precio 0
        }
    }
	
	public void disparar(Enemigo enemigo) {
		int poderAtaqueNave = nave.getPoderDeAtaque();
		enemigo.recibirDaño(poderAtaqueNave);
		System.out.println("Se le infringió al enemigo "+ poderAtaqueNave + " puntos de daño");
	}
	
	public void recargarCombustible(int cantidadCombustible) {
		if(this.cantidadUadeCoins >= cantidadCombustible && estoyEnPlanetaNeutral()) {
			nave.cargarCombustible(cantidadCombustible);
			restarUadeCoins(cantidadCombustible);
		}
	}
	
	public void visitarPlaneta(Planeta planeta, SistemaEstelar sistemaActual) {
		this.planetaActual = planeta;
		this.sistemaActual = sistemaActual;
		nave.viajarAPlaneta(planeta.getCostoDeCombustible());
		if(planetaActual.soyHostil()){
			encuentroConEnemigo();
		}
	}

	public void atravesarCinturon(int poderDelCinturon){
		int vidaAntes = this.nave.getVida();
		this.nave.recibirDañoCinturon(poderDelCinturon);
		int vidaPerdida = (vidaAntes-this.nave.getVida());
		sumarUadeCoins(poderDelCinturon, vidaPerdida);
	}


	private void encuentroConEnemigo() {

		Enemigo enemigo = planetaActual.getEnemigo();
		int vidaActual = nave.getVida();

		// El encuentro no termina hasta que alguna pierda toda la vida.
		while (nave.getVida() > 0 && enemigo.getVida() > 0) {
			disparar(enemigo);
			enemigo.atacar(nave);
			imprimirEstadoActual();
		}
		//Verifico victoria si encuentra tesoro y le suma uadeCoins ganadas.
		if (nave.getVida() > 0) {
			sumarUadeCoins(enemigo.getUadeCoins(), vidaActual - nave.getVida());
			System.out.println("Enemigo vencido, vida total perdida: " + (vidaActual - nave.getVida()));
			if (planetaActual.tieneTesoro()) {
				System.out.println("Encontraste el tesoro, juego terminado");
			}
		} else {
			System.out.println("El models.jugador fue derrotado. Juego terminado.");
		}
	}

	private boolean estoyEnPlanetaNeutral() {
		return(planetaActual.soyNeutral());
	}
	
	public void sumarUadeCoins(int cantidad, int vidaPerdida) {
		this.cantidadUadeCoins += cantidad - vidaPerdida;
	}
	
	public void comprarArma1() {
		Arma arma = planetaActual.getArma();
		if(this.cantidadUadeCoins >= arma.getPrecio() && estoyEnPlanetaNeutral()) {
			restarUadeCoins(arma.getPrecio());
			this.nave.setArma1(arma);
		}
	}

	public void comprarArma2(){
		Arma arma = planetaActual.getArma();
		if(this.cantidadUadeCoins >= arma.getPrecio() && estoyEnPlanetaNeutral()) {
			restarUadeCoins(arma.getPrecio());
			this.nave.setArma2(arma);
		}
	}
	
	public void comprarEscudo() {
		Escudo escudo = planetaActual.getEscudo();
		if(this.cantidadUadeCoins >= escudo.getPrecio() && estoyEnPlanetaNeutral()) {
			restarUadeCoins(escudo.getPrecio());
			venderEscudo();
			this.nave.setEscudo(escudo);
		}else {
			System.out.println("Imposible realizar compra, uadeCoins insuficientes");
		}
	}
	
	private void restarUadeCoins(int cantidad) {
		this.cantidadUadeCoins -= cantidad;
	}
	
	public void imprimirEstadoActual() {
		System.out.println("Vida actual "+ this.getNave().getVida());
		System.out.println("Escudo actual "+ this.getNave().getEscudo().getProteccion());
		System.out.println("Uadecoins totales " + this.cantidadUadeCoins);
		System.out.println("Poder de ataque de la nave " + this.nave.getPoderDeAtaque());
		System.out.println("Nombre de la nave " + this.nave.getId());
		System.out.println("Nombre del arma1 " + this.nave.getArma1().getId());
		System.out.println("Nombre del escudo " + this.nave.getEscudo().getId());
		System.out.println("Cantidad de combustible " + this.nave.getCombustible());
	}

	public void repararNave(){
		if(planetaActual.soyAliado()){
			nave.reparar();
		}
	}

	public void moverDeSistema(SistemaEstelar nuevoSistema){
		nave.viajarASistema(nuevoSistema.getCombustible());
		this.sistemaActual = nuevoSistema;
		if(sistemaActual.tieneCinturon()){
			CinturonAsteroides cinturonAsteroides = sistemaActual.getCinturonAsteroides();
			this.atravesarCinturon(cinturonAsteroides.getPoderDelCinturon());
		}
		System.out.println("El jugador se ha movido a: " + nuevoSistema.getNombre());
	}

	public void comprarInformacion(MapaEstelar mapaEstelar){
		if(planetaActual.soyAliado() && cantidadUadeCoins >= planetaActual.getPrecioInformacion()){
			restarUadeCoins(planetaActual.getPrecioInformacion());
			SistemaEstelar sistemaEstelar = mapaEstelar.buscarSistemaConTesoro();
			if(sistemaEstelar != null){
				System.out.println("El tesoro se encuentra en este sistema " + sistemaEstelar.getNombre());
			}else{
				System.out.println("Todavia no se encontro un sistema con el tesoro, monedas reitegradas ");
				cantidadUadeCoins += planetaActual.getPrecioInformacion();
			}
		}
	}

}
