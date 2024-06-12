package vistas;

import javax.swing.*;
import models.sistemaEstelar.*;

import java.awt.*;
import java.util.List;

public class PlanetasDeMapa extends JFrame {

    public PlanetasDeMapa(MapaEstelar mapaEstelar){
        super("Planetas disponibles");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        List<SistemaEstelar> sistemas = mapaEstelar.getSistemas();

        for(SistemaEstelar sistema : sistemas){
            textArea.append(sistema.getNombre() + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);


    }
}
