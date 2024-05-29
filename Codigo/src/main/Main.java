package main;

import models.equipamiento.*;

import gestor.GestorJuego;
import models.jugador.Jugador;
import models.Nave.Nave;
import models.sistemaEstelar.*;

public class Main {
    public static void main(String[] args) {
        // Creamos un gestor
        GestorJuego gestor = new GestorJuego();

        // Creamos un models.jugador y una nave Aegis (se generan con un arma1 y escudo default)
        Jugador jugador = gestor.crearJugador("Nombre del Jugador");
        Nave naveAegis = gestor.crearNaveAegis("NaveAegis-001", 100, 200, 4);
        gestor.asignarNaveAJugador(naveAegis.getId());
        
        // Mostramos los atributos iniciales de la nave, arma1 y escudo
        System.out.println("Arma actual de la nave: " + jugador.getNave().getArma1().getPoder() + " de poder");
        System.out.println("Escudo actual de la nave: " + jugador.getNave().getEscudo().getProteccion() + " de protección");
        
        Arma arma1 = gestor.agregarArma(50, 15, "arma1");
        Escudo escudo1 = gestor.agregarEscudo(25, 50, "escudo1");

        
        //Creamos un models.planeta y hacemos que el models.jugador lo visite.
        
        Planeta planetaN1 = gestor.generarPlanetaNeutral("Planeta Neutral", "arma1", "escudo1");
        gestor.trasladarAPlaneta("Planeta Neutral");

        // Combate

        Planeta planetaH = gestor.generarPlanetaHostil("Planeta Hostil");
        gestor.trasladarAPlaneta("Planeta Hostil");

        // Viaje a models.planeta neutral y compra de arma1 y escudo.

        gestor.trasladarAPlaneta("Planeta Neutral");
        gestor.comprarArma1();
        gestor.comprarEscudo();
        jugador.imprimirEstadoActual();
        gestor.comprarArma2();
        jugador.imprimirEstadoActual();
    }
}