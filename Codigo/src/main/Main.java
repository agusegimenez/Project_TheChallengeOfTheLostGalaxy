//Inicializado por Alexis

package main;

import equipamiento.*;

import gestor.GestorJuego;
import jugador.Jugador;
import Nave.Nave;
import planeta.*;

public class Main {
    public static void main(String[] args) {
        // Creamos un gestor
        GestorJuego gestor = new GestorJuego();

        // Creamos un jugador y una nave Aegis (se generan con un arma y escudo default)
        Jugador jugador = gestor.crearJugador("Nombre del Jugador");
        Nave naveAegis = gestor.crearNaveAegis("NaveAegis-001", 100, 200, 4);
        gestor.asignarNaveAJugador(naveAegis.getId());
        
        // Mostramos los atributos iniciales de la nave, arma y escudo
        System.out.println("Arma actual de la nave: " + jugador.getNave().getArma().getPoder() + " de poder");
        System.out.println("Escudo actual de la nave: " + jugador.getNave().getEscudo().getProteccion() + " de protección");
        
        Arma arma1 = gestor.agregarArma(50, 15, "arma1");
        Escudo escudo1 = gestor.agregarEscudo(25, 50, "escudo1");

        
        //Creamos un planeta y hacemos que el jugador lo visite.
        
        Planeta planetaN1 = gestor.generarPlanetaNeutral("Planeta Neutral", 10, "arma1", "escudo1");
        gestor.trasladarAPlaneta("Planeta Neutral");

        // Combate

        Planeta planetaH = gestor.generarPlanetaHostil("Planeta Hostil", 10);
        gestor.trasladarAPlaneta("Planeta Hostil");

        // Viaje a planeta neutral y compra de arma y escudo.

        gestor.trasladarAPlaneta("Planeta Neutral");
        gestor.comprarArma();
        gestor.comprarEscudo();
        jugador.imprimirEstadoActual();
    }
}