package com.company.Tripulantes;

import com.company.Embarcacion;

import java.util.List;

public class Contramaestre implements TipoTripulante {
    List<Tripulante> tripulacionACargo;

    public Contramaestre(List<Tripulante> tripulacionACargo) {
        this.tripulacionACargo = tripulacionACargo;
    }

    @Override
    public Double calcularCoraje(Embarcacion embarcacion, Tripulante tripulante) {
        return tripulacionACargo.stream().mapToDouble(t -> t.calcularCoraje(embarcacion)).sum() * 0.1;
    }
}
