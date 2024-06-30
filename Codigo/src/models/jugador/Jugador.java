package models.jugador;

import models.Nave.*;
import models.sistemaEstelar.*;
import models.equipamiento.Arma;
import models.equipamiento.Escudo;
import view.JugadorView;
import view.SistemaEstelarView;

import java.util.ArrayList;
import java.util.Comparator;


public class Jugador {
	private String idJugador;
	private Nave nave;
	private int cantidadUadeCoins = 10000;
	private Planeta planetaActual;
	private SistemaEstelar sistemaActual;
	private int cantidadDeEnemigosDerrotados = 0;

	public Planeta getPlanetaActual() {
		return(this.planetaActual);
	}

	public SistemaEstelar getSistemaActual() {
		return sistemaActual;
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

	public void venderArma(int indiceArmaUsuario) {
		if (estoyEnPlanetaNeutral()) {
				// Restamos 1 al índice para adaptarlo a la indexación basada en 0
				int indiceArma = indiceArmaUsuario - 1;

				// Verificar si el índice está dentro del rango de la lista de armas.
				if (indiceArma >= 0 && indiceArma < nave.getArmas().size()) {
					Arma armaAVender = nave.getArmas().get(indiceArma);
					// Sumamos el precio del arma vendida al total de Uadecoins del jugador
					cantidadUadeCoins += armaAVender.getPrecio();
					// Eliminamos la arma de la lista de armas de la nave
					nave.getArmas().remove(indiceArma);
					if(nave.getArmas().size() == 0){
						nave.agregarArma(new Arma(10,0,"Arma Basica"));
					}
				} else {
					throw new IllegalArgumentException();
				}
		}
	}
	public String verArmas() {
		ArrayList<Arma> armas = this.nave.getArmas();
		StringBuilder armasInfo = new StringBuilder();

		for (Arma arma : armas) {
			armasInfo.append(arma.getId()).append(", Poder: ").append(arma.getPoder()).append(", Precio: ").append(arma.getPrecio()).append("\n");
		}

		return armasInfo.toString();
	}

    public void venderEscudo() {
        if(estoyEnPlanetaNeutral()) {
    	// Sumamos el precio del escudo al total de Uadecoins del models.jugador
        	this.cantidadUadeCoins += nave.getEscudo().getPrecio();
        // Equipamos automáticamente un escudo básico con atributos predeterminados
        	this.nave.setEscudo(new Escudo(20, 0, "Escudo Basico")); // Por ejemplo, un escudo básica con defensa 20 y precio 0
        }
    }
	
	private void disparar(Enemigo enemigo) {
		int poderAtaqueNave = nave.getPoderDeAtaque();
		enemigo.recibirDaño(poderAtaqueNave);
		// System.out.println("Se le infringió al enemigo "+ poderAtaqueNave + " puntos de daño");
	}
	
	public void recargarCombustible(int cantidadCombustible) {
		if(this.cantidadUadeCoins >= cantidadCombustible && planetaActual.soyAliado()){
			nave.cargarCombustible(cantidadCombustible);
			restarUadeCoins(cantidadCombustible);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	public Planeta visitarPlaneta(Planeta planeta, SistemaEstelar sistemaActual){
		this.planetaActual = planeta;
		this.sistemaActual = sistemaActual;
		nave.viajarAPlaneta(planeta.getCostoDeCombustible());
		if(sistemaActual.tieneCinturon()){
			nave.atravesarCinturon(sistemaActual.getCinturonAsteroides().getPoderDelCinturon());
		}
		if(planetaActual.soyHostil()){
			encuentroConEnemigo();
		}
		return planeta;
	}


	private void encuentroConEnemigo() {

		Enemigo enemigo = planetaActual.getEnemigo();
		int vidaActual = nave.getVida();

		// El encuentro no termina hasta que alguna pierda toda la vida.
		while (nave.getVida() > 0 && enemigo.getVida() > 0) {
			disparar(enemigo);
			enemigo.atacar(nave);
			// imprimirEstadoActual();
		}
		//Verifico victoria si encuentra tesoro y le suma uadeCoins ganadas.
		if (nave.getVida() > 0) {
			sumarUadeCoins(enemigo.getUadeCoins(), vidaActual - nave.getVida());
			//System.out.println("Enemigo vencido, vida total perdida: " + (vidaActual - nave.getVida()));
			cantidadDeEnemigosDerrotados ++;
//			if (planetaActual.tieneTesoro()) {
//				System.out.println("Encontraste el tesoro, juego terminado");
//			}
//		} else {
//			System.out.println("El models.jugador fue derrotado. Juego terminado.");
		}
	}

	private boolean estoyEnPlanetaNeutral() {
		return(planetaActual.soyNeutral());
	}
	
	public void sumarUadeCoins(int cantidad, int vidaPerdida) {
		this.cantidadUadeCoins += cantidad - vidaPerdida;
	}
	
	public void comprarArma() {
		Arma arma = planetaActual.getArma();
		ArrayList<Arma> armasNave = this.nave.getArmas(); // Asume que getArmamentos() devuelve la lista de armas de la nave

		// Ordenar la lista de armas de menor a mayor según el poder del arma
		armasNave.sort(Comparator.comparingInt(Arma::getPoder));

		if (this.cantidadUadeCoins >= arma.getPrecio() && estoyEnPlanetaNeutral() && armasNave.size() < 2) {
			restarUadeCoins(arma.getPrecio());
			if (armasNave.size() == 1) {
				// Si solo hay una arma, simplemente agregar la nueva arma
				armasNave.add(arma);
			} else if (armasNave.size() == 2) {
				// Si hay 2 armas, reemplazar el arma en el índice 0 (la menos potente)
				armasNave.set(0, arma);
			}

		}else{
			throw new IllegalArgumentException();
		}
	}

	public void comprarEscudo() {
		Escudo escudo = planetaActual.getEscudo();
		if(this.cantidadUadeCoins >= escudo.getPrecio() && estoyEnPlanetaNeutral()) {
			restarUadeCoins(escudo.getPrecio());
			venderEscudo();
			this.nave.setEscudo(escudo);
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	private void restarUadeCoins(int cantidad) {
		this.cantidadUadeCoins -= cantidad;
	}


	public void repararNave(){
		if(planetaActual.soyAliado()){
			nave.reparar();
		}
	}

	public void moverDeSistema(SistemaEstelar nuevoSistema){
		Nave nave = this.getNave();
		this.sistemaActual = nuevoSistema;
		if(sistemaActual.tieneCinturon()){
			int vidaPerdida = nave.atravesarCinturon(sistemaActual.getCinturonAsteroides().getPoderDelCinturon());
			sumarUadeCoins(sistemaActual.getCinturonAsteroides().getPoderDelCinturon(), vidaPerdida);
		}
		// System.out.println("El jugador se ha movido a: " + nuevoSistema.getNombre());
	}

	public SistemaEstelar comprarInformacion(MapaEstelar mapaEstelar){
		if(planetaActual.soyAliado() && cantidadUadeCoins >= planetaActual.getPrecioInformacion()){
			restarUadeCoins(planetaActual.getPrecioInformacion());
			return planetaActual.desplegarInformacion(mapaEstelar);
		}else{
			throw new IllegalArgumentException();
		}

	}


	public JugadorView toView(){
		ArrayList<Arma> armas = nave.getArmas();
		Arma arma = armas.getFirst();
		return new JugadorView(cantidadUadeCoins, nave.getNombreNave(), arma.getId(), nave.getEscudo().getId(), nave.getPoderDeAtaque(), cantidadDeEnemigosDerrotados, nave.toView());

	}

}
