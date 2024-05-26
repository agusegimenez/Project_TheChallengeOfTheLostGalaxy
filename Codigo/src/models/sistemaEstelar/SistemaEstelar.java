package models.sistemaEstelar;
import java.util.List;
import java.util.Random;

public class SistemaEstelar {
    private List<Planeta> planetas;
    private List<CinturonAsteroides> cinturones;

    public SistemaEstelar(List<Planeta> planetas, List<CinturonAsteroides> cinturones) {
        this.planetas = planetas;
        this.cinturones = cinturones;
    }


    public boolean tieneCinturones(){
        Random random = new Random();
        boolean tiene;
        if (random.nextBoolean()) tiene = true;
        else tiene = false;

        return tiene;
    }


}
