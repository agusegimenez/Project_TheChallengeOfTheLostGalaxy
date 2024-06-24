package vistas;

import controller.NaveController;
import view.ArmaView;
import view.NaveView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EstadoDeLaNaveVista extends JFrame {

    public EstadoDeLaNaveVista(){
        super("Estado de la nave");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
        NaveController controller = new NaveController();

        JTextArea estado = new JTextArea();
        NaveView nave = controller.getNaveJugadorView();
        estado.append("Nombre de la nave " + nave.getNombre() + "\n");
        estado.append("Vida actual " + nave.getVida() + "\n");
        estado.append("Escudo actual " + nave.getEscudoActual() + "\n");
        estado.append("Combustible restante " + nave.getCombustible() + "\n");
        estado.append("Velocidad " + nave.getVelocidad() + "\n");
        estado.append("Poder de ataque " + nave.getPoderDeAtaque() + "\n");
        estado.append("Armas: "+ "\n");
        for(ArmaView arma : controller.getArmasView()){
            estado.append(arma.getNombre() + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(estado);
        add(scrollPane, BorderLayout.CENTER);
    }
}
