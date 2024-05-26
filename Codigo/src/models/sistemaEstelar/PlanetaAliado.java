package models.sistemaEstelar;

import models.equipamiento.*;
import models.Nave.Nave;

public class PlanetaAliado extends Planeta{
    public PlanetaAliado(String idPlaneta) {
        super(idPlaneta);
        this.costoDeCombustible = 15;
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

    public void comprarInformacion(int uadeCoins){

    };

}
=======
package models.planeta;

import models.Nave.Nave;
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

    private void repararNave(Nave nave){

    }

    private void comprarInformacion(int uadeCoins){

    };

}
>>>>>>> Stashed changes:Codigo/src/models/planeta/PlanetaAliado.java
