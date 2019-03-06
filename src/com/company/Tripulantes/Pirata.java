package com.company.Tripulantes;

import com.company.Armas.Arma;
import com.company.Embarcacion;

import java.util.List;

public class Pirata implements TipoTripulante {

    private List<Arma> armas;

    public Pirata(List<Arma> armas) {
        this.armas = armas;
    }

    @Override
    public Double calcularCoraje(Embarcacion embarcacion, Tripulante tripulante) {
        return armas.stream().mapToDouble(a -> a.poderDeDanio(tripulante)).sum();
    }
}
