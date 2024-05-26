package models.planeta;

import models.equipamiento.Arma;
import models.equipamiento.Escudo;

public class PlanetaAliado extends Planeta{
    public PlanetaAliado(String idPlaneta, int costoDeCombustible) {
        super(idPlaneta, costoDeCombustible);
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

    private void repararNave(int vida, int escudo){

    }

    private void comprarInformacion(){

    };

}
