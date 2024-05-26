package models.sistemaEstelar;

import models.equipamiento.*;

public abstract class Planeta {
	protected String idPlaneta;
	protected boolean estaExplorado = false;
	protected int costoDeCombustible;
	

	public Planeta(String idPlaneta) {
		this.idPlaneta = idPlaneta;
	}

	public String getIdPlaneta() {
		return idPlaneta;
	}

	public void setIdPlaneta(String idPlaneta) {
		this.idPlaneta = idPlaneta;
	}

	public boolean isEstaExplorado() {
		return estaExplorado;
	}

	public void fueExplorado() {
		this.estaExplorado = true;
	}

	public int getCostoDeCombustible() {
		return costoDeCombustible;
	}

	public void setCostoDeCombustible(int costoDeCombustible) {
		this.costoDeCombustible = costoDeCombustible;
	}
	// Preguntar que tipo de models.planeta es para logica de compra y venta
	public abstract boolean soyHostil();
	public abstract boolean soyNeutral();
	public abstract boolean soyAliado();
	public abstract Enemigo getEnemigo();
	public abstract boolean tieneTesoro();
	public abstract Arma getArma();
	public abstract Escudo getEscudo();
	
}
