package br.adsweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.adsweb.exception.PersistenciaException;
import br.adsweb.util.ConexaoUltil;

// Class Dao de acesso a dados dos Usuarios

public class UsuarioDAO {
	
	// Methodo de autenticação do usuario 
	public boolean validarUsuario(String usuario, String senha ) throws PersistenciaException {
		
		try {
			Connection connect = ConexaoUltil.getConexao();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_usuario");
			sql.append(" where usuario = ? and senha = ?");
			
			PreparedStatement pre = connect.prepareStatement(sql.toString());
			
			pre.setString(1, usuario);
			pre.setString(2, senha);
			
			ResultSet resul = pre.executeQuery();
			
			return resul.next();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
				
	}

}
