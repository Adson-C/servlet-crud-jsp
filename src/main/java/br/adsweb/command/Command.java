package br.adsweb.command;

import javax.servlet.http.HttpServletRequest;

import br.adsweb.exception.NegocioException;

//interface para padrão commnad

public interface Command {

	// metodo de execução
	public String execute(HttpServletRequest req) throws NegocioException;
		

}
