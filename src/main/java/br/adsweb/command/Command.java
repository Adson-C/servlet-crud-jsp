package br.adsweb.command;

import javax.servlet.http.HttpServletRequest;

//interface para padr�o commnad

public interface Command {

	// metodo de execu��o
	public String execute(HttpServletRequest req);
		

}
