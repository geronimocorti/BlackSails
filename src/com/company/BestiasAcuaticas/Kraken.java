package com.company.BestiasAcuaticas;

import com.company.Embarcacion;

public class Kraken extends BestiaAcuatica {

    private static Kraken kraken;

    private Kraken(Double nivelDeFuerza) {
        super(nivelDeFuerza);
    }

    public Kraken getInstanceKraken(){
        if(kraken == null){
            kraken = new Kraken(100000d);
        }
        return kraken;
    }

    @Override
    protected void producirDanio(Embarcacion embarcacion) {
        embarcacion.matarIntegranteMasCorajudo();
    }
}
