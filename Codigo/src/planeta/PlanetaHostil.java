package planeta;

public class PlanetaHostil extends Planeta{
	private Enemigo enemigo;
	private boolean tieneTesoro;

	public PlanetaHostil(String id, int costo, Enemigo enemigo, boolean tieneTesoro) {
		super(id, costo);
		this.enemigo = enemigo;
		this.tieneTesoro = tieneTesoro;
	}

	public Enemigo getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}

	public boolean isTieneTesoro() {
		return tieneTesoro;
	}

	public void setTieneTesoro(boolean tieneTesoro) {
		this.tieneTesoro = tieneTesoro;
	}
}
