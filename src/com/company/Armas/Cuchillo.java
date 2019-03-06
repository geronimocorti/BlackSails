package com.company.Armas;

import com.company.Tripulantes.Tripulante;

public class Cuchillo extends Arma{
    private static Double poderDeDanio;

    @Override
    public Double poderDeDanio(Tripulante tripulante){
        return poderDeDanio;
    }

    public static Double getPoderDeDanio(){
        return poderDeDanio;
    }


}
