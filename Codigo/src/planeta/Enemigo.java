package planeta;

public class Enemigo {
	private int poderDeAtaque;
	private int uadeCoin;
	private int vida = 100;
	
	public Enemigo(int poderAtaque) {
		this.poderDeAtaque = poderAtaque;
	}
	
	public int getPoderAtaque() {
		return(this.poderDeAtaque);
	}
	
	public int getVida() {
		return(this.vida);
	}
	
	private void atacar() {
	}
	
	public void recibirDaño(int daño) {
		this.vida -= daño;
	}
	
	public int calcularCantidadDeUadeCoins() {
		return(this.poderDeAtaque*2);
	}
	
}
