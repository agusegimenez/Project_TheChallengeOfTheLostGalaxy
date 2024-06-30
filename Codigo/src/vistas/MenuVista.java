package vistas;

import controller.JugadorController;
import controller.MapaController;
import controller.NaveController;
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
        NaveController naveController = new NaveController();

        viajarAPlanetaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JugadorView jugadorAntesDeViajar = jugadorController.getJugadorView();
                    String seleccionPlaneta = textPlaneta.getText();
                    PlanetaView planetaVisitado = planetaController.viajarAPlaneta(seleccionPlaneta);


                    if(naveController.getNaveJugadorView().getVida()>=0){
                        if(planetaVisitado.getNombre().contains("Neutral") ){
                            PlanetaNeutralVista planetaNeutralVista = new PlanetaNeutralVista();
                        }else if (planetaVisitado.getNombre().contains("Aliado")) {
                            PlanetaAliadoVista planetaAliadoVista = new PlanetaAliadoVista();
                        }else{
                            PlanetaEnemigoVista planetaEnemigoVista = new PlanetaEnemigoVista(jugadorAntesDeViajar, planetaVisitado);
                        }
                        }else{
                            dispose();
                        }

                    if(planetaController.tieneCinturon(seleccionPlaneta)){
                        // JOptionPane.showMessageDialog(rootpanel,"Necesitar atravesar el Cinturon de Asteroides para trasladarte a este Planeta.", JOptionPane.);
                        JOptionPane.showMessageDialog(rootpanel,
                                "Recuerda que necesitas atravesar el Cinturón de Asteroides para trasladarte a este Planeta.",
                                "Aviso",
                                JOptionPane.INFORMATION_MESSAGE);
                        new AtravesarCinturonVista(planetaController.getCinturonView(seleccionPlaneta));
                    }

                }catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(rootpanel, "El ID proporcionado es invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (RuntimeException exception){
                    JOptionPane.showMessageDialog(rootpanel, "Combustible insuficiente", "ERROR", JOptionPane.ERROR_MESSAGE);
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
