package planeta;

public class Planeta {
	private String idPlaneta;
	private boolean estaExplorado = false;
	private int costoDeCombustible;

	public Planeta(String idPlaneta, boolean estaExplorado, int costoDeCombustible) {
		this.idPlaneta = idPlaneta;
		this.estaExplorado = estaExplorado;
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

	public void setEstaExplorado(boolean estaExplorado) {
		this.estaExplorado = estaExplorado;
	}

	public int getCostoDeCombustible() {
		return costoDeCombustible;
	}

	public void setCostoDeCombustible(int costoDeCombustible) {
		this.costoDeCombustible = costoDeCombustible;
	}
}
