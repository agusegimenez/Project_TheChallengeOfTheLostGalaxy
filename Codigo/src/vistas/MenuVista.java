package vistas;

import controller.PlanetaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuVista extends JFrame {

    private JButton viajarDeSistemaButton;
    private JButton viajarAPlanetaButton;
    private JButton mostrarMapaEstelarButton;
    private JTextArea textPlaneta;
    private JTextArea textSistema;
    private JPanel rootpanel;

    public MenuVista(){

        PlanetaController controller = new PlanetaController();

        viajarAPlanetaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionPlaneta = textPlaneta.getText();

            }
        });
        mostrarMapaEstelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        viajarDeSistemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
