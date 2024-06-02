package models.sistemaEstelar;
import java.util.List;
import java.util.Random;

public class SistemaEstelar {
    private String nombre;
    private List<Planeta> planetas;
    private List<CinturonAsteroides> cinturones;

    public SistemaEstelar(String nombre, List<Planeta> planetas, List<CinturonAsteroides> cinturones) {
        this.nombre = nombre;
        this.planetas = planetas;
        this.cinturones = cinturones;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Planeta> getPlanetas() {
        return planetas;
    }

    public List<CinturonAsteroides> getCinturones() {
        return cinturones;
    }

    public boolean tieneCinturones() {
        return !cinturones.isEmpty();
    }

	public void trasladarAPlaneta(String idPlaneta) {
		Planeta planeta = buscarPlaneta(idPlaneta);
		jugador.visitarPlaneta(planeta);
	}
    private Planeta buscarPlaneta(String idPlaneta) {
        for (Planeta planeta : planetas) {
            if(planeta.getIdPlaneta().equals(idPlaneta) ) {
                return(planeta);
            }
        }
        throw new IllegalArgumentException("No se encontró un Planeta con el ID especificado: " + idPlaneta);
    }
}
