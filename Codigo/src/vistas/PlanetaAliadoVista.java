package vistas;

import controller.PlanetaController;
import view.PlanetaView;
import view.SistemaEstelarView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanetaAliadoVista extends JFrame{
    private JPanel panel1;
    private JButton cargarCombustibleButton;
    private JButton comprarInformacionButton;
    private JButton repararNaveButton;
    private JTextArea textIngresoCombustible;
    private JTextArea textRepararNave;
    private JTextArea textPrecioInformacion;

    public PlanetaAliadoVista() {
        super("Planeta aliado");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650,650);
        setLocationRelativeTo(null);
        setVisible(true);
        PlanetaController controller = new PlanetaController();
        setContentPane(panel1);
        textPrecioInformacion.append("El precio de la informacion es " + controller.getPrecioInformacion());


        cargarCombustibleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int cantidad = Integer.parseInt(textIngresoCombustible.getText());
                    controller.cargarCombustible(cantidad);
                    JOptionPane.showMessageDialog(panel1, "Se cargaron " + cantidad + " unidades de combustible", "Carga exitosa", JOptionPane.INFORMATION_MESSAGE);
                }catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(panel1, "No se pudo cargar combustible", "Carga fallada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        repararNaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.repararNave();
            }
        });

        comprarInformacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    SistemaEstelarView sistemaEstelarView = controller.comprarInformacion();
                    JOptionPane.showMessageDialog(panel1,"El tesoro se encuentra en el sistema "+sistemaEstelarView.getNombre(), "Informacion comprada", JOptionPane.INFORMATION_MESSAGE);

                }catch (IllegalArgumentException exception){
                    JOptionPane.showMessageDialog(panel1,"Monedas insuficientes", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

    }
}
