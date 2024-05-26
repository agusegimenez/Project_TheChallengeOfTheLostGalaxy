package models.sistemaEstelar;

import java.util.Random;

public class CinturonAsteroides {
    private int cantidadAsteroides;

    public int getCantidadAsteroides() {
        return cantidadAsteroides;
    }

    public void setCantidadAsteroides() {
        Random cantidad = new Random();
        this.cantidadAsteroides = cantidad.nextInt(50)+1;
    }

}
