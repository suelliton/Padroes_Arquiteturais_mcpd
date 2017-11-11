package com.tads.eaj.ufrn.mcpd.Builder;

/**
 * Created by suelliton on 11/11/2017.
 */

public class ConstructorCultura {
    protected CulturaBuilder builder;

    public ConstructorCultura(CulturaBuilder builder) {
        this.builder = builder;
    }

    public void construirCultura(){
        builder.buildId();
        builder.buildNome();
        builder.buildDescricao();
    }
    public Cultura getCultura(){
       return builder.getCultura();
    }
}
