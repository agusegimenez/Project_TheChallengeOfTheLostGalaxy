package vistas;

import controller.JugadorController;
import controller.MapaController;
import controller.PlanetaController;
import view.JugadorView;
import view.PlanetaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuVista extends JFrame {

    private JButton viajarDeSistemaButton;
    private JButton viajarAPlanetaButton;
    private JButton mostrarMapaEstelarButton;
    private JTextArea textPlaneta;
    private JPanel rootpanel;
    private JButton mostrarEstadoButton;

    public MenuVista(){

        super("Menu de seleccion");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,620);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(rootpanel);
        PlanetaController planetaController = new PlanetaController();
        JugadorController jugadorController = new JugadorController();

        viajarAPlanetaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JugadorView jugadorAntesDeViajar = jugadorController.getJugadorView();
                    String seleccionPlaneta = textPlaneta.getText();
                    PlanetaView planetaVisitado = planetaController.viajarAPlaneta(seleccionPlaneta);
                    JOptionPane.showMessageDialog(rootpanel, "Viajaste con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);

                    if(planetaVisitado.getNombre().contains("Neutral") ){
                        PlanetaNeutralVista planetaNeutralVista = new PlanetaNeutralVista();
                    } else if (planetaVisitado.getNombre().contains("Aliado")) {
                        PlanetaAliadoVista planetaAliadoVista = new PlanetaAliadoVista();
                    }else{
                        PlanetaEnemigoVista planetaEnemigoVista = new PlanetaEnemigoVista(jugadorAntesDeViajar, planetaVisitado);
                    }

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
        mostrarEstadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EstadoDeLaNaveVista estado = new EstadoDeLaNaveVista();
            }
        });
    }
}
