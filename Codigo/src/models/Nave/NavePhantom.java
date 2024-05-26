package models.Nave;

public class NavePhantom extends Nave{
    public NavePhantom(String id, int combustible, int vida, int velocidad) {
        super(id, combustible, vida, velocidad);
        this.poderDeAtaque = calcularDañoNave(this.arma.getPoder(),vida,velocidad, combustible);
    }

    @Override
    public int calcularDañoNave(int poderDeArma, int vida, int velocidad, int combustible) {
        return 0; // aca deberiamos ver como calcula el daño
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
