package br.adsweb.bo;

import java.util.HashMap;
import java.util.Map;

import br.adsweb.dao.UsuarioDAO;
import br.adsweb.dto.UsuarioDTO;
import br.adsweb.exception.NegocioException;
import br.adsweb.util.MensagemContantes;
import br.adsweb.validator.LoginValidator;

// Class responsavél para os metodos de negócios da aplicação de Usuarios

public class UsuarioBO {
	
	public boolean validarUsuario(UsuarioDTO dto) throws NegocioException {
		
		boolean isValido = true;
		
		try {
		
		// valida Campos obrigatórios
		Map<String, Object> valores = new HashMap<>();
		valores.put("Usuários", dto.getUsuario());
		valores.put("Senha", dto.getSenha());
		if (new LoginValidator().validar(valores)) {
			
			isValido = true;
		}
		
		UsuarioDAO dao = new UsuarioDAO();
		isValido = dao.validarUsuario(dto);
		if (!isValido) {
			throw new NegocioException(MensagemContantes.MSG_ERR_USUARIO_SENHA_INVALIDOS);
		}
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		
		return isValido;
	}

}
