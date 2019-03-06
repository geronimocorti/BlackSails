package com.company;

import com.company.Armas.Canion;

import java.util.LinkedList;
import java.util.List;

public class CanionFactory {

    private static Double poderDeDanioDeFabricacion = 350d;

    public static List<Canion> crearCaniones(Integer cantidadDeCaniones){
        List<Canion> caniones = new LinkedList<>();
        for (int i = 0; i < cantidadDeCaniones; i++){
            caniones.add(new Canion(poderDeDanioDeFabricacion));
        }
        return caniones;
    }

    public static void cambiarPoderDeDanioDeFabricacion(Double nuevoPoderDeDanio){
        poderDeDanioDeFabricacion = nuevoPoderDeDanio;
    }
}
