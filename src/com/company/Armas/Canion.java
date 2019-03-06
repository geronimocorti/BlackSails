package com.company.Armas;

import java.time.LocalDate;

public class Canion{

    private LocalDate fechaDeCreacion;

    private Double poderDeDanio;

    public Canion(Double poderDeDanio){
        fechaDeCreacion = LocalDate.now();
        this.poderDeDanio = poderDeDanio;
    }

    public Double calcularPoderDeDanio() {
        return poderDeDanio - 0.01 * calcularAniosDeAntiguedad();
    }

    private Integer calcularAniosDeAntiguedad(){
        return LocalDate.now().getYear() - fechaDeCreacion.getYear();
    }


    public void envejecer(Integer cantidadDeAnios) {
        fechaDeCreacion.minusYears(cantidadDeAnios);
    }
}
