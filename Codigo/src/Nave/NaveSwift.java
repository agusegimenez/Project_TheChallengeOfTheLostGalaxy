package Nave;

public class NaveSwift extends Nave {

    public NaveSwift(String id, int combustible, int vida, int velocidad) {
        super(id, combustible, vida, velocidad);
        
        // Asignar el resultado de calcularDañoNave a this.poderDeAtaque
        this.poderDeAtaque = calcularDañoNave(this.arma.getPoder(),vida,velocidad, combustible);
    }

    @Override
    public int calcularDañoNave(int poderArma, int vida, int velocidad, int combustible) {
        return (poderArma * velocidad) + vida + combustible;
    }
}
