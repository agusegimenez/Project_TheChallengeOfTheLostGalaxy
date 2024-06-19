package models.sistemaEstelar;

import models.equipamiento.*;

import java.util.Random;

public class PlanetaAliado extends Planeta{
    private int precioInformacion;
    private Random random = new Random();

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

    public int getPrecioInformacion(){
        return this.precioInformacion;
    }

    @Override
    public SistemaEstelar desplegarInformacion(MapaEstelar mapa) {
        SistemaEstelar sistemaEstelar = mapa.buscarSistemaConTesoro();
        if (sistemaEstelar != null) {
            return sistemaEstelar;
        }else{
            throw new IllegalArgumentException();
        }

    }
}
