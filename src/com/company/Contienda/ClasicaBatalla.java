package com.company.Contienda;

import com.company.Embarcacion;

public class ClasicaBatalla implements TipoContienda{

    @Override
    public void entrarEnContienda(Embarcacion embarcacionGanadora, Embarcacion embarcacionPerdedora) {
        embarcacionGanadora.aumentarCorajeBaseDeLaTripulacion(5d);
        for(int i = 0; i < 3; i++) embarcacionPerdedora.matarIntegranteMasCobarde();
        embarcacionGanadora.ascenderAContramaestreACapitanDeOtraEmbarcacion(embarcacionPerdedora);
        embarcacionGanadora.ascenderTripulanteMasCorajudoAContramaestre();
        for(int i = 0; i < 3; i++) embarcacionGanadora.moverTripulanteCorajudoAOtraEmbarcacion(embarcacionPerdedora);

    }

    @Override
    public Boolean puedeSusceder(Embarcacion embarcacion, Embarcacion embarcacionEnemiga) {
        return embarcacion.nivelDeCoraje() >= embarcacionEnemiga.nivelDeCoraje();
    }


}
