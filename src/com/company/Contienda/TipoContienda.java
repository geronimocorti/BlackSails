package com.company.Contienda;

import com.company.Embarcacion;

public interface TipoContienda {
    void entrarEnContienda(Embarcacion embarcacionGanadora, Embarcacion embarcacionPerdedora);
    Boolean puedeSusceder(Embarcacion embarcacion, Embarcacion embarcacionEnemiga);
}
