package equipamiento;

public class Arma {
	private int poder;
	private int uadeCoin;
	
	public Arma(int poder, int precio) {
		this.poder = poder;
		this.uadeCoin = precio;
	}
	
	public int getPoder() {
		return(this.poder);
	}
	
	public int getPrecio() {
		return(this.uadeCoin);
	}
}
