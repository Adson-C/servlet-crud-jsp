package br.adsweb.exception;

// Class resposnsav�l camada de neg�cios

public class NegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	
	public NegocioException(Exception e) {
		super(e);
	}
	
}
