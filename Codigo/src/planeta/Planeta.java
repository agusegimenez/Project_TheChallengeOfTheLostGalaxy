package planeta;

public class Planeta {
	private String idPlaneta;
	private boolean estaExplorado = false;
	private int costoDeCombustible;
	
	public Planeta(String id, int costo) {
		this.idPlaneta = id;
		this.costoDeCombustible = costo;
	}
	
}
