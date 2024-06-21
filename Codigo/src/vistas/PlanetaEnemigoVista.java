package vistas;

import controller.JugadorController;
import controller.PlanetaController;
import view.EnemigoView;
import view.JugadorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanetaEnemigoVista extends  JFrame{

    private JButton combatirButton;
    private JTextArea textDetalles;
    private JScrollPane paneDetalles;
    private JPanel rootpane;

    public PlanetaEnemigoVista(JugadorView jugadorAntesDePelear){

        super("Planeta Enemigo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,620);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(rootpane);

        PlanetaController controller = new PlanetaController();
        JugadorController controllerJugador = new JugadorController();

        combatirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JugadorView jugadorDespuesDePelear = controllerJugador.getJugadorView();
                if(jugadorDespuesDePelear.getNaveView().getVida()>0){
                    JOptionPane.showMessageDialog(rootpane, "Has ganado el combat con el enemigo!", "Victoria!", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(rootpane, "Ganaste "+ (jugadorDespuesDePelear.getUadeCoins() - jugadorAntesDePelear.getUadeCoins()),
                            "Monedas gandas", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(rootpane, "Perdiste  "+ (jugadorAntesDePelear.getNaveView().getVida() - jugadorDespuesDePelear.getNaveView().getVida()),
                            "Vida perdida", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    //Derrota
                    JOptionPane.showMessageDialog(rootpane,"Fuiste derrotado", "Derrota", JOptionPane.INFORMATION_MESSAGE);
                    // Mostrar pantalla de derrota
                }
            }
        });
        // Informacion del enemigo.
        EnemigoView enemigo = controller.getEnemigoView();
        textDetalles.append("Vida del enemigo: " + enemigo.getVida()+ "\n");
        textDetalles.append("Poder de ataque: " + enemigo.getPoderDeAtaque()+ "\n");
        textDetalles.append("Monedas al ser derrotado: " + enemigo.getUadeCoin());
    }
}
