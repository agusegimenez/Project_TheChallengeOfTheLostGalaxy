package equipamiento;

public class Arma {
	private int poder;
	private int uadeCoin;
	private String id;
	
	public Arma(int poder, int precio, String id) {
		this.poder = poder;
		this.uadeCoin = precio;
		this.id = id;
	}
	
	public int getPoder() {
		return(this.poder);
	}
	
	public int getPrecio() {
		return(this.uadeCoin);
	}
	
	public String getId() {
		return(this.id);
	}
}
