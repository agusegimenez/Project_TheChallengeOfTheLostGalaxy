package planeta;

import equipamiento.*;

public class PlanetaNeutral extends Planeta{
	
	private Arma arma;
	private Escudo escudo;

	public PlanetaNeutral(String idPlaneta, boolean estaExplorado, int costoDeCombustible, Arma arma, Escudo escudo) {
		super(idPlaneta, estaExplorado, costoDeCombustible);
		this.arma = arma;
		this.escudo = escudo;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Escudo getEscudo() {
		return escudo;
	}

	public void setEscudo(Escudo escudo) {
		this.escudo = escudo;
	}
}
