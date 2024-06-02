package main;

import models.equipamiento.*;

import gestor.GestorJuego;
import models.jugador.Jugador;
import models.Nave.Nave;
import models.sistemaEstelar.*;

public class Main {
    public static void main(String[] args) {
        // Creamos un gestor
        GestorJuego gestor = GestorJuego.getInstancia();

        // Creamos un models.jugador y una nave Aegis (se generan con un arma1 y escudo default)
        Jugador jugador = gestor.crearJugador("Nombre del Jugador");
        Nave naveAegis = gestor.crearNaveAegis("NaveAegis-001", 100, 200, 4);
        gestor.asignarNaveAJugador(naveAegis.getId());
        
        // Mostramos los atributos iniciales de la nave, arma1 y escudo
        System.out.println("Arma actual de la nave: " + jugador.getNave().getArma1().getPoder() + " de poder");
        System.out.println("Escudo actual de la nave: " + jugador.getNave().getEscudo().getProteccion() + " de protección");
        
        Arma arma1 = gestor.agregarArma(50, 15, "arma1");
        Escudo escudo1 = gestor.agregarEscudo(25, 50, "escudo1");

        /**
        // Viaje a models.planeta neutral y compra de arma1 y escudo.
        gestor.comprarArma1();
        gestor.comprarEscudo();
        jugador.imprimirEstadoActual();
        gestor.comprarArma2();
        jugador.imprimirEstadoActual();
                                        **/
        gestor.mostrarMapaEstelar();

    }
}