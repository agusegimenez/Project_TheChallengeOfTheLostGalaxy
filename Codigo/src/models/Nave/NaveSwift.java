package models.Nave;

public class NaveSwift extends Nave {

    public NaveSwift(String id, int combustible, int vida, int velocidad) {
        super(id, combustible, vida, velocidad);
        // Asignar el resultado de calcularDañoNave a this.poderDeAtaque
        int totalPoderArmas = 0;
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

    @Override
    public boolean esSwift() {
        return true;
    }

    @Override
    public boolean esAegis() {
        return false;
    }


}
