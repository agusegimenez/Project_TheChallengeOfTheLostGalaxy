package vistas;

import view.JugadorView;

import javax.swing.*;
import java.awt.*;

public class JuegoTerminadoVista extends JFrame {

    public JuegoTerminadoVista(JugadorView jugador){
        super("Juego Terminado");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);

        JTextArea estadisticas = new JTextArea();

        estadisticas.append("Estadisticas:" + "\n");
        estadisticas.append("Cantidad de monedas obtenidas " + jugador.getUadeCoins() + "\n");
        estadisticas.append("Nave utilizada  " + jugador.getNombreNave()+ "\n");
        estadisticas.append("Nombre del arma " + jugador.getNombreArma() + "\n");
        estadisticas.append("Nombre del escudo " + jugador.getNombreEscudo() + "\n");
        estadisticas.append("Poder de ataque final " + jugador.getPoderDeAtaque() + "\n");
        estadisticas.append("Cantidad de enemigos derrotados " + jugador.getCantidadEnemigosDerrotados() + "\n");

        JScrollPane scrollPane = new JScrollPane(estadisticas);
        add(scrollPane, BorderLayout.CENTER);
    }

}