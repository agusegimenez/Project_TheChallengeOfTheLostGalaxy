package equipamiento;

public class Escudo {
	private int proteccion;
	private int uadeCoin;
	
	public Escudo(int proteccion, int precio) {
		this.proteccion = proteccion;
		this.uadeCoin = precio;
	}
	
	public void setProteccion(int x) {
		this.proteccion = x;
	}
	
	public int getProteccion() {
		return(this.proteccion);
	}
	
	public int getPrecio() {
		return(this.uadeCoin);
	}
	
}
