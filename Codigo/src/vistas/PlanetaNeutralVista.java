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
    private JButton venderArmaButton;
    private JButton venderEscudoButton;

    public PlanetaNeutralVista(){
        super("Planeta Neutral");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,620);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(rootpane);

        PlanetaController controller = new PlanetaController();
        agregarContenidoTextField(controller.getArmaView(), controller.getEscudoView());

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
        // Llamar a vender escudo
        venderEscudoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.venderEscudo();
            }
        });

        // Implementar el vender arma recibiendo un indice de que arma vender, usar inputMessage para recibir indice
        venderArmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String indice = JOptionPane.showInputDialog("Ingrese el indice del arma que desea vender");
                    controller.venderArma(Integer.parseInt(indice));
                }catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(rootpane, "Indice incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void agregarContenidoTextField(ArmaView arma, EscudoView escudo){
        textArma.append("Poder del arma "+ arma.getPoder()+ "\n");
        textArma.append("Precio "+ arma.getPrecio()+ "\n");
        textArma.append("Nombre " + arma.getNombre()+ "\n");
        textEscudo.append("Proteccion del escudo " + escudo.getProteccion()+ "\n");
        textEscudo.append("Precio " + escudo.getPrecio()+ "\n");
        textEscudo.append("Nombre " + escudo.getNombre()+ "\n");
    }
}
