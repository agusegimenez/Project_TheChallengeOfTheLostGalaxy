package models.Nave;

public class NaveSwift extends Nave {

    public NaveSwift(String id, int combustible, int vida, int velocidad) {
        super(id, combustible, vida, velocidad);
        // Asignar el resultado de calcularDañoNave a this.poderDeAtaque
        this.poderDeAtaque = calcularDañoNave(this.arma1.getPoder());
    }

    @Override
    public int calcularDañoNave(int poderDeArma) {
        return (poderDeArma * velocidad) + vida + combustible;
    }

    @Override
    public boolean esPhantom() {
        return false;
    }

    @Override
    public boolean esTitan() {
        return false;
    }


}
