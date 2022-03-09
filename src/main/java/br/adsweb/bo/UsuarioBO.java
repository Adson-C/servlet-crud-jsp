package br.adsweb.bo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import br.adsweb.dao.UsuarioDAO;
import br.adsweb.dto.UsuarioDTO;
import br.adsweb.exception.NegocioException;
import br.adsweb.exception.ValidationException;
import br.adsweb.util.Util;
import br.adsweb.validator.LoginValidator;

// Class responsavél para os metodos de negócios da aplicação de Usuarios

public class UsuarioBO {
	
	public boolean validarUsuario(HttpServletRequest req) throws NegocioException {
		
		boolean isValido = true;
		
		try {
		
		String usuario = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setUsuario(usuario);
		dto.setSenha(senha);
		
		// valida Campos obrigatórios
		Map<String, Object> valores = new HashMap<>();
		valores.put("Usuários", usuario);
		valores.put("Senha", senha);
		if (new LoginValidator().validar(valores)) {
			
			isValido = true;
		}
		
		UsuarioDAO dao = new UsuarioDAO();
		isValido = dao.validarUsuario(dto);
		} catch (ValidationException e) {
			req.setAttribute("msgErro", Util.concatenaMensagensRequest(req, e, "msgErro"));
			
			isValido = false;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		
		return isValido;
	}

}
