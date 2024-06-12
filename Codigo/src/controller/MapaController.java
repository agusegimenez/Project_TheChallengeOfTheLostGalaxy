package controller;
import gestor.GestorJuego;
import models.sistemaEstelar.MapaEstelar;
import view.MapaEstelarView;


public class MapaController {
    public void mostrarMapa(){
        MapaEstelarView  mapaView = GestorJuego.getInstancia().getMapaEstelar().toView();
    }


}
