package planeta;

import equipamiento.*;

public class PlanetaNeutral extends Planeta{
	
	private Arma arma;
	private Escudo escudo;

	public PlanetaNeutral(String idPlaneta, int costoDeCombustible, Arma arma, Escudo escudo) {
		super(idPlaneta, costoDeCombustible);
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
	
	public boolean soyNeutral() {
		return(true);
	}
	
	public boolean soyHostil() {
		return(false);
	}
	
}
