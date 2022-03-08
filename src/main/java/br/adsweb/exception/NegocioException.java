package br.adsweb.exception;

// Class resposnsavél camada de negócios

public class NegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	
	public NegocioException(Exception e) {
		super(e);
	}
	
}
