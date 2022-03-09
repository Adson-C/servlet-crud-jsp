package br.adsweb.command;

import javax.servlet.http.HttpServletRequest;

//interface para padrão commnad

public interface Command {

	// metodo de execução
	public String execute(HttpServletRequest req);
		

}
