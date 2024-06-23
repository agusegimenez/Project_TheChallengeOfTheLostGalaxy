package vistas;

import controller.JugadorController;
import controller.MapaController;
import controller.NaveController;
import view.CinturonAsteroidesView;
import view.JugadorView;
import view.MapaEstelarView;
import view.SistemaEstelarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AtravesarCinturonVista extends JFrame {
    private JPanel rootPane;
    private JTextArea textCinturon;
    private JButton atravesarCinturonButton;

    public AtravesarCinturonVista() {
        super("Atravesar Cinturon");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        rootPane.add(textCinturon);

        add(rootPane);
        setVisible(true);

        NaveController naveController = new NaveController();

        cargarPoderDelCinturon();
        atravesarCinturonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    naveController.atravesarCinturon();
                    JOptionPane.showMessageDialog(rootPane, "Se logró atravesar el cinturón con éxito.", "Viaje exitoso", JOptionPane.INFORMATION_MESSAGE);
                }catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(rootPane, "No se pudo atravesar el Cinturón.", "Viaje fallido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void cargarPoderDelCinturon() {
        JugadorController jugadorController = new JugadorController();
        JugadorView jugadorView = jugadorController.getJugadorView();

        // Suponiendo que estamos obteniendo el primer sistema estelar para la demostración.
        SistemaEstelarView sistemaActual = jugadorView.getSistemaActual();
        if (sistemaActual.getCinturonAsteroides()!=null) {
                textCinturon.append("El poder del cinturon es: " + sistemaActual.getCinturonAsteroides().getPoderDeAtaque());
            } else {
                textCinturon.append("No hay un cinturon de asteroides en este sistema estelar.");
            }
    }

}
