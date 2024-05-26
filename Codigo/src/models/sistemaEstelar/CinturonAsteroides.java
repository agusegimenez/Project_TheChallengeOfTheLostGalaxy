package models.sistemaEstelar;

import java.util.Random;

public class CinturonAsteroides {
    private int cantidadAsteroides;
    private int poderDelCinturon;

    public int getCantidadAsteroides() {
        Random random = new Random();
        this.cantidadAsteroides = random.nextInt(50)+1;
        return cantidadAsteroides;
    }

    public int getPoderDelCinturon() {
        this.poderDelCinturon = cantidadAsteroides*10;
        return poderDelCinturon;
    }

    public CinturonAsteroides(int cantidadAsteroides, int poderDelCinturon) {
        this.cantidadAsteroides = getCantidadAsteroides();
        this.poderDelCinturon = getPoderDelCinturon();
    }


}
