package view;

public class EscudoView {
    private int precio;
    private int proteccion;
    private String nombre;

    public EscudoView(int precio, int proteccion, String nombre) {
        this.precio = precio;
        this.proteccion = proteccion;
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getProteccion() {
        return proteccion;
    }

    public String getNombre() {
        return nombre;
    }
    public EscudoView toView(){
        return new EscudoView(precio,proteccion,nombre);
    }
}