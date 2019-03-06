package com.company.BestiasAcuaticas;

import com.company.Embarcacion;

public abstract class BestiaAcuatica {

    protected Double nivelDeFuerza;

    public BestiaAcuatica(Double nivelDeFuerza) {
        this.nivelDeFuerza = nivelDeFuerza;
    }

    public void atacar(Embarcacion embarcacion){
        if(nivelDeFuerza > embarcacion.nivelDeCoraje()){
            producirDanio(embarcacion);
        }
    }

    protected abstract void producirDanio(Embarcacion embarcacion);

}
