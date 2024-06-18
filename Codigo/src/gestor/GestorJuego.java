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

	public Jugador crearJugador(String id) {
		Jugador jugador = new Jugador(id);
		this.jugador = jugador;
		return(jugador);
	}

	/* comenté estos metodos ya que ahora trabajamos con el mapa estelar y es él el que genera los planetas
	public Planeta generarPlanetaNeutral(String id, String idArma, String idEscudo) {
		Escudo escudo = buscarEscudo(idEscudo);
		Arma arma = buscarArma(idArma);
		PlanetaNeutral planeta = new PlanetaNeutral(id, arma, escudo);
		planetas.add(planeta);
		return(planeta);
	}

	public Planeta generarPlanetaHostil(String id) {
		PlanetaHostil planeta = new PlanetaHostil(id);
		planetas.add(planeta);
		return(planeta);
	}

	public Planeta generarPlanetaAliado(String id){
		PlanetaAliado planeta = new PlanetaAliado(id);
		planetas.add(planeta);
		return(planeta);
	}
	 */
	public void instanciarNaves(){
		crearNaveAegis("Nave Aegis", 100, 150, 10);
		crearNaveSwift("Nave Swift", 100, 100, 15);
		crearNavePhantom("Nave Phantom", 100, 150, 15);
		crearNaveTitan("Nave Titan", 150, 200, 10);
	}


	public Nave crearNaveAegis(String id, int combustible, int vida, int velocidad) {
		NaveAegis naveAegis = new NaveAegis(id, combustible, vida, velocidad);
		naves.add(naveAegis);
		return(naveAegis);
	}

	public Nave crearNaveSwift(String id, int combustible, int vida, int velocidad) {
		NaveSwift naveSwift = new NaveSwift(id, combustible, vida, velocidad);
		naves.add(naveSwift);
		return(naveSwift);
	}

	public Nave crearNavePhantom(String id, int combustible, int vida, int velocidad){
		NavePhantom navePhantom = new NavePhantom(id, combustible, vida, velocidad);
		naves.add(navePhantom);
		return(navePhantom);
	}

	public Nave crearNaveTitan(String id, int combustible, int vida, int velocidad){
		NaveTitan naveTitan = new NaveTitan(id, combustible,vida,velocidad);
		naves.add(naveTitan);
		return(naveTitan);
	}

	public void asignarNaveAJugador(String idNave) {
		Nave nave = buscarNave(idNave);
		jugador.setNave(nave);
	}

	private Nave buscarNave(String idNave) {
		for (Nave nave : naves) {
			if(nave.getId()==idNave) {
				return(nave);
			}
		}
		throw new IllegalArgumentException("No se encontró una nave con el ID especificado: " + idNave);
	}

	public void trasladarAPlaneta(String idPlaneta) {
		Planeta planeta = mapaEstelar.buscarPlaneta(idPlaneta);
		SistemaEstelar sistemaEstelar = mapaEstelar.buscarSistemaEnPlaneta(idPlaneta);
		jugador.visitarPlaneta(planeta, sistemaEstelar);
	}

	public void trasladarDeSistema(String idSistema) {
		SistemaEstelar sistemaEstelar = mapaEstelar.buscarSistema(idSistema);
		jugador.moverDeSistema(sistemaEstelar);
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
	public void venderArma() {
			System.out.println("Seleccione el índice del arma que desea vender:");
			Scanner scanner = new Scanner(System.in);
			int indiceArma = scanner.nextInt();
			// Llama al método venderArma de la clase Jugador pasando el índice
			this.jugador.venderArma(indiceArma);
	}
	public void venderEscudo(){
		this.jugador.venderEscudo();
	}

	/*
	private Arma buscarArma(String idArma) {
		for (Arma arma : armas) {
			if(arma.getId().equals(idArma)) {
				return(arma);
			}
		}
		throw new IllegalArgumentException("No se encontró un arma1 con el ID especificado: " + idArma);
	}

	private Escudo buscarEscudo(String idEscudo) {
		for (Escudo escudo : escudos) {
			if(escudo.getId().equals(idEscudo) ) {
				return(escudo);
			}
		}
		throw new IllegalArgumentException("No se encontró un escudo con el ID especificado: " + idEscudo);
	}
	*/

	public void mostrarMapaEstelar(){
		mapaEstelar.mostrarSistemas();
	}

	public void comprarInformacion(){
		jugador.comprarInformacion(mapaEstelar);
	}

	public void agregarPlanetasDePrueba(){
		mapaEstelar.agregarPlanetasASistemas();
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
}