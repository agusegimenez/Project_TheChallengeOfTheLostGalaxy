package controller;

import models.Nave.Nave;
import gestor.GestorJuego;
import models.sistemaEstelar.SistemaEstelar;
import view.NaveView;

import java.util.ArrayList;
import java.util.List;

public class NaveController {
    private List<Nave> naves;
    private List<NaveView> naveViews = new ArrayList<>();

    public NaveController(){
        this.naves = GestorJuego.getInstancia().getNaves();
    }

    public void asignarNaveAegis(){
        for(Nave nave : naves){
            if(nave.esAegis()){
                GestorJuego.getInstancia().asignarNaveAJugador(nave.getNombreNave());
            }
        }
    }
    public void asignarNavePhantom(){
        for(Nave nave : naves){
            if(nave.esPhantom()){
                GestorJuego.getInstancia().asignarNaveAJugador(nave.getNombreNave());
            }
        }
    }
    public void asignarNaveTitan(){
        for(Nave nave : naves){
            if(nave.esTitan()){
                GestorJuego.getInstancia().asignarNaveAJugador(nave.getNombreNave());
            }
        }
    }
    public void asignarNaveSwift(){
        for(Nave nave : naves){
            if(nave.esSwift()){
                GestorJuego.getInstancia().asignarNaveAJugador(nave.getNombreNave());
            }
        }
    }
    public List<NaveView> getNaveViews(){
        for(Nave nave : naves){
            naveViews.add(nave.toView());
        }
        return naveViews;
    }

    public NaveView getNaveJugadorView(){
        return  GestorJuego.getInstancia().getJugador().getNave().toView();
    }

    public void atravesarCinturon(){
        GestorJuego.getInstancia().getJugador().getNave().atravesarCinturon();
    }

}
