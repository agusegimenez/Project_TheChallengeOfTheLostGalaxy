package view;

import models.sistemaEstelar.SistemaEstelar;

import java.util.ArrayList;
import java.util.List;

public class MapaEstelarView {
    private List<SistemaEstelarView> sistemas;

    public MapaEstelarView(List<SistemaEstelar> sistemas){
        List<SistemaEstelarView> sistemasView = new ArrayList<>();
        for(SistemaEstelar sistema : sistemas){
            sistemasView.add(sistema.toView());
        }
        this.sistemas = sistemasView;
    }

    public List<SistemaEstelarView> getSistemas(){
        return this.sistemas;
    }

}
