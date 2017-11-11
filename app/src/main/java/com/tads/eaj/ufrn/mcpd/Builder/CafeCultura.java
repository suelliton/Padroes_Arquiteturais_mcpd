package com.tads.eaj.ufrn.mcpd.Builder;

/**
 * Created by suelliton on 11/11/2017.
 */

public class CafeCultura extends CulturaBuilder {

    @Override
    public void buildId() {
        cultura.id = 1;
    }

    @Override
    public void buildNome() {
        cultura.nome = "Café";
    }

    @Override
    public void buildDescricao() {
        cultura.descricao = "Cafe produzido em Minas Gerais";
    }
}
