package Nave;

public class NaveSwift extends Nave {

    public NaveSwift( int combustible, int vida, int velocidad, Arma arma, Escudo escudo) {
        super("Nave Swift", combustible, vida, velocidad, arma, escudo);
        // Asignar el resultado de calcularDañoNave a this.poderDeAtaque
        this.setPoderDeAtaque(calcularDañoNave(int arma.getPoder(), int velocidad,int vida,int combustible)) ;
    }

    public int calcularDañoNave(int poderArma, int velocidad, int vida, int combustible) {
        return (poderArma * velocidad) + vida + combustible;
    }
}
