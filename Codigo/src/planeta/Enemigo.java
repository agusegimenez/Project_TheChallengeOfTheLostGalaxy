package planeta;

public class Enemigo {
	private int poderDeAtaque;
	private int uadeCoin;
	private int vida;
	
	private void calcularPoderAtaque() {
		this.poderDeAtaque = 0;
	}
	
	private void atacar() {
		
	}
	
	public void recibirDaño(int daño) {
		this.vida -= daño;
	}
	
}
