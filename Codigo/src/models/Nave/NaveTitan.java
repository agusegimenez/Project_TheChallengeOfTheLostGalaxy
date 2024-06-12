package models.Nave;

public class NaveTitan extends Nave{
    public NaveTitan(String id, int combustible, int vida, int velocidad) {
        super(id, combustible, vida, velocidad);
        this.poderDeAtaque = calcularDañoNave(this.arma1.getPoder());
    }

    @Override
    public int calcularDañoNave(int poderDeArma) {
        return (vidaMaxima * poderDeArma) - velocidad;
    }


    @Override
    public boolean esPhantom() {
        return false;
    }

    @Override
    public boolean esTitan() {
        return true;
    }

}
