package vistas;

import controller.PlanetaController;
import view.ArmaView;
import view.EscudoView;
import view.PlanetaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanetaNeutralVista extends JFrame {

    private JPanel rootpane;
    private JButton comprarArmaButton;
    private JButton repararButton;
    private JButton comprarEscudoButton;
    private JTextArea textArma;
    private JTextArea textEscudo;

    public PlanetaNeutralVista(PlanetaView planeta){
        super("Planeta Neutral" + planeta.getNombre());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,620);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(rootpane);
        PlanetaController controller = new PlanetaController();
        /*
        textArma.append("Poder del arma "+ arma.getPoder()+ "\n");
        textArma.append("Precio "+ arma.getPrecio()+ "\n");
        textArma.append("Nombre " + arma.getNombre()+ "\n");
        textEscudo.append("Proteccion del escudo " + escudo.getProteccion()+ "\n");
        textEscudo.append("Precio " + escudo.getPrecio()+ "\n");
        textEscudo.append("Nombre " + escudo.getNombre()+ "\n");
        */
        // Ver como pasarle al planeta el arma y escudo view.

        repararButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.repararNave();
            }
        });
        comprarEscudoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.comprarEscudo();
                    JOptionPane.showMessageDialog(rootpane, "Escudo comprado con exito", "Escudo comprado", JOptionPane.INFORMATION_MESSAGE);

                }catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(rootpane,"Monedas insuficientes", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        comprarArmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.comprarArma();
                    JOptionPane.showMessageDialog(rootpane, "Arma comprada con exito", "Arma comprada", JOptionPane.INFORMATION_MESSAGE);

                }catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(rootpane,"Monedas insuficientes", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
