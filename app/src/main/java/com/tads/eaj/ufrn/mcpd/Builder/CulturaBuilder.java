package com.tads.eaj.ufrn.mcpd.Builder;

/**
 * Created by suelliton on 11/11/2017.
 */

public abstract class CulturaBuilder {
    protected Cultura cultura;

    public CulturaBuilder(){
        cultura = new Cultura();
    }

    public abstract void buildId();
    public abstract void buildNome();
    public abstract void buildDescricao();

    public Cultura getCultura(){
        return cultura;
    }
}
