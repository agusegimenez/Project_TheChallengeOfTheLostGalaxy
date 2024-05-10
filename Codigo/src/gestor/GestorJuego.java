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
	
	public void generarPlanetaNeutral(String id, int cantCombustible, Arma arma, Escudo escudo) {
		PlanetaNeutral planeta = new PlanetaNeutral(id, cantCombustible, arma, escudo); // aca estamos seteando valores? esto no deberiamos hacerlo en el main
		planetas.add(planeta);
	}
	public void generarPlanetaHostil(String id, int cantCombustible) {
		PlanetaHostil planeta = new PlanetaHostil(id, cantCombustible); // aca estamos seteando valores? esto no deberiamos hacerlo en el main
		planetas.add(planeta);											// no agus, la fachada se encarga de recibir los valores del main
																		// y instanciar los objetos
	}
	
	public void crearJugador(String id) {
		
	}
	
	
	public void verificarDerrota() {
	}
	public void verificarVictoria() {
	}
	
	
	
}

