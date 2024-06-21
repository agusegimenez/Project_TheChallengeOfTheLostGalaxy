package main;

import controller.NaveController;
import gestor.GestorJuego;
import models.jugador.Jugador;
import models.Nave.Nave;
import models.sistemaEstelar.Planeta;
import vistas.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Creamos un gestor
        GestorJuego gestor = GestorJuego.getInstancia();

        // Creamos un models.jugador y una nave Aegis (se generan con un arma1 y escudo default)
        Jugador jugador = gestor.crearJugador("Nombre del Jugador");
        Nave naveAegis = gestor.crearNaveAegis( 100, 200, 10);
        gestor.asignarNaveAJugador("Nave-Aegis-1");

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


        // Esto es para probar las pantallas, despues debe ser eliminado
        gestor.mostrarMapaEstelar();
        SwingUtilities.invokeLater(() -> {
            MostrarMapaEstelarVista frame = new MostrarMapaEstelarVista(gestor.getMapaEstelar().toView());
        });
        SwingUtilities.invokeLater(() -> {
            JuegoTerminadoVista juego = new JuegoTerminadoVista(gestor.getJugador().toView());
        });
        SwingUtilities.invokeLater(() -> {
            NaveController controller = new NaveController();
            SeleccionarNaveVista seleccionNave = new SeleccionarNaveVista(controller.getNaveViews());
        });
        SwingUtilities.invokeLater(() -> {
            PlanetaAliadoVista planetaAliadoVista = new PlanetaAliadoVista();
        });
        SwingUtilities.invokeLater(() -> {
            EstadoDeLaNaveVista estado = new EstadoDeLaNaveVista();
        });
        SwingUtilities.invokeLater(() -> {
            PlanetaNeutralVista neutralVista = new PlanetaNeutralVista();
        });

         */
        SwingUtilities.invokeLater(() -> {
            MenuVista menuVista = new MenuVista();
        });
    }
}