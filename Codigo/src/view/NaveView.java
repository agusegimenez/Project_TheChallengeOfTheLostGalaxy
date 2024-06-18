package view;

public class NaveView {
    private Long id;
    private int combustible;
    private int vida;
    private int velocidad;
    private int poderDeAtaque;
    private int escudoActual;

    public NaveView(Long id, int combustible, int vida, int velocidad, int poderDeAtaque, int escudoActual) {
        this.id = id;
        this.combustible = combustible;
        this.vida = vida;
        this.velocidad = velocidad;
        this.poderDeAtaque = poderDeAtaque;
        this.escudoActual = escudoActual;
    }

    public Long getId() {
        return id;
    }

    public int getCombustible() {
        return combustible;
    }

    public int getVida() {
        return vida;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getPoderDeAtaque() {
        return poderDeAtaque;
    }
    public int getEscudoActual(){
        return this.escudoActual;
    }
}