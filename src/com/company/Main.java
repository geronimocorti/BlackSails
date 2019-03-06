package com.company;

import com.company.Tripulantes.Cocinero;
import com.company.Tripulantes.Contramaestre;
import com.company.Tripulantes.Pirata;
import com.company.Tripulantes.Tripulante;

public class Main {

    public static void main(String[] args) {
        Tripulante pirata = new Tripulante(100d, 10d, new Pirata());
        Tripulante cocinero = new Tripulante(30d, 70d, new Cocinero());
        Tripulante contramaestre = new Tripulante(170d, 10d, new Contramaestre());

        Embarcacion embarcacion = new Embarcacion();
    }
}
