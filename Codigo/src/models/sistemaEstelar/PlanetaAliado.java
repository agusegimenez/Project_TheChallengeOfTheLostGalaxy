package models.sistemaEstelar;

import models.equipamiento.*;
import models.Nave.Nave;
import java.util.Random;

public class PlanetaAliado extends Planeta{
    private int precioInformacion;
    private Random random;

    public PlanetaAliado(String idPlaneta) {
        super(idPlaneta);
        this.costoDeCombustible = 15;
        this.precioInformacion = random.nextInt(500)+1000;
    }

    @Override
    public boolean soyHostil() {
        return (false);
    }
    @Override
    public boolean soyNeutral() {
        return (false);
    }
    @Override
    public boolean soyAliado() {
        return (true);
    }
    public Enemigo getEnemigo() {
        throw new IllegalArgumentException("no es un Planeta Hostil");
    }
    public boolean tieneTesoro() {
        return(false);
    }
    @Override
    public Arma getArma() {
        throw new IllegalArgumentException("No soy un Planeta Neutral");
    }
    @Override
    public Escudo getEscudo() {
        throw new IllegalArgumentException("No soy un Planeta Neutral");
    }

    public void desplegarInformacion(SistemaEstelar sistemaEstelar){

    }
    public int getPrecioInformacion(){
        return this.precioInformacion;
    }

}
