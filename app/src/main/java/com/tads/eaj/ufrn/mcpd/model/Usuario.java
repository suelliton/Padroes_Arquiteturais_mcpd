package com.tads.eaj.ufrn.mcpd.model;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

public class Usuario  extends SugarRecord {

	private String nomeUsuario;

	private String cpf;

	private List<Usuario> registros= new ArrayList<>();

	public Usuario(){}

	public Usuario(String nomeUsuario, String cpf, List<Usuario> registros) {
		this.nomeUsuario = nomeUsuario;
		this.cpf = cpf;
		this.registros = registros;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Usuario> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Usuario> registros) {
		this.registros = registros;
	}
}
