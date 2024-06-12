package models.sistemaEstelar;

import java.util.Random;

public class CinturonAsteroides {
    private int cantidadAsteroides;

    private int getCantidadAsteroides() {
        Random random = new Random();
        this.cantidadAsteroides = random.nextInt(20)+1;
        return cantidadAsteroides;
    }

    public int getPoderDelCinturon() {
        return cantidadAsteroides*10;
    }

    public CinturonAsteroides() {
        this.cantidadAsteroides = getCantidadAsteroides();
    }


}
