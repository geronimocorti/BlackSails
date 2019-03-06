package com.company.Armas;

public class Pistola extends Arma {
    private Double calibre;
    private Double durezaMaterial;

    @Override
    public Double poderDeDanio(){
        return calibre * durezaMaterial;
    }
}
