package br.adsweb.command;

import javax.servlet.http.HttpServletRequest;

import br.adsweb.exception.NegocioException;

//interface para padr�o commnad

public interface Command {

	// metodo de execu��o
	public String execute(HttpServletRequest req) throws NegocioException;
		

}
