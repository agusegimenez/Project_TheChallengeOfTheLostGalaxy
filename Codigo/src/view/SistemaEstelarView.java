package view;
import models.sistemaEstelar.CinturonAsteroides;
import models.sistemaEstelar.Planeta;

import java.util.List;
import java.util.ArrayList;

public class SistemaEstelarView {
    private String nombre;
    private List<PlanetaView> planetas;
    private CinturonAsteroidesView cinturonAsteroides;

    public SistemaEstelarView(String nombre, List<Planeta> planetas, CinturonAsteroides cituron){
        List<PlanetaView> planetas = new ArrayList<>();
        this.nombre = nombre;
        for(Planeta planeta : planetas){
            planetas.add(planeta.toView());
        }
        if(cinturon != null){
            this.cinturonAsteroides = new CinturonAsteroidesView();
        }

    }
}
