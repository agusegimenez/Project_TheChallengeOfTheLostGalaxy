package view;

public class JugadorView {
    private int uadeCoins;
    private String nombreNave;
    private String nombreArma;
    private String nombreEscudo;
    private int poderDeAtaque;
    private int cantidadEnemigosDerrotados;

    public JugadorView(int uadeCoins, String nombreNave, String nombreArma, String nombreEscudo, int poderDeAtaque, int cantidadEnemigosDerrotados) {
        this.uadeCoins = uadeCoins;
        this.nombreNave = nombreNave;
        this.nombreArma = nombreArma;
        this.nombreEscudo = nombreEscudo;
        this.poderDeAtaque = poderDeAtaque;
        this.cantidadEnemigosDerrotados = cantidadEnemigosDerrotados;
    }

    public int getUadeCoins() {
        return uadeCoins;
    }

    public String getNombreNave() {
        return nombreNave;
    }

    public String getNombreArma() {
        return nombreArma;
    }

    public String getNombreEscudo() {
        return nombreEscudo;
    }

    public int getPoderDeAtaque() {
        return poderDeAtaque;
    }
    public int getCantidadEnemigosDerrotados(){
        return cantidadEnemigosDerrotados;
    }
}
