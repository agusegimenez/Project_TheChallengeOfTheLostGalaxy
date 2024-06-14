package models.Nave;

public class NaveTitan extends Nave{
    public NaveTitan(String id, int combustible, int vida, int velocidad) {
        super(id, combustible, vida, velocidad);
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
