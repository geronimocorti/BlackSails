package com.company.Armas;

import com.company.Tripulantes.Tripulante;

public class Espada extends Arma {
    private Double poderDeDanio;

    public Espada(Double poderDeDanio){
        this.poderDeDanio = poderDeDanio;
    }

    @Override
    public Double poderDeDanio(Tripulante tripulante){
        return poderDeDanio;
    }
}
