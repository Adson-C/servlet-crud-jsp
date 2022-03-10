package br.adsweb.command;

import javax.servlet.http.HttpServletRequest;

public class CadastroCommand  implements Command {
	
	
	private String prox;
	
	public String execute(HttpServletRequest req)   {
		
		prox = "cadastro.jsp";
		
		return prox;
	}
	

}
