package com.company.Contienda;

import com.company.Embarcacion;

public class Negociacion implements TipoContienda {
    @Override
    public void entrarEnContienda(Embarcacion embarcacionGanadora, Embarcacion embarcacionPerdedora) {
        embarcacionGanadora.robarMitadDelBotin(embarcacionPerdedora);
    }

    @Override
    public Boolean puedeSusceder(Embarcacion embarcacion, Embarcacion embarcacionEnemiga) {
        return embarcacion.tieneHabilNegociador();
    }
}
