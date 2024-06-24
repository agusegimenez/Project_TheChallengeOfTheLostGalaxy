package vistas;


import controller.NaveController;
import view.CinturonAsteroidesView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtravesarCinturonVista extends JFrame {
    private JPanel rootPane;
    private JTextArea textCinturon;
    private JButton atravesarCinturonButton;

    public AtravesarCinturonVista(CinturonAsteroidesView cinturon) {
        super("Atravesar Cinturon");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setContentPane(rootPane);
        setVisible(true);

        NaveController naveController = new NaveController();

        cargarPoderDelCinturon(cinturon);
        atravesarCinturonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(naveController.getNaveJugadorView().getVida() > 0){
                    naveController.atravesarCinturon(cinturon.getPoderDeAtaque());
                    JOptionPane.showMessageDialog(rootPane, "Se logró atravesar el cinturón con éxito.", "Viaje exitoso", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    new JuegoPerdidoVista().setVisible(true);
                }
            }
        });
    }

    private void cargarPoderDelCinturon(CinturonAsteroidesView cinturon) {
        textCinturon.append("El poder del cinturon es: " + cinturon.getPoderDeAtaque());
    }

}
