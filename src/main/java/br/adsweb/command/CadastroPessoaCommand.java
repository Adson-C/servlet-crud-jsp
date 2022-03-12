package br.adsweb.command;

import javax.servlet.http.HttpServletRequest;

import br.adsweb.dao.CadastroDAO;

public class CadastroPessoaCommand  implements Command {
	
	private String prox;
	
	private CadastroDAO cadastroDAO;
	
	public String execute(HttpServletRequest req)   {
		
		cadastroDAO = new CadastroDAO();
		prox = "cadastroPessoa.jsp";
		
		
		
		/*
		 * try {
		 * 
		 * 
		 * } catch (PersistenciaException e) { req.setAttribute("msgErro",
		 * e.getMessage()); }
		 */
		
		return prox;
	}
	

}
