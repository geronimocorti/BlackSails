package com.company;

import com.company.Armas.Canion;
import com.company.Armas.Espada;
import com.company.Contienda.TipoContienda;
import com.company.Tripulantes.*;

import java.util.*;
import java.util.function.Function;

public class Embarcacion {
    private Tripulante capitan;
    private Tripulante contramaestre;
    private List<Tripulante> cocinerosYPiratas;
    private List<Canion> caniones;
    private Oceano oceano;
    private Long botin;

    public Embarcacion(Tripulante capitan, Tripulante contramaestre, List<Tripulante> cocinerosYPiratas, List<Canion> caniones, Oceano oceano, Long botin) {
        this.capitan = capitan;
        this.contramaestre = contramaestre;
        this.cocinerosYPiratas = cocinerosYPiratas;
        this.caniones = caniones;
        this.oceano = oceano;
        this.botin = botin;
    }

    public List<Canion> getCaniones() {
        return caniones;
    }

    public Embarcacion atacar(Embarcacion embarcacion){
        return (this.nivelDeCoraje() > embarcacion.nivelDeCoraje())? this : embarcacion;
    }

    public Double nivelDeCoraje(){
        return capitan.calcularCoraje(this) + contramaestre.calcularCoraje(this) +
                calcularCorajeCocinerosYPiratas() + poderDeDanioCaniones();
    }

    private Double calcularCorajeCocinerosYPiratas() {
        return cocinerosYPiratas.stream().mapToDouble(t -> t.calcularCoraje(this)).sum();
    }

    private Double poderDeDanioCaniones(){
        return caniones.stream().mapToDouble(Canion::calcularPoderDeDanio).sum();
    }

    public Tripulante getTripulanteMasCorajudo(){
        return cocinerosYPiratas.stream().max(Comparator.comparing(t -> t.calcularCoraje(this))).orElse(null);
    }

    public Boolean puedenEntrarEnConflicto(Embarcacion embarcacionEnemiga){
        return oceano.equals(embarcacionEnemiga.getOceano()) && oceano.estanCerca(embarcacionEnemiga.getOceano());
    }

    public void entrarEnContienda(TipoContienda tipoContienda, Embarcacion embarcacionEnemiga){
        tipoContienda.entrarEnContienda(this, embarcacionEnemiga);
    }

    public Oceano getOceano() {
        return oceano;
    }

    public void aumentarCorajeBaseDeLaTripulacion(Double cantidadCoraje){
        capitan.aumentarCorajeBase(cantidadCoraje);
        contramaestre.aumentarCorajeBase(cantidadCoraje);
        cocinerosYPiratas.forEach(t -> t.aumentarCorajeBase(cantidadCoraje));
    }

    public void matarIntegranteMasCobarde(Function<Tripulante, Double> criteria) {
        Tripulante triuplanteAMatar
                = cocinerosYPiratas.stream().min(Comparator.comparing(criteria)).get();
        cocinerosYPiratas.remove(triuplanteAMatar);
    }

    public void matarIntegranteMasCorajudo() {
        Tripulante triuplanteAMatar
                = cocinerosYPiratas.stream().max(Comparator.comparing(t -> t.calcularCoraje(this))).get();
        cocinerosYPiratas.remove(triuplanteAMatar);
    }

    public void ascenderAContramaestreACapitanDeOtraEmbarcacion(Embarcacion embarcacionPerdedora) {
        contramaestre.cambiarRol(new Capitan());
        embarcacionPerdedora.setCapitan(contramaestre);
        contramaestre = null;
    }

    private void setCapitan(Tripulante nuevoCapitan) {
        capitan = nuevoCapitan;
    }

    private Tripulante getContramaestre() {
        return contramaestre;
    }

    public void ascenderTripulanteMasCorajudoAContramaestre() {
        Tripulante tripulanteMasCorajudo = getTripulanteMasCorajudo();
        tripulanteMasCorajudo.cambiarRol(new Contramaestre(cocinerosYPiratas));
        contramaestre = tripulanteMasCorajudo;
        cocinerosYPiratas.remove(tripulanteMasCorajudo);
    }

    public void moverTripulanteCorajudoAOtraEmbarcacion(Embarcacion embarcacionEnemiga) {
        Tripulante tripulanteAMover
                = cocinerosYPiratas.stream().max(Comparator.comparing(t -> t.calcularCoraje(this))).get();
        embarcacionEnemiga.add(tripulanteAMover);
        cocinerosYPiratas.remove(tripulanteAMover);
    }

    private void add(Tripulante tripulante) {
        cocinerosYPiratas.add(tripulante);
    }

    private void add(List<Tripulante> tripulantes) {
        cocinerosYPiratas.addAll(tripulantes);
    }

    public Boolean tieneHabilNegociador() {
        return cocinerosYPiratas.stream().anyMatch(t -> t.getInteligencia() > 50);
    }

    public void robarMitadDelBotin(Embarcacion embarcacionPerdedora) {
        botin += embarcacionPerdedora.getBotin() / 2;
        embarcacionPerdedora.perderBotin(embarcacionPerdedora.getBotin() / 2);
    }

    public void perderBotin(Long cantidad) {
        botin = Math.max(0, botin - cantidad);
    }

    private Long getBotin() {
        return botin;
    }

    public void generarMotin(){
        if(contramaestre.calcularCoraje(this) > capitan.calcularCoraje(this)){
            contramaestre.cambiarRol(new Capitan());
            capitan = contramaestre;
            ascenderTripulanteMasCorajudoAContramaestre();
        }
        else{
            Random random = new Random(System.currentTimeMillis());
            Integer numeroRandom = random.nextInt(10);

            if(numeroRandom >= 8){
                Pirata pirata = new Pirata(Arrays.asList(new Espada(1d)));
                contramaestre.cambiarRol(pirata);
                add(contramaestre);

            }
            else{
                contramaestre.cambiarRol(new Cocinero());
                add(contramaestre);
            }

            Tripulante tripulanteAAscender = getTripulanteMasCorajudo();
            tripulanteAAscender.cambiarRol(new Contramaestre(cocinerosYPiratas));
            contramaestre = tripulanteAAscender;
        }
    }

    public void sacudirEmbarcacion() {
        caniones.stream().forEach(c -> c.envejecer(8));
    }

    public void causarPavor(Double nivelDeSusto) {
        capitan.disminuirCorajeBase(nivelDeSusto);
    }
}
