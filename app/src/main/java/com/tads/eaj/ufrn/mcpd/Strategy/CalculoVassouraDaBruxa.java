package com.tads.eaj.ufrn.mcpd.Strategy;

/**
 * Created by suelliton on 11/11/2017.
 */

public class CalculoVassouraDaBruxa implements CalculaCrecimento{

    @Override
    public double calculaCrescimentoPraga(Praga praga) {
        return praga.getEscala() * 10;
    }
}
