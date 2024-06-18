package vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controller.NaveController;
import view.NaveView;

public class SeleccionarNave extends JFrame{

    private JButton botonAegis;
    private JButton botonTitan;
    private JButton botonSwift;
    private JButton botonPhantom;

    private JScrollPane panelAegis;
    private JScrollPane panelPhantom;
    private JScrollPane panelSwift;
    private JScrollPane panelTitan;

    private JTextArea textAegis;
    private JTextArea textPhantom;
    private JTextArea textSwift;
    private JTextArea textTitan;

    public SeleccionarNave(List<NaveView> naves){

        super("Seleccionar Nave");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(620,300);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();
        NaveController controller = new NaveController();
        // reemplazar este metodo
        mostrarNaves(textAegis, naves.getFirst());
        mostrarNaves(textSwift, naves.get(1));
        mostrarNaves(textPhantom, naves.get(2));
        mostrarNaves(textTitan, naves.get(3));

        botonAegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.asignarNaveAegis();
            }
        });

        botonPhantom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.asignarNavePhantom();
            }
        });
        botonSwift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.asignarNaveSwift();
            }
        });
        botonTitan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.asignarNaveTitan();

            }
        });
        panel.add(panelAegis);
        panel.add(panelPhantom);
        panel.add(panelSwift);
        panel.add(panelTitan);
        panel.add(textAegis);
        panel.add(textPhantom);
        panel.add(textTitan);
        panel.add(textSwift);
        panel.add(botonAegis);
        panel.add(botonPhantom);
        panel.add(botonTitan);
        panel.add(botonSwift);
        add(panel);
    }

    private void mostrarNaves(JTextArea area, NaveView nave){
        area.append(nave.getId() + "\n");
        area.append("Vida de la nave "+nave.getVida() + "\n");
        area.append("Combustible inicial "+nave.getCombustible() + "\n");
        area.append("Velocidad "+nave.getVelocidad() + "\n");
        area.append("Poder de ataque " + nave.getPoderDeAtaque() + "\n");
    }

}
