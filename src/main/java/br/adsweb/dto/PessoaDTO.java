package br.adsweb.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.adsweb.util.PreferenciaMusical;

public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer idPessoa;
	
	private String nome;
	
	private Long cpf;
	
	private Date dtNasc;
	
	private char sexo;
	
	private List<PreferenciaMusical> preferencia;
	
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

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public List<PreferenciaMusical> getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(List<PreferenciaMusical> preferencia) {
		this.preferencia = preferencia;
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
	
	

}
