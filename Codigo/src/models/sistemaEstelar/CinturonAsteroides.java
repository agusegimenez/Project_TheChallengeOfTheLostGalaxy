package models.sistemaEstelar;

import view.CinturonAsteroidesView;

import java.util.Random;

public class CinturonAsteroides {
    private int cantidadAsteroides;

    private int getCantidadAsteroides() {
        Random random = new Random();
        this.cantidadAsteroides = random.nextInt(12)+1;
        return cantidadAsteroides;
    }

    public int getPoderDelCinturon() {
        return cantidadAsteroides*10;
    }

    public CinturonAsteroides() {
        this.cantidadAsteroides = getCantidadAsteroides();
    }

    public CinturonAsteroidesView toView(){
        return new CinturonAsteroidesView(getPoderDelCinturon(), cantidadAsteroides);
    }

    public int getAsteroides(){
        return this.cantidadAsteroides;
    }


}
