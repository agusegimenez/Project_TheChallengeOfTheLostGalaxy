package planeta;

public class Planeta {
	private String idPlaneta;
	private boolean estaExplorado = false;
	private int costoDeCombustible;
	

	public Planeta(String idPlaneta, int costoDeCombustible) {
		this.idPlaneta = idPlaneta;
		this.costoDeCombustible = costoDeCombustible;
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
}
