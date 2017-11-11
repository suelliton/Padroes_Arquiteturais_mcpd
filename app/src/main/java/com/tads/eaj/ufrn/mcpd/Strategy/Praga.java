package com.tads.eaj.ufrn.mcpd.Strategy;

import com.orm.SugarRecord;
import com.tads.eaj.ufrn.mcpd.Strategy.CalculaCrecimento;
import com.tads.eaj.ufrn.mcpd.Strategy.CalculoAmarelao;
import com.tads.eaj.ufrn.mcpd.Strategy.CalculoPadrao;
import com.tads.eaj.ufrn.mcpd.Strategy.CalculoVassouraDaBruxa;

public class Praga  extends SugarRecord {

	private long id;
	private String nome;
	private int escala;
	private int idCultura;
	private double crescimentoSemanal;
	CalculaCrecimento calculo;

	public Praga(long id, String nome, int escala, int idCultura) {
		this.id = id;
		this.nome = nome;
		this.escala = escala;
		this.idCultura = idCultura;

		switch (nome){
			case "Vassoura da Bruxa":
				calculo= new CalculoVassouraDaBruxa();
				break;
			case "Amarelao":
				calculo = new CalculoAmarelao();
				break;
			default:
				calculo = new CalculoPadrao();
		}
		calculaCrescimento();
		}

	public void calculaCrescimento(){
		this.crescimentoSemanal = calculo.calculaCrescimentoPraga(this);
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEscala() {
		return escala;
	}

	public void setEscala(int escala) {
		this.escala = escala;
	}

	public int getIdCultura() {
		return idCultura;
	}

	public void setIdCultura(int idCultura) {
		this.idCultura = idCultura;
	}

	public double getCrescimentoSemanal() {
		return crescimentoSemanal;
	}

	public void setCrescimentoSemanal(double crescimentoSemanal) {
		this.crescimentoSemanal = crescimentoSemanal;
	}
}
