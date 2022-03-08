package br.adsweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

// classe de conexao SQL

public class ConexaoUltil {
	
	private static ResourceBundle configBD = ResourceBundle.getBundle(Constantes.CONEXAO_DB_PROPERTIES);
	
	public static Connection getConexao() throws SQLException, ClassNotFoundException {
		Class.forName(configBD.getString(Constantes.CONEXAO_DB_DRIVER));
		
		return DriverManager.getConnection(configBD.getString(Constantes.CONEXAO_DB_URL), 
				configBD.getString(Constantes.CONEXAO_DB_USER), configBD.getString(Constantes.CONEXAO_DB_PASSWORD));
		
	}
	
}
