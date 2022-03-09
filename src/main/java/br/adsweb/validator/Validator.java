package br.adsweb.validator;


import java.util.Map;


 // Responsável por validar todo os tipos de valores do sistema

public interface Validator {
	
	
	 // Método efetivo de validação que recebe o mapa com os valores e os nomes
	 
	public boolean validar(Map<String, Object> valores) throws br.adsweb.exception.ValidationException;

}
