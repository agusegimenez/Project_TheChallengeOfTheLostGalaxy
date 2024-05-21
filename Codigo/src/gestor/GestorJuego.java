package gestor;

import jugador.*;
import Nave.*;
import planeta.*;
import java.util.ArrayList;
import java.util.List;
import equipamiento.*;
import java.util.Scanner;

public class GestorJuego {
	private List<Planeta> planetas;
	private List<Nave> naves;
	private Jugador jugador;
	private List<Arma> armas;
	private List<Escudo> escudos;
	
	public Planeta generarPlanetaNeutral(String id, int cantCombustible, String idArma, String idEscudo) {
		Escudo escudo = buscarEscudo(idEscudo);
		Arma arma = buscarArma(idArma);
		PlanetaNeutral planeta = new PlanetaNeutral(id, cantCombustible, arma, escudo); 
		planetas.add(planeta);
		return(planeta);
	}
	public Planeta generarPlanetaHostil(String id, int cantCombustible) {
		PlanetaHostil planeta = new PlanetaHostil(id, cantCombustible); 
		planetas.add(planeta);	
		return(planeta);
	}
	
	//Agregado por Alexis
    public GestorJuego() {
        this.planetas = new ArrayList<>(); // Inicializa la lista de todo
        this.naves = new ArrayList<>(); 
        this.armas = new ArrayList<>();
        this.escudos = new ArrayList<>();
    }

	//Agregado por Alexis
    private void crearPlanetasYNaves() {
        this.planetas = new ArrayList<>(); // Inicializa la lista de planetas
        this.naves = new ArrayList<>(); // Inicializa la lista de naves
    }
    
	//Agregado por Alexis
    public void inicializarListas() {
        crearPlanetasYNaves();
    }
    
	public Jugador crearJugador(String id) {
		Jugador jugador = new Jugador(id);
		this.jugador = jugador;
		return(jugador);
	}
	
	private Nave buscarNave(String idNave) {
		for (Nave nave : naves) {
			if(nave.getId()==idNave) {
				return(nave);
			}
		}
		throw new IllegalArgumentException("No se encontró una nave con el ID especificado: " + idNave);
	}
	
	public void asignarNaveAJugador(String idNave) {
		Nave nave = buscarNave(idNave);
		jugador.setNave(nave);
	}
	
	public Nave crearNaveAegis(String id, int combustible, int vida, int velocidad) {
		NaveAegis naveAegis = new NaveAegis(id, combustible, vida, velocidad);
		naves.add(naveAegis);
		return(naveAegis);
	}
	
	public Nave crearNaveSwift(String id, int combustible, int vida, int velocidad) {
		NaveSwift naveSwift = new NaveSwift(id, combustible, vida, velocidad);
		naves.add(naveSwift);
		return(naveSwift);
	}

	public void trasladarAPlaneta(String idPlaneta) {
		Planeta planeta = buscarPlaneta(idPlaneta);
		jugador.visitarPlaneta(planeta);
		if(planeta.soyHostil()){
			encuentroConEnemigo();
		}

	}
	
	public boolean verificarVictoria(Planeta planeta) {
		return(planeta.tieneTesoro());
	}
	
	private void encuentroConEnemigo() {

		Planeta planetaActual = this.jugador.getPlanetaActual();
		Nave naveJugador = this.jugador.getNave();
		Enemigo enemigo = planetaActual.getEnemigo();
		int vidaActual = naveJugador.getVida();
		
		
		// El encuentro no termina hasta que alguna pierda toda la vida.
			
		while (naveJugador.getVida() > 0 && enemigo.getVida() > 0) {
				jugador.disparar(enemigo);
				enemigo.atacar(naveJugador);
				jugador.imprimirEstadoActual();
			}
		//Verifico victoria si encuentra tesoro y le suma uadeCoins ganadas.
		
		if(jugador.getNave().getVida() > 0) {
			this.jugador.sumarUadeCoins(enemigo.getUadeCoins(), vidaActual - naveJugador.getVida());
			System.out.println("Enemigo vencido, vida total perdida: " + (vidaActual - naveJugador.getVida()) );
			if(verificarVictoria(planetaActual)) {
				System.out.println("Encontraste el tesoro, juego terminado");
			}
		}else {
			System.out.println("El jugador fue derrotado. Juego terminado.");
		}
		
	}
	
	public Arma agregarArma(int poder, int precio, String id) {
		Arma arma = new Arma(poder, precio, id);
		armas.add(arma);
		return arma;
	}
	
	public Escudo agregarEscudo(int defensa, int precio, String id) {
		Escudo escudo = new Escudo(defensa, precio, id);
		escudos.add(escudo);	
		return escudo;
	}
	
	public void comprarArma() {
		this.jugador.comprarArma();
	}
	
	public void comprarEscudo() {
		this.jugador.comprarEscudo();
	}
	public void venderArma(){
		this.jugador.venderArma();
	}
	public void venderEscudo(){
		this.jugador.venderEscudo();
	}
	
	public Arma buscarArma(String idArma) {
		for (Arma arma : armas) {
			if(arma.getId()==idArma) {
				return(arma);
			}
		}
		throw new IllegalArgumentException("No se encontró una nave con el ID especificado: " + idArma);
	
	}
	
	public Escudo buscarEscudo(String idEscudo) {
		for (Escudo escudo : escudos) {
			if(escudo.getId() == idEscudo) {
				return(escudo);
			}
		}
		throw new IllegalArgumentException("No se encontró una nave con el ID especificado: " + idEscudo);
	
	}

	public Planeta buscarPlaneta(String idPlaneta) {
		for (Planeta planeta : planetas) {
			if(planeta.getIdPlaneta() == idPlaneta) {
				return(planeta);
			}
		}
		throw new IllegalArgumentException("No se encontró una nave con el ID especificado: " + idPlaneta);

	}
}

