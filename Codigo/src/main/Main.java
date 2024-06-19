package main;

import controller.NaveController;
import controller.PlanetaController;
import gestor.GestorJuego;
import models.jugador.Jugador;
import models.Nave.Nave;
import models.sistemaEstelar.Planeta;
import models.sistemaEstelar.PlanetaAliado;
import vistas.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Creamos un gestor
        GestorJuego gestor = GestorJuego.getInstancia();

        // Creamos un models.jugador y una nave Aegis (se generan con un arma1 y escudo default)
        Jugador jugador = gestor.crearJugador("Nombre del Jugador");
        Nave naveAegis = gestor.crearNaveAegis( 100, 200, 10);
        gestor.asignarNaveAJugador(naveAegis.getId());
        gestor.agregarPlanetasDePrueba();
        gestor.trasladarAPlaneta("Prueba Neutral");

        /*
        gestor.agregarPlanetasDePrueba();
        gestor.trasladarAPlaneta("Prueba Aliado");
        gestor.comprarInformacion();
        gestor.trasladarAPlaneta("Prueba Neutral");
        gestor.comprarArma1();
        gestor.comprarEscudo();
        jugador.imprimirEstadoActual();
        gestor.comprarArma2();
        jugador.imprimirEstadoActual();
        gestor.trasladarAPlaneta("Prueba Hostil");
        gestor.trasladarAPlaneta("Prueba Aliado");
        gestor.repararNave();
        jugador.imprimirEstadoActual();

         */

        gestor.mostrarMapaEstelar();
        SwingUtilities.invokeLater(() -> {
            MostrarMapaEstelar frame = new MostrarMapaEstelar(gestor.getMapaEstelar().toView());
        });
        SwingUtilities.invokeLater(() -> {
            JuegoTerminado juego = new JuegoTerminado(gestor.getJugador().toView());
        });
        SwingUtilities.invokeLater(() -> {
            NaveController controller = new NaveController();
            SeleccionarNaveVista seleccionNave = new SeleccionarNaveVista(controller.getNaveViews());
        });
        SwingUtilities.invokeLater(() -> {
            Planeta planeta = gestor.trasladarAPlaneta("Prueba Aliado");
            PlanetaAliadoVista planetaAliadoVista = new PlanetaAliadoVista(planeta.toView());
        });
        SwingUtilities.invokeLater(() -> {
            NaveController controller = new NaveController();
            EstadoDeLaNave estado = new EstadoDeLaNave(controller.getNaveJugadorView());
        });
        SwingUtilities.invokeLater(() -> {
            Planeta planeta = gestor.trasladarAPlaneta("Prueba Neutral");
            PlanetaNeutralVista neutralVista = new PlanetaNeutralVista(planeta.toView());
        });
    }
}