package com.tads.eaj.ufrn.mcpd.Builder;

/**
 * Created by suelliton on 11/11/2017.
 */

public class MilhoCultura extends CulturaBuilder {
    @Override
    public void buildId() {
        cultura.id = 2;
    }

    @Override
    public void buildNome() {
        cultura.nome = "Milho";
    }

    @Override
    public void buildDescricao() {
        cultura.descricao = "É um milharal do Mato Grosso do Sul";
    }
}
