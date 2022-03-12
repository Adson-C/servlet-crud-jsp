package br.adsweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.adsweb.dto.CidadeDTO;
import br.adsweb.dto.EstadoDTO;
import br.adsweb.dto.PrefereciaMusicalDTO;
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
		
		// metodo para listar preferenciaMusical
		public List<PrefereciaMusicalDTO> listarPreferencias() throws PersistenciaException {
			
			List<PrefereciaMusicalDTO> listarPrefe = new ArrayList<>();
			
			try {
				Connection connection = ConexaoUltil.getConexao();
				
				StringBuilder sql = new StringBuilder();
				sql.append("select * from tb_preferencia");
				
				PreparedStatement pre = connection.prepareStatement(sql.toString());
				
				ResultSet resul = pre.executeQuery();
				
				while (resul.next()) {
					PrefereciaMusicalDTO prefereciaMusical = new PrefereciaMusicalDTO();
					prefereciaMusical.setIdPreferencia(resul.getInt(1));
					prefereciaMusical.setDescricao(resul.getString(2));
					
					listarPrefe.add(prefereciaMusical);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				throw new PersistenciaException(e);
			}
			
			return listarPrefe;
		}
		
		// metodo de consulta das cidades de acordo com id do estados 
		public List<CidadeDTO> consultarCidadePorEstados(Integer idEstado) throws PersistenciaException {
			List<CidadeDTO> listaCidades = new ArrayList<>(); 
			
			try {
				Connection connection = ConexaoUltil.getConexao();
				
				StringBuilder sql = new StringBuilder();
				sql.append("select * from tb_cidade");
				sql.append(" where cod_estado = ?");
				
				PreparedStatement pre = connection.prepareStatement(sql.toString());
				pre.setInt(1, idEstado);
				
				ResultSet result = pre.executeQuery();
				
				while (result.next()) {
					CidadeDTO cidaddeDTO = new CidadeDTO();
					cidaddeDTO.setIdCidade(result.getInt("id_cidade"));
					cidaddeDTO.setDescricao(result.getString("descricao"));
					
					EstadoDTO estadoDTO = new EstadoDTO();
					estadoDTO.setId_uf(result.getInt("cod_estado"));
					
					cidaddeDTO.setEstado(estadoDTO);
					
					listaCidades.add(cidaddeDTO);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				throw new PersistenciaException(e);
				
				
			}
			return listaCidades;
		}
	
}
