package vistas;

import controller.MapaController;
import controller.PlanetaController;
import view.MapaEstelarView;

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

        super("Menu de seleccion");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,620);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(rootpanel);
        PlanetaController planetaController = new PlanetaController();

        viajarAPlanetaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String seleccionPlaneta = textPlaneta.getText();
                    planetaController.viajarAPlaneta(seleccionPlaneta);
                    JOptionPane.showMessageDialog(rootpanel, "Viajaste con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(rootpanel, "El ID proporcionado es invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(rootpanel, "No tienes combustible suficiente", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mostrarMapaEstelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapaController mapaController = new MapaController();
                MostrarMapaEstelarVista mostrarMapaEstelarVista = new MostrarMapaEstelarVista(mapaController.getMapaEstelarView());
            }
        });

        viajarDeSistemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
