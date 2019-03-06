package com.company.Armas;

import com.company.Tripulantes.Tripulante;

public class Insulto extends Arma {

    private final Integer cantidadDePalabras;

    public Insulto(String insultos){
        this.cantidadDePalabras = insultos.split(" ").length;
    }


    @Override
    public Double poderDeDanio(Tripulante tripulante) {
        return tripulante.getNivelDeCorajeBase() * cantidadDePalabras;
    }
}
