package vistas;

import controller.JugadorController;
import view.JugadorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuegoPerdidoVista extends JFrame {

    private JPanel rootPanel;
    private JButton reiniciarPartidaButton;
    private JTextArea textJuegoPerdido;

    public JuegoPerdidoVista(){
        super("Perdiste. Juego terminado!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setContentPane(rootPanel);
        setVisible(true);
        JugadorController jugadorController = new JugadorController();

        textJuegoPerdido.append("Has perdido el juego. Toca reiniciar para comenzar otra partida.");

        reiniciarPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugadorController.reiniciarJuego();
                dispose();

                new MenuVista().setVisible(true);
            }
        });
    }
}
