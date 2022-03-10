package br.adsweb.command;

import javax.servlet.http.HttpServletRequest;

import br.adsweb.dao.CadastroDAO;
import br.adsweb.exception.PersistenciaException;

public class CadastroCommand  implements Command {
	
	private String prox;
	
	private CadastroDAO cadastroDAO;
	
	public String execute(HttpServletRequest req)   {
		
		cadastroDAO = new CadastroDAO();
		prox = "cadastro.jsp";
		
		try {
			req.setAttribute("listEstados", cadastroDAO.listEstados());
		} catch (PersistenciaException e) {
			req.setAttribute("msgErro", e.getMessage());
		}
		
		return prox;
	}
	

}