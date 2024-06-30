package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controller.NaveController;
import view.NaveView;

public class SeleccionarNaveVista extends JFrame{

    private JButton botonAegis;
    private JButton botonTitan;
    private JButton botonSwift;
    private JButton botonPhantom;

    private JScrollPane panelAegis;
    private JScrollPane panelPhantom;
    private JScrollPane panelSwift;
    private JScrollPane panelTitan;

    private JTextArea textAegis;
    private JTextArea textPhantom;
    private JTextArea textSwift;
    private JTextArea textTitan;
    private JPanel rootpane;

    public SeleccionarNaveVista(){

        super("Seleccionar Nave");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(620,300);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(rootpane);

        NaveController controller = new NaveController();
        agregarContenidoTextField(controller.getNaveViews());

        botonAegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.asignarNaveAegis();
                MenuVista menuVista = new MenuVista();
                dispose();
            }
        });

        botonPhantom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.asignarNavePhantom();
                MenuVista menuVista = new MenuVista();
                dispose();
            }
        });
        botonSwift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.asignarNaveSwift();
                MenuVista menuVista = new MenuVista();
                dispose();
            }
        });
        botonTitan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.asignarNaveTitan();
                MenuVista menuVista = new MenuVista();
                dispose();
            }
        });
    }

    private void mostrarNaves(JTextArea area, NaveView nave){
        area.append(nave.getNombre() + "\n");
        area.append("Vida de la nave "+nave.getVida() + "\n");
        area.append("Combustible inicial "+nave.getCombustible() + "\n");
        area.append("Velocidad "+nave.getVelocidad() + "\n");
        area.append("Poder de ataque " + nave.getPoderDeAtaque() + "\n");
    }

    private void agregarContenidoTextField(List<NaveView> naves){
        for(NaveView nave : naves){
            if(nave.getNombre().contains("Nave-Aegis-")){
                mostrarNaves(textAegis, nave);
            }else if (nave.getNombre().contains("Nave-Phantom-")){
                mostrarNaves(textPhantom, nave);
            }else if(nave.getNombre().contains("Nave-Swift-")){
                mostrarNaves(textSwift, nave);
            }else{
                mostrarNaves(textTitan, nave);
            }
        }
    }

}
