package Nave;

public class NaveAegis extends Nave {

    public NaveAegis(String id, int combustible, int vida, int velocidad, Arma arma, Escudo escudo, int poderDeAtaque) {
        super("Nave Aegis", combustible, vida, velocidad, arma, escudo, poderDeAtaque);
        // Asignar el resultado de calcularDañoNave a this.poderDeAtaque
        this.setPoderDeAtaque(calcularDañoNave(int arma.getPoder(), int vida, int velocidad));
    }

    public int calcularDañoNave(int poderArma, int vida, int velocidad) {
        return (poderArma * vida) / velocidad;
    }
}
