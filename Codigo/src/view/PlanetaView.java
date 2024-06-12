package view;

public class PlanetaView {
    private int combustible;
    private String nombre;

    public PlanetaView(String nombre, int combustible){
        this.nombre = nombre;
        this.combustible = combustible;
    }

    public String getNombre(){
        return this.nombre;
    }
    public int getCombustible(){
        return this.combustible;
    }

}
