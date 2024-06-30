package controller;
import gestor.GestorJuego;
import view.JugadorView;

public class JugadorController {

    public JugadorView getJugadorView(){
        return GestorJuego.getInstancia().getJugador().toView();
    }

    public void reiniciarJuego(){
        GestorJuego.reiniciarInstancia();
    }


}
