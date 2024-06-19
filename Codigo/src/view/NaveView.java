package view;

public class NaveView {
    private String nombre;
    private int combustible;
    private int vida;
    private int velocidad;
    private int poderDeAtaque;
    private int escudoActual;

    public NaveView(String nombre, int combustible, int vida, int velocidad, int poderDeAtaque, int escudoActual) {
        this.nombre = nombre;
        this.combustible = combustible;
        this.vida = vida;
        this.velocidad = velocidad;
        this.poderDeAtaque = poderDeAtaque;
        this.escudoActual = escudoActual;
    }

    public String getNombre() {
        return nombre;
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