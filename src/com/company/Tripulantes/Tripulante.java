package com.company.Tripulantes;

import com.company.Embarcacion;

public class Tripulante {
    private Double nivelDeCorajeBase;
    private Double inteligencia;
    private TipoTripulante tipoTripulante;

    public Tripulante(Double nivelDeCorajeBase, Double inteligencia, TipoTripulante tipoTripulante) {
        this.nivelDeCorajeBase = nivelDeCorajeBase;
        this.inteligencia = inteligencia;
        this.tipoTripulante = tipoTripulante;
    }

    public Double calcularCoraje(Embarcacion embarcacion){
        return nivelDeCorajeBase + tipoTripulante.calcularCoraje(embarcacion, this);
    }

    public Double getNivelDeCorajeBase(){
        return nivelDeCorajeBase;
    }

    public void aumentarCorajeBase(Double cantidadCoraje){
        nivelDeCorajeBase += cantidadCoraje;
    }

    public Double getInteligencia() {
        return inteligencia;
    }

    public void cambiarRol(TipoTripulante tipoTripulante){
        this.tipoTripulante = tipoTripulante;
    }

    public void disminuirCorajeBase(Double nivelDeSusto) {
        nivelDeCorajeBase = Math.max(0, nivelDeCorajeBase - nivelDeSusto);
    }
}
