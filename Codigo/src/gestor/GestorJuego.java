package gestor;

import jugador.*;
import Nave.*;
import planeta.*;
import java.util.ArrayList;
import java.util.List;
import equipamiento.*;

public class GestorJuego {
	private List<Planeta> planetas;
	private List<Nave> naves;
	private Jugador jugador;
	
	public Planeta generarPlanetaNeutral(String id, int cantCombustible, Arma arma, Escudo escudo) {
		PlanetaNeutral planeta = new PlanetaNeutral(id, cantCombustible, arma, escudo); // aca estamos seteando valores? esto no deberiamos hacerlo en el main
		planetas.add(planeta);
		return(planeta);
	}
	public Planeta generarPlanetaHostil(String id, int cantCombustible) {
		PlanetaHostil planeta = new PlanetaHostil(id, cantCombustible); 
		planetas.add(planeta);											// aca estamos seteando valores? esto no deberiamos hacerlo en el main
		return(planeta);												// no agus, la fachada se encarga de recibir los valores del main
																		// y instanciar los objetos
	}
	
	//Agregado por Alexis
    public GestorJuego() {
        this.planetas = new ArrayList<>(); // Inicializa la lista de planetas
        this.naves = new ArrayList<>(); // Inicializa la lista de naves
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
	
	public Nave crearNaveAegis(String id, int combustible, int vida, int velocidad, Arma arma, Escudo escudo) {
		NaveAegis naveAegis = new NaveAegis(id, combustible, vida, velocidad, arma, escudo);
		naves.add(naveAegis);
		return(naveAegis);
	}
	
	public Nave crearNaveSwift(String id, int combustible, int vida, int velocidad, Arma arma, Escudo escudo) {
		NaveSwift naveSwift = new NaveSwift(id, combustible, vida, velocidad, arma, escudo);
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
	
	public void verificarDerrota() {
	}
	public void verificarVictoria() {
	}
	
	
}

