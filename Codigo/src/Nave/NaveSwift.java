package Nave;

public class NaveSwift extends Nave {

    public NaveSwift(String id, int combustible, int vida, int velocidad) {
        super(id, combustible, vida, velocidad);
        
        // Asignar el resultado de calcularDañoNave a this.poderDeAtaque
        this.poderDeAtaque = calcularDañoNave(this.arma.getPoder(),vida,velocidad, combustible);
    }

    private int calcularDañoNave(int poderArma, int velocidad, int vida, int combustible) {
        return (poderArma * velocidad) + vida + combustible;
    }
}
