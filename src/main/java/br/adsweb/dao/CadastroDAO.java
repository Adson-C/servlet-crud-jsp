package br.adsweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.adsweb.dto.EstadoDTO;
import br.adsweb.exception.PersistenciaException;
import br.adsweb.util.ConexaoUltil;

// Class Dao de acesso a dados da aplicação usuario

public class CadastroDAO {
	
	// Metodo para listar Estados
		public List<EstadoDTO> listEstados() throws PersistenciaException {
			List<EstadoDTO> list = new ArrayList<>();
	
			try {
				Connection connection = ConexaoUltil.getConexao();
				
				StringBuilder sql = new StringBuilder();
				sql.append("select * from tb_estados");
				
				PreparedStatement pre = connection.prepareStatement(sql.toString());
				
				ResultSet resul = pre.executeQuery();
				while (resul.next()) {
					
					EstadoDTO dto = new EstadoDTO();
					dto.setId_uf(resul.getInt(1));
					dto.setSigla(resul.getString(2));
					dto.setDescricao(resul.getString(3));
					
					list.add(dto);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				throw new PersistenciaException(e);
			}
			
			return list;
	}
	
}
