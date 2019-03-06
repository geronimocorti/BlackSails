package com.company;

import com.company.BestiasAcuaticas.BestiaAcuatica;

import java.util.LinkedList;
import java.util.List;

public class Oceano {
    private static Double FACTOR_CERCANIA = 50d;
    private String nombre;
    private List<BestiaAcuatica> bestiasActuaticas;
    private Double posicionX;
    private Double posicionY;

    public Oceano(String nombre, Double posicionX, Double posicionY, List<BestiaAcuatica> bestiasAcuaticas){
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.bestiasActuaticas = new LinkedList<>(bestiasAcuaticas);
    }

    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        if(!(object instanceof Oceano)){
            return false;
        }
        Oceano oceanoAComparar = (Oceano) object;
        return nombre.equals(oceanoAComparar.getNombre());
    }

    private String getNombre() {
        return nombre;
    }


    public Boolean estanCerca(Oceano otroOceano) {
        Double factorX = Math.pow(posicionX - otroOceano.getPosicionX(), 2);
        Double factorY = Math.pow(posicionY - otroOceano.getPosicionY(), 2);
        return Math.sqrt(factorX + factorY) <= FACTOR_CERCANIA;
    }

    private Double getPosicionY() {
        return posicionY;
    }

    private Double getPosicionX() {
        return posicionX;
    }

    public static void setFactorCercania(Double nuevoFactor){
        FACTOR_CERCANIA = nuevoFactor;
    }
}
