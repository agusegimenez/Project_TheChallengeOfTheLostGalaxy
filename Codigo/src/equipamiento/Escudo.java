package equipamiento;

public class Escudo {
	private int proteccion;
	private int uadeCoin;
	private String id;
	
	public Escudo(int proteccion, int precio, String id) {
		this.proteccion = proteccion;
		this.uadeCoin = precio;
		this.id = id;
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
	
	public String getId() {
		return(this.id);
	}
}
