package gestor;

import models.jugador.*;
import models.Nave.*;
import models.sistemaEstelar.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class GestorJuego {
	private static GestorJuego instancia;
	private final MapaEstelar mapaEstelar;
	private final List<Nave> naves;
	private Jugador jugador;
	// private List<Arma> armas;
	// private List<Escudo> escudos;

	private GestorJuego() {
		this.mapaEstelar = new MapaEstelar(generarNumeroDeSistemas()); // Inicializa la lista de todo
		this.naves = new ArrayList<>();
		instanciarNaves();
		crearJugador("");
		//this.armas = new ArrayList<>();
		//this.escudos = new ArrayList<>();
	}

	private int generarNumeroDeSistemas(){
		Random random = new Random();
		return random.nextInt(10)+2;
	}

	public static synchronized GestorJuego getInstancia() {
		if (instancia == null) {
			instancia = new GestorJuego();
		}
		return instancia;
	}

	public static void reiniciarInstancia(){
		instancia = null;
		getInstancia();
 	}

	public Jugador crearJugador(String id) {
		Jugador jugador = new Jugador(id);
		this.jugador = jugador;
		return jugador;
	}
	public String verArmas() {
		String armasInfo = this.jugador.verArmas();
		return armasInfo;
	}
	public void instanciarNaves(){
		crearNaveAegis( 100, 150, 10);
		crearNavePhantom( 100, 150, 15);
		crearNaveTitan( 150, 200, 10);
		crearNaveSwift( 75, 100, 15);
	}


	public Nave crearNaveAegis(int combustible, int vida, int velocidad) {
		NaveAegis naveAegis = new NaveAegis(combustible, vida, velocidad);
		naves.add(naveAegis);
		return(naveAegis);
	}

	public Nave crearNaveSwift(int combustible, int vida, int velocidad) {
		NaveSwift naveSwift = new NaveSwift(combustible, vida, velocidad);
		naves.add(naveSwift);
		return(naveSwift);
	}

	public Nave crearNavePhantom(int combustible, int vida, int velocidad){
		NavePhantom navePhantom = new NavePhantom(combustible, vida, velocidad);
		naves.add(navePhantom);
		return(navePhantom);
	}

	public Nave crearNaveTitan(int combustible, int vida, int velocidad){
		NaveTitan naveTitan = new NaveTitan(combustible,vida,velocidad);
		naves.add(naveTitan);
		return(naveTitan);
	}

	public void asignarNaveAJugador(String idNave) {
		Nave nave = buscarNave(idNave);
		jugador.setNave(nave);
	}

	private Nave buscarNave(String idNave) {
		for (Nave nave : naves) {
			if(nave.getNombreNave().equals(idNave)) {
				return(nave);
			}
		}
		throw new IllegalArgumentException();
	}

	public Planeta trasladarAPlaneta(String idPlaneta){
		Planeta planeta = mapaEstelar.buscarPlaneta(idPlaneta);
		SistemaEstelar sistemaEstelar = mapaEstelar.buscarSistemaEnPlaneta(idPlaneta);
		return jugador.visitarPlaneta(planeta, sistemaEstelar);
	}

	/*
       public Arma agregarArma(int poder, int precio, String id) {
           Arma arma = new Arma(poder, precio, id);
           armas.add(arma);
           return arma;
       }

       public Escudo agregarEscudo(int defensa, int precio, String id) {
           Escudo escudo = new Escudo(defensa, precio, id);
           escudos.add(escudo);
           return escudo;
       }
       */
	public void comprarArma() {
		this.jugador.comprarArma();
	}
	public void comprarEscudo() {
		this.jugador.comprarEscudo();
	}
	public void venderArma(int indiceArma) {
		this.jugador.venderArma(indiceArma);
	}
	public void venderEscudo(){
		this.jugador.venderEscudo();
	}

	public void mostrarMapaEstelar(){
		mapaEstelar.mostrarSistemas();
	}

	public SistemaEstelar comprarInformacion(){
		return(jugador.comprarInformacion(mapaEstelar));
	}

	public void repararNave(){
		jugador.repararNave();
	}

	public MapaEstelar getMapaEstelar(){
		return this.mapaEstelar;
	}
	public Jugador getJugador(){
		return this.jugador;
	}
	public List<Nave> getNaves(){
		return naves;
	}
	public void cargarCombustible(int cantidad){
		jugador.recargarCombustible(cantidad);
	}
}