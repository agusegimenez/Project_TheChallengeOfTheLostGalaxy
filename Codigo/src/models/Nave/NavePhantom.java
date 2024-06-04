package models.Nave;

public class NavePhantom extends Nave{
    public NavePhantom(String id, int combustible, int vida, int velocidad) {
        super(id, combustible, vida, velocidad);
        this.poderDeAtaque = calcularDañoNave(this.arma1.getPoder());
    }

    @Override
    public int calcularDañoNave(int poderDeArma) {
        return (velocidad * poderDeArma) - combustible;
    }

    @Override
    public boolean esPhantom() {
        return true;
    }

    @Override
    public boolean esTitan() {
        return false;
    }
}
