package view;

public class EnemigoView {
    private int poderDeAtaque;
    private int uadeCoin;
    private int vida;
    private int vidaMaxima;

    public EnemigoView(int poderDeAtaque, int uadeCoin, int vida){
        this.poderDeAtaque = poderDeAtaque;
        this.uadeCoin = uadeCoin;
        this.vida = vida;
        this.vidaMaxima = vida;
    }

    public int getPoderDeAtaque() {
        return poderDeAtaque;
    }

    public int getUadeCoin() {
        return uadeCoin;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima(){
        return vidaMaxima;
    }
}

