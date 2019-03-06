package com.company.BestiasAcuaticas;

import com.company.Embarcacion;

public class TiburonBlanco extends BestiaAcuatica {

    public TiburonBlanco(Double nivelDeFuerza) {
        super(nivelDeFuerza);
    }

    @Override
    protected void producirDanio(Embarcacion embarcacion) {
        embarcacion.causarPavor(nivelDeFuerza);
    }
}
