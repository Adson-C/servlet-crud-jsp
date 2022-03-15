package br.adsweb.dto;

import java.io.Serializable;
import java.util.List;



public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer idPessoa;
	
	private String nome;
	
	private String cpf;
	
	private String dtNasc;
	
	private char sexo;
	
	private List<PrefereciaMusicalDTO> preferencia;
	
	private String cometario;
	
	private EnderecoDTO endereco;

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}


	public String getCometario() {
		return cometario;
	}

	public void setCometario(String cometario) {
		this.cometario = cometario;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public List<PrefereciaMusicalDTO> getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(List<PrefereciaMusicalDTO> preferencia) {
		this.preferencia = preferencia;
	}
	
	

}
