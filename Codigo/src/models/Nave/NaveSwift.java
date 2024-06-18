package models.Nave;

public class NaveSwift extends Nave {

    public NaveSwift(int combustible, int vida, int velocidad) {
        super(combustible, vida, velocidad);
        int totalPoderArmas = 0;
        setNombreNave("Nave-Swift-"+getId().toString());
        for (int x = 0; x < armas.size(); x++) {
            totalPoderArmas += armas.get(x).getPoder();
        }

        // Calcular el poder de ataque basado en el total de poder de las armas
        int dañoCalculado = calcularDañoNave(totalPoderArmas);
        this.poderDeAtaque = dañoCalculado;
    }

    @Override
    public int calcularDañoNave(int poderDeArma) {
        return (poderDeArma * velocidad) + vidaMaxima + combustible;
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
