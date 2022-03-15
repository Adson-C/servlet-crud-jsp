package br.adsweb.bo;

import java.util.HashMap;
import java.util.Map;

import br.adsweb.dto.CidadeDTO;
import br.adsweb.dto.PessoaDTO;
import br.adsweb.exception.NegocioException;
import br.adsweb.util.MensagemContantes;
import br.adsweb.validator.CPFValidator;
import br.adsweb.validator.DataValidator;

// Class responsavél para os metodos de negócios da aplicação Pessoas

public class PessoaBO {
	
	public boolean validarPessoa(PessoaDTO pessoaDTO) throws NegocioException {
		
		boolean isValido = true;
		
		try {
			
			if (pessoaDTO.getNome() == null || "".equals(pessoaDTO.getNome())) {
				throw new NegocioException(MensagemContantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", "Nome"));
			}
			
		
		// valida Campos obrigatórios
		Map<String, Object> valores = new HashMap<>();
		valores.put("CPF", pessoaDTO.getCpf());
		if (new CPFValidator().validar(valores)) {
			
			isValido = true;
		}
		
		valores = new HashMap<>();
		valores.put("Dat.Nasc", pessoaDTO.getDtNasc());
		if (new DataValidator().validar(valores)) {
			
			isValido = true;
		}
		
		if (pessoaDTO.getSexo() == ' ' ) {
			throw new NegocioException(MensagemContantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", "Sexo"));
		}
		
		CidadeDTO cidade = pessoaDTO.getEndereco().getCidade();
		if (cidade.getEstado().getId_uf() == null || cidade.getEstado().getId_uf() == 0) {
			throw new NegocioException(MensagemContantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", "Estado"));	
		}
			
		if (cidade.getIdCidade() == null || cidade.getIdCidade() == 0) {
			throw new NegocioException(MensagemContantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", "Cidcade"));
		}
			
		if (pessoaDTO.getEndereco().getLogradouro() == null || "".equals(pessoaDTO.getEndereco().getLogradouro())) {
				throw new NegocioException(MensagemContantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", "Logradouro"));
		
		}
		
		if (!isValido) {
			throw new NegocioException(MensagemContantes.MSG_ERR_PESSOA_DADOS_INVALIDOS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		
		return isValido;
	}
}
