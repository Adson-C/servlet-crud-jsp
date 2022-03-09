package br.adsweb.bo;

import java.util.HashMap;
import java.util.Map;

import br.adsweb.dao.UsuarioDAO;
import br.adsweb.dto.UsuarioDTO;
import br.adsweb.exception.NegocioException;
import br.adsweb.validator.LoginValidator;

// Class responsav�l para os metodos de neg�cios da aplica��o de Usuarios

public class UsuarioBO {
	
	public boolean validarUsuario(UsuarioDTO dto) throws NegocioException {
		
		boolean isValido = true;
		
		try {
		
		// valida Campos obrigat�rios
		Map<String, Object> valores = new HashMap<>();
		valores.put("Usu�rios", dto.getUsuario());
		valores.put("Senha", dto.getSenha());
		if (new LoginValidator().validar(valores)) {
			
			isValido = true;
		}
		
		UsuarioDAO dao = new UsuarioDAO();
		isValido = dao.validarUsuario(dto);
					
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		
		return isValido;
	}

}
