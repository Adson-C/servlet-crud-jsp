package br.adsweb.command;

import javax.servlet.http.HttpServletRequest;

import br.adsweb.bo.UsuarioBO;
import br.adsweb.dto.UsuarioDTO;
import br.adsweb.exception.NegocioException;

public class LoginCommand  implements Command {
	
	private UsuarioBO usuarioBO;
	
	private String prox;
	
	public String execute(HttpServletRequest req)  {
		prox = "login.jsp";
		
		usuarioBO = new UsuarioBO();
		
		String usuario = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setUsuario(usuario);
		dto.setSenha(senha);
		
		try {
			if (usuarioBO.validarUsuario(dto)) {
				
				prox = "index.jsp";
			}
		} catch (NegocioException e) {
			e.printStackTrace();
			req.setAttribute("msgErro", e.getMessage());
		}
		
		req.getSession().setAttribute("usuario", dto);
		return prox;
	}
	

}
