package controller;
import gestor.GestorJuego;
import models.sistemaEstelar.Planeta;
import models.sistemaEstelar.SistemaEstelar;
import view.*;

public class PlanetaController {

    public PlanetaView viajarAPlaneta(String idPlaneta) throws IllegalArgumentException, RuntimeException{
        Planeta planeta = GestorJuego.getInstancia().trasladarAPlaneta(idPlaneta);
        return planeta.toView();
    }

    public SistemaEstelarView comprarInformacion() throws IllegalArgumentException{
        SistemaEstelar sistemaEstelar  = GestorJuego.getInstancia().comprarInformacion();
        return sistemaEstelar.toView();
    }
    public void repararNave(){
        GestorJuego.getInstancia().repararNave();
    }
    public void cargarCombustible(int cantidad) throws IllegalArgumentException{
        GestorJuego.getInstancia().cargarCombustible(cantidad);
    }

    public void comprarArma(){
        GestorJuego.getInstancia().comprarArma();
    }
    public void comprarEscudo(){
        GestorJuego.getInstancia().comprarEscudo();
    }

    public void venderEscudo(){
        GestorJuego.getInstancia().venderEscudo();
    }
    public void venderArma(int indice){
        GestorJuego.getInstancia().venderArma(indice);
    }

    public ArmaView getArmaView(){
        return GestorJuego.getInstancia().getJugador().getPlanetaActual().getArma().toView();
    }
    public EscudoView getEscudoView(){
        return GestorJuego.getInstancia().getJugador().getPlanetaActual().getEscudo().toView();
    }
    public PlanetaView getPlanetaActualView(){
        return GestorJuego.getInstancia().getJugador().getPlanetaActual().toView();
    }

    public int getPrecioInformacion(){
        return GestorJuego.getInstancia().getJugador().getPlanetaActual().getPrecioInformacion();
    }

    public EnemigoView getEnemigoView(){
        return GestorJuego.getInstancia().getJugador().getPlanetaActual().getEnemigo().toView();
    }

    public boolean tieneTesoro(String idPlaneta){
        return GestorJuego.getInstancia().getMapaEstelar().buscarPlaneta(idPlaneta).tieneTesoro();
    }

    public boolean tieneCinturon(String idPlaneta){
        return GestorJuego.getInstancia().getMapaEstelar().buscarSistemaEnPlaneta(idPlaneta).tieneCinturon();
    }

    public CinturonAsteroidesView getCinturonView(String idPlaneta){
        return GestorJuego.getInstancia().getMapaEstelar().buscarSistemaEnPlaneta(idPlaneta).getCinturonAsteroides().toView();
    }
    /*

    public ArmaView conseguirArmaView(PlanetaView planetaView){

    }
    public EscudoView conseguirEscudoView(PlanetaView planetaView){

    }

    */

}
