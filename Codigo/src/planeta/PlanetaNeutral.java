package planeta;

import equipamiento.*;

public class PlanetaNeutral extends Planeta{
	
	private Arma arma;
	private Escudo escudo;
	
	public PlanetaNeutral(String id, int costo) {
		super(id, costo);
		//Implementar la creacion de los objetos que tendra a la venta
		// ya sea que los pide en el constructor o los genera.
	}

}
