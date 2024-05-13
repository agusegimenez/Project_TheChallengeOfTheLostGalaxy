package Nave;

import equipamiento.*;

public class NaveAegis extends Nave {
	
	
    public NaveAegis(String id, int combustible, int vida, int velocidad, Arma arma, Escudo escudo) {
        super(id, combustible, vida, velocidad);
        // Asignar el resultado de calcularDañoNave a this.poderDeAtaque
        this.setPoderDeAtaque(calcularDañoNave(arma.getPoder(),vida,velocidad));
    }

    public int calcularDañoNave(int poderArma, int vida, int velocidad) {
        return (poderArma * vida) / velocidad;
    }
}
