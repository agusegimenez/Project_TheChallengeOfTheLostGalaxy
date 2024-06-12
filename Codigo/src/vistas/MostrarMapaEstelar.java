package vistas;

import javax.swing.*;

import view.MapaEstelarView;
import view.PlanetaView;
import view.SistemaEstelarView;

import java.awt.*;
import java.util.List;
// Mostrar el mapa estelar

public class MostrarMapaEstelar extends JFrame {

    public MostrarMapaEstelar(MapaEstelarView mapaEstelar){
        super("Planetas disponibles");
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        List<SistemaEstelarView> sistemas = mapaEstelar.getSistemas();

        // Mostrar los planetas
        for(SistemaEstelarView sistema : sistemas){
            textArea.append(sistema.getNombre());
            textArea.append("\n");
            for(PlanetaView planeta : sistema.getPlanetas()){
                textArea.append(planeta.getNombre());
            }
            if(sistema.getCinturonAsteroides() != null){
                textArea.append("\n");
                textArea.append("Tiene cinturon con poder de ataque " + sistema.getCinturonAsteroides().getPoderDeAtaque() );
            }
            textArea.append("\n");
        }
        // Leyenda de combustible
        textArea.append("\n");
        textArea.append("Viajar a un planeta hostil consume 20 de combustible" + "\n");
        textArea.append("Viajar a un planeta aliado consume 15 de combustible" + "\n");
        textArea.append("Viajar a un planeta neutral consume 10 de combustible" + "\n");
        textArea.append("Atravesar un cinturon consume 20 de combustible");

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

    }

}
