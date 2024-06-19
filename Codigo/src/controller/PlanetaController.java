package controller;
import gestor.GestorJuego;
import models.sistemaEstelar.SistemaEstelar;
import view.SistemaEstelarView;

public class PlanetaController {

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
}
