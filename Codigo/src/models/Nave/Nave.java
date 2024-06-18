package models.Nave;
import java.util.ArrayList;
import models.equipamiento.*;
import view.NaveView;

public abstract class Nave {
    protected String id;
    protected int combustible;
    protected int vida;
    protected int velocidad;
    protected ArrayList<Arma> armas;
    protected Escudo escudo;
    protected int poderDeAtaque;
    protected final int vidaMaxima;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCombustible() {
        return combustible;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public ArrayList<Arma> getArmas() {
        return armas;
    }

    public void agregarArma(Arma arma) {
        this.armas.add(arma);
        actualizarPoderDeAtaque();
    }

    public void eliminarArma(Arma arma) {
        this.armas.remove(arma);
        actualizarPoderDeAtaque();
    }

    private void actualizarPoderDeAtaque() {
        int sumaTotal = 0;
        for (Arma arma : armas) {
            sumaTotal += calcularDañoNave(arma.getPoder());
        }
        this.poderDeAtaque = sumaTotal;
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

    public int getPoderDeAtaque() {
        return poderDeAtaque;
    }

    public void setPoderDeAtaque(int poderDeAtaque) {
        this.poderDeAtaque = poderDeAtaque;
    }

    public Nave(String id, int combustible, int vida, int velocidad) {
        this.id = id;
        this.combustible = combustible;
        this.vidaMaxima = vida;
        this.vida = vidaMaxima;
        this.velocidad = velocidad;
        this.armas = new ArrayList<>();
        this.escudo = new Escudo(20, 0, "Escudo Basico");
        this.agregarArma(new Arma(10, 0, "Arma Basica"));
    }

    public void recibirDaño(int daño) {
        int dañoFinal = daño - (escudo.getProteccion());
        if (dañoFinal <= 0) {
            dañoFinal *= -1;
            this.escudo.setProteccion(dañoFinal);
        } else {
            this.vida -= dañoFinal;
            escudo.setProteccion(0);
        }
    }

    public void recibirDañoCinturon(int daño) {
        this.vida -= daño;
    }

    public void cargarCombustible(int combustible) {
        this.combustible = this.combustible + combustible;
    }

    public void viajarAPlaneta(int combustible) {
        if (armas.size() < 2) {
            combustible = combustible * 2;
        }
        if (this.combustible >= combustible) {
            this.combustible -= combustible;
        } else {
            throw new IllegalArgumentException("No tienes suficiente combustible para viajar");
        }
    }

    public abstract int calcularDañoNave(int poderDeArma);

    public abstract boolean esPhantom();

    public abstract boolean esTitan();

    public abstract boolean esSwift();

    public abstract  boolean esAegis();

    public void reparar() {
        this.vida = this.vidaMaxima;
        this.escudo.reparar();
    }

    public NaveView toView(){
        return new NaveView(id, combustible, vida, velocidad, poderDeAtaque, getEscudo().getProteccion());
    }
}
