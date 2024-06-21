package vistas;

import controller.PlanetaController;
import view.EnemigoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanetaEnemigoVista extends  JFrame{

    private JButton combatirButton;
    private JTextArea textDetalles;
    private JScrollPane paneDetalles;
    private JPanel rootpane;

    public PlanetaEnemigoVista(EnemigoView enemigoView){
        super("Planeta Enemigo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,620);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(rootpane);

        PlanetaController controller = new PlanetaController();


        combatirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
