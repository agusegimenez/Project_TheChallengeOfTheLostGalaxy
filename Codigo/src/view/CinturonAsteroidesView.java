package view;

public class CinturonAsteroidesView {
    private int poderDeAtaque;
    private int cantidadAsteroides;

    public CinturonAsteroidesView(int poderAtaque, int cantidadAsteroides){
        this.poderDeAtaque = poderAtaque;
        this.cantidadAsteroides = cantidadAsteroides;
    }

    public int getPoderDeAtaque(){
        return this.poderDeAtaque;
    }
    public int getCantidadAsteroides(){
        return this.cantidadAsteroides;
    }
}
