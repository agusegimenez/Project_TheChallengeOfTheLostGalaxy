package gestor;

import jugador.*;
import Nave.*;
import planeta.*;
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
	
	
	public void verificarDerrota() {
	}
	public void verificarVictoria() {
	}
	
	
	
}

