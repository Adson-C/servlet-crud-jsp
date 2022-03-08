package br.adsweb.dto;

import java.io.Serializable;

// DTO para dados de Usuarios

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idUser;
	
	private String usuario;
	
	private String senha;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
