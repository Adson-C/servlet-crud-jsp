package br.adsweb.bo;

import javax.servlet.http.HttpServletRequest;

import br.adsweb.dao.UsuarioDAO;
import br.adsweb.dto.UsuarioDTO;
import br.adsweb.exception.NegocioException;
import br.adsweb.exception.PersistenciaException;

// Class responsavél para os metodos de negócios da aplicação de Usuarios

public class UsuarioBO {
	
	public boolean validarUsuario(HttpServletRequest req) throws NegocioException {
		
		boolean isValido = true;
		
		try {
		
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setUsuario(usuario);
		dto.setSenha(senha);
		
		UsuarioDAO dao = new UsuarioDAO();
		isValido = dao.validarUsuario(dto);
			
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		
		return isValido;
	}

}
