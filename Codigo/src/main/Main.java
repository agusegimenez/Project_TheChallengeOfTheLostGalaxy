//Inicializado por Alexis

package main;

import equipamiento.Arma;
import equipamiento.Escudo;
import gestor.GestorJuego;
import jugador.Jugador;
import Nave.Nave;

public class Main {
    public static void main(String[] args) {
        // Creamos un gestor
        GestorJuego gestor = new GestorJuego();
        gestor.inicializarListas();

        // Creamos un jugador y una nave Aegis
        Jugador jugador = gestor.crearJugador("Nombre del Jugador");
        Nave naveAegis = gestor.crearNaveAegis("NaveAegis-001", 100, 200, 50, new Arma(75, 150), new Escudo(150, 300));
        gestor.asignarNaveAJugador(naveAegis.getId());
        
        // Mostramos los atributos iniciales de la nave, arma y escudo
        System.out.println("Arma actual de la nave: " + jugador.getNave().getArma().getPoder() + " de poder");
        System.out.println("Escudo actual de la nave: " + jugador.getNave().getEscudo().getProteccion() + " de protección");

        // Hacemos que venda las armas y los escudos para ver si equipa los default
        jugador.venderArma();
        jugador.venderEscudo();

        // Una vez que vendimos, mostramos si se equipó lo default
        System.out.println("Arma después de la venta: " + jugador.getNave().getArma().getPoder() + " de poder");
        System.out.println("Escudo después de la venta: " + jugador.getNave().getEscudo().getProteccion() + " de protección");
    }
}