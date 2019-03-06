package com.company.Tripulantes;

import com.company.Armas.Canion;
import com.company.Embarcacion;

public class Capitan implements TipoTripulante {

    @Override
    public Double calcularCoraje(Embarcacion embarcacion, Tripulante tripulante){
        return embarcacion.getCaniones().stream().mapToDouble(Canion::calcularPoderDeDanio).sum() * 0.05;
    }
}
