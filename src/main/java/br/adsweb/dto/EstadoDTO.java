package br.adsweb.dto;

import java.io.Serializable;

// DTO para dados de Estados

public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id_uf;
	
	private String sigla;
	
	private String descricao;

	public Integer getId_uf() {
		return id_uf;
	}

	public void setId_uf(Integer id_uf) {
		this.id_uf = id_uf;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
}
