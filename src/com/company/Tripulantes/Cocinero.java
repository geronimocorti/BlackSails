package com.company.Tripulantes;

import com.company.Armas.Arma;
import com.company.Armas.Cuchillo;
import com.company.Embarcacion;
import com.sun.xml.internal.messaging.saaj.util.FinalArrayList;

import java.util.ArrayList;

public class Cocinero implements TipoTripulante{

    private ArrayList<Arma> cuchillos;

    public Cocinero(){
        this.cuchillos = new FinalArrayList(2);
        this.cuchillos.add(new Cuchillo());
        this.cuchillos.add(new Cuchillo());
    }

    @Override
    public Double calcularCoraje(Embarcacion embarcacion, Tripulante tripulante) {
        return cuchillos.size() * Cuchillo.getPoderDeDanio();
    }
}
