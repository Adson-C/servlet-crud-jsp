package br.adsweb.validator;


import java.util.Map;


 // Respons�vel por validar todo os tipos de valores do sistema

public interface Validator {
	
	
	 // M�todo efetivo de valida��o que recebe o mapa com os valores e os nomes
	 
	public boolean validar(Map<String, Object> valores) throws br.adsweb.exception.ValidationException;

}
