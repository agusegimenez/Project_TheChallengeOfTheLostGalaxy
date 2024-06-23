package vistas;

import controller.JugadorController;
import controller.MapaController;

import javax.swing.*;

public class AtravesarCinturonVista extends JFrame {
    private JPanel rootpane;
    private JTextArea textCinturon;

    public  AtravesarCinturonVista(){
        super("Atravesar Cinturon");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);

        JTextArea poderCinturon = new JTextArea();
        JugadorController controllerJugador = new JugadorController();
        MapaController controllerMapa = new MapaController();

        textCinturon.append("El poder del cinturon es: " + controllerMapa.getMapaEstelarView().);


    }

}
