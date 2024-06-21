package view;
import models.sistemaEstelar.CinturonAsteroides;
import models.sistemaEstelar.Planeta;

import java.util.List;
import java.util.ArrayList;

public class SistemaEstelarView {
    private String nombre;
    private List<PlanetaView> planetas;
    private CinturonAsteroidesView cinturonAsteroides;

    public SistemaEstelarView(String nombre, List<Planeta> planetasModels, CinturonAsteroides cinturon){
        List<PlanetaView> planetas = new ArrayList<>();
        this.nombre = nombre;

        for(Planeta planeta : planetasModels){
            planetas.add(planeta.toView());
        }
        if(cinturon != null){
            this.cinturonAsteroides = new CinturonAsteroidesView(cinturon.getPoderDelCinturon());
        }else{
            this.cinturonAsteroides = null;
        }
        this.planetas = planetas;
    }

    public List<PlanetaView> getPlanetas(){
       return this.planetas;
    }

    public CinturonAsteroidesView getCinturonAsteroides(){
        return this.cinturonAsteroides;
    }

    public String getNombre(){
        return this.nombre;
    }
}
