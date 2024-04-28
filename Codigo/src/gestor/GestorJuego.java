package gestor;

import jugador.*;
import Nave.*;
import planeta.*;
import java.util.List;


public class GestorJuego {
	private List<Planeta> planetas;
	private List<Nave> naves;
	private Jugador jugador;
	
	public void generarPlanetaNeutral(String id, int cantCombustible) {
		PlanetaNeutral planeta = new PlanetaNeutral(id, cantCombustible);
		planetas.add(planeta);
	}
	public void generarPlanetaHostil(String id, int cantCombustible) {
		PlanetaHostil planeta = new PlanetaHostil(id, cantCombustible);
		planetas.add(planeta);
	}
	
	public void crearJugador(String id) {
		
	}
	
	public void verificarDerrota() {
		
	}
	public void verificarVictoria() {
		
	}
}

