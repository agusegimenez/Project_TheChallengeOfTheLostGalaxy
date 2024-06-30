package controller;
import gestor.GestorJuego;
import models.sistemaEstelar.MapaEstelar;
import view.MapaEstelarView;


public class MapaController {
    public MapaEstelarView getMapaEstelarView(){
        return  GestorJuego.getInstancia().getMapaEstelar().toView();
    }


}
