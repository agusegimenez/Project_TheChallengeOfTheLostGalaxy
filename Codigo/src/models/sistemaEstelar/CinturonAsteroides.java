package models.sistemaEstelar;

import java.util.Random;

public class CinturonAsteroides {
    private int cantidadAsteroides;
    private int poderDelCinturon;
    private int combustible = 30;

    private int getCantidadAsteroides() {
        Random random = new Random();
        this.cantidadAsteroides = random.nextInt(20)+1;
        return cantidadAsteroides;
    }

    public int getPoderDelCinturon() {
        this.poderDelCinturon = cantidadAsteroides*10;
        return poderDelCinturon;
    }

    public CinturonAsteroides() {
        this.cantidadAsteroides = getCantidadAsteroides();
        this.poderDelCinturon = getPoderDelCinturon();
    }

    public int getCombustible(){
        return this.combustible;
    }

}
