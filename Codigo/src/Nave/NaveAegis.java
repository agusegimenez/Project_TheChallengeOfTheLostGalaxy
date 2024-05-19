package Nave;

public class NaveAegis extends Nave {


    public NaveAegis(String id, int combustible, int vida, int velocidad) {
        super(id, combustible, vida, velocidad);
        // Asignar el resultado de calcularDañoNave a this.poderDeAtaque
        int dañoCalculado = calcularDañoNave(arma.getPoder(), vida, velocidad, combustible);
        this.poderDeAtaque = dañoCalculado;
    }

    private int calcularDañoNave(int poderArma, int vida, int velocidad, int combustible) {
        return (poderArma * vida) / velocidad;
    }

}
