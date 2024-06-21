package vistas;

import controller.NaveController;
import view.NaveView;

import javax.swing.*;
import java.awt.*;

public class EstadoDeLaNaveVista extends JFrame {

    public EstadoDeLaNaveVista(){
        super("Estado de la nave");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);

        JTextArea estado = new JTextArea();
        NaveController controller = new NaveController();
        NaveView nave = controller.getNaveJugadorView();
        estado.append("Nombre de la nave " + nave.getNombre() + "\n");
        estado.append("Vida actual " + nave.getVida() + "\n");
        estado.append("Escudo actual " + nave.getEscudoActual() + "\n");
        estado.append("Combustible restante " + nave.getCombustible() + "\n");
        estado.append("Velocidad " + nave.getVelocidad() + "\n");
        estado.append("Poder de ataque " + nave.getPoderDeAtaque() + "\n");

        JScrollPane scrollPane = new JScrollPane(estado);
        add(scrollPane, BorderLayout.CENTER);
    }
}
