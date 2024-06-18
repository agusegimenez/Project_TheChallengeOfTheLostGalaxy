package vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionarNave extends JFrame{
    private JButton botonAegis;
    private JButton botonTitan;
    private JButton botonSwift;
    private JButton botonPhantom;
    private JScrollPane panelAegis;
    private JScrollPane panelPhantom;
    private JScrollPane panelSwift;
    private JScrollPane panelTitan;

    public SeleccionarNave(){
        super("Seleccionar Nave");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setVisible(true);

        botonAegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        botonPhantom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botonSwift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botonTitan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
