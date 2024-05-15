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

	public void trasladarAPlaneta(Jugador jugador) {
		System.out.println("Selecciona un planeta para viajar:");
		for (int i = 0; i < planetas.size(); i++) {
			Planeta p = planetas.get(i);
			System.out.println(i + " - " + p.getIdPlaneta() + " (Combustible necesario: " + p.getCostoDeCombustible() + ")"); //aca basicamente estamos imprimiendo por pantalla los planetas disponibles con el combustible necesario
		}

		Scanner scanner = new Scanner(System.in);
		int eleccion = scanner.nextInt();
		scanner.close();
		if (eleccion < 0 || eleccion >= planetas.size()) {
			System.out.println("Elección inválida. Intenta de nuevo."); //validamos la entrada de datos
			return;
		}
		
		Planeta destino = planetas.get(eleccion);
		int combustibleNecesario = destino.getCostoDeCombustible();

		if (jugador.getNave().getCombustible() >= combustibleNecesario) { // en este if, si el combustible necesario es menor al que dispone, se trasalada
			jugador.visitarPlaneta(destino);
			jugador.getNave().consumirCombustible(combustibleNecesario);
			System.out.println("Has viajado a " + destino.getIdPlaneta());
		} else {
			System.out.println("No tienes suficiente combustible para viajar a " + destino.getIdPlaneta());
		}
	}
	
	
	public boolean verificarVictoria(Planeta planeta) {
		return(planeta.tieneTesoro());
	}
	
	public void encuentroConEnemigo() {
		Planeta planetaActual = this.jugador.getPlanetaActual();
		Nave naveJugador = this.jugador.getNave();
		Enemigo enemigo = planetaActual.getEnemigo();
		int vidaActual = naveJugador.getVida();
		
		
		// El encuentro no termina hasta que alguna pierda toda la vida.
			
		while (naveJugador.getVida() > 0 && enemigo.getVida() > 0) {
				jugador.disparar(enemigo);
				enemigo.atacar(naveJugador);
				jugador.imprimirEstadoActual();
				enemigo.imprimirEstadoEnemigo();
			}
		//Verifico victoria si encuentra tesoro y le suma uadeCoins ganadas.
		
		if(jugador.getNave().getVida() > 0) {
			this.jugador.sumarUadeCoins(enemigo.getUadeCoins(), vidaActual - naveJugador.getVida());
			this.jugador.imprimirEstadoActual();
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
	
	public void comprarArma(String idArma) {
		Arma arma = buscarArma(idArma);
		this.jugador.comprarArma(arma);
	}
	
	public void comprarEscudo(String idEscudo) {
		Escudo escudo = buscarEscudo(idEscudo);
		this.jugador.comprarEscudo(escudo);
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
			if(escudo.getId()==idEscudo) {
				return(escudo);
			}
		}
		throw new IllegalArgumentException("No se encontró una nave con el ID especificado: " + idEscudo);
	
	}
}

