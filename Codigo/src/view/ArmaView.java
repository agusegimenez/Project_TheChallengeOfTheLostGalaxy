package view;

public class ArmaView {
    private int precio;
    private int poder;
    private String nombre;

    public ArmaView(int precio, int poder, String nombre) {
        this.precio = precio;
        this.poder = poder;
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getPoder() {
        return poder;
    }

    public String getNombre() {
        return nombre;
    }
}