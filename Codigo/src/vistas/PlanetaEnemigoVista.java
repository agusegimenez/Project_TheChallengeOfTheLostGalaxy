package vistas;

import controller.JugadorController;
import controller.PlanetaController;
import view.EnemigoView;
import view.JugadorView;
import view.PlanetaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanetaEnemigoVista extends  JFrame{

    private JButton combatirButton;
    private JTextArea textDetalles;
    private JScrollPane paneDetalles;
    private JPanel rootpane;

    public PlanetaEnemigoVista(JugadorView jugadorAntesDePelear, PlanetaView planetaActual){

        super("Planeta Enemigo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
                    JOptionPane.showMessageDialog(rootpane, "Ganaste "+ (jugadorDespuesDePelear.getUadeCoins() - jugadorAntesDePelear.getUadeCoins())+ " monedas!",
                            "Monedas gandas", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(rootpane, "Perdiste  "+ (jugadorAntesDePelear.getNaveView().getVida() - jugadorDespuesDePelear.getNaveView().getVida())
                            +" puntos de vida", "Vida perdida", JOptionPane.INFORMATION_MESSAGE);
                    if(controller.tieneTesoro(planetaActual.getNombre())){
                        JuegoTerminadoVista juegoTerminado = new JuegoTerminadoVista(jugadorDespuesDePelear);
                    }

                }else{
                    //Derrota
                    JOptionPane.showMessageDialog(rootpane,"Fuiste derrotado", "Derrota", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });
        // Informacion del enemigo.
        agregarTextField(controller.getEnemigoView());
    }

    private void agregarTextField(EnemigoView enemigo){
        textDetalles.append("Vida del enemigo: " + enemigo.getVidaMaxima()+ "\n");
        textDetalles.append("Poder de ataque: " + enemigo.getPoderDeAtaque()+ "\n");
        textDetalles.append("Monedas al ser derrotado: " + enemigo.getUadeCoin()+" - la vida perdida en el combate");
    }
}
