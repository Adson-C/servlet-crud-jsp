package br.adsweb.exception;

// Encapsular todas as exceções de banco de dados

public class PersistenciaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	public PersistenciaException(String erro) {
		super(erro);
	}
	
	public PersistenciaException(Exception e ) {
		super(e.getMessage());
	}
	
	public PersistenciaException(String erro, Exception e ) {
		super(erro, e);
	}

}
