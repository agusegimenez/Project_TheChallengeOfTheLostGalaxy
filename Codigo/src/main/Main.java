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
        gestor.inicializarListas();

        // Creamos un jugador y una nave Aegis (se generan con un arma y escudo default)
        Jugador jugador = gestor.crearJugador("Nombre del Jugador");
        Nave naveAegis = gestor.crearNaveAegis("NaveAegis-001", 100, 200, 4);
        gestor.asignarNaveAJugador(naveAegis.getId());
        
        // Mostramos los atributos iniciales de la nave, arma y escudo
        System.out.println("Arma actual de la nave: " + jugador.getNave().getArma().getPoder() + " de poder");
        System.out.println("Escudo actual de la nave: " + jugador.getNave().getEscudo().getProteccion() + " de protección");
        
        Arma arma1 = gestor.agregarArma(50, 15);
        Escudo escudo1 = gestor.agregarEscudo(25, 50);
        System.out.println("Valores con nueva arma y escudo");
        naveAegis.setArma(arma1);
        naveAegis.setEscudo(escudo1);
        
        // Nuevos valores del arma y escudo
        System.out.println("Arma actual de la nave: " + jugador.getNave().getArma().getPoder() + " de poder");
        System.out.println("Escudo actual de la nave: " + jugador.getNave().getEscudo().getProteccion() + " de protección");
        
        //Creamos un planeta y hacemos que el jugador lo visite.
        
        Planeta planetaN1 = gestor.generarPlanetaNeutral("Planeta Neutral", 10, arma1, escudo1);
        jugador.visitarPlaneta(planetaN1);
        
        // Hacemos que venda las armas y los escudos para ver si equipa los default

        jugador.venderArma();
        jugador.venderEscudo();

        // Una vez que vendimos, mostramos si se equipó lo default
        System.out.println("Arma después de la venta: " + jugador.getNave().getArma().getPoder() + " de poder");
        System.out.println("Escudo después de la venta: " + jugador.getNave().getEscudo().getProteccion() + " de protección");
        System.out.println("Monedas del jugador despues de la venta (arranca con 50 por default): "+ jugador.getUadeCoins());
        jugador.imprimirEstadoActual();
        // Combate, aun con la impresion de los daño para revisar el comportamiento 
        //Planeta planetaH = gestor.generarPlanetaHostil("Planeta Neutral", 10);
        //jugador.visitarPlaneta(planetaH);
        //gestor.encuentroConEnemigo();
    }
}