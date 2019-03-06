package com.company.BestiasAcuaticas;

import com.company.Embarcacion;

public class BallenaAzul extends BestiaAcuatica{

    public BallenaAzul(Double nivelDeFuerza) {
        super(nivelDeFuerza);
    }

    @Override
    protected void producirDanio(Embarcacion embarcacion) {
        embarcacion.sacudirEmbarcacion();
    }
}
