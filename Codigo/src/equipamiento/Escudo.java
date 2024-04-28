package equipamiento;

public class Escudo {
	private int proteccion;
	private int uadeCoin;
	
	public Escudo(int proteccion, int precio) {
		this.proteccion = proteccion;
		this.uadeCoin = precio;
	}
	
	public void setProteccion(int x) {
		this.proteccion = this.proteccion - x;
		if (this.proteccion < 0) {
			this.proteccion = 0;
		}
	}
	
	public int getProteccion() {
		return(this.proteccion);
	}
	
	public int getPrecio() {
		return(this.uadeCoin);
	}
	
}
