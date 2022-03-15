package br.adsweb.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.adsweb.bo.PessoaBO;
import br.adsweb.dto.CidadeDTO;
import br.adsweb.dto.EnderecoDTO;
import br.adsweb.dto.EstadoDTO;
import br.adsweb.dto.PessoaDTO;
import br.adsweb.dto.PrefereciaMusicalDTO;
import br.adsweb.util.MensagemContantes;

public class CadastroPessoaCommand  implements Command {
	
	private String prox;
	

	private PessoaBO pessoaBO;
	
	public String execute(HttpServletRequest req)   {
		
		pessoaBO = new PessoaBO();
		prox = "cadastroPessoa.jsp";
		
		
		String nome = req.getParameter("nome");
		String cpf = req.getParameter("cpf");
		String dtnasc = req.getParameter("dtnasc");
		String sexo = req.getParameter("sexo");
		String comentarios = req.getParameter("comentarios");
		String idUf = req.getParameter("uf");
		String idCidade = req.getParameter("cidade");
		String logradouro = req.getParameter("logradouro");
		
		String[] preferencias = req.getParameterValues("gostos");
		List<PrefereciaMusicalDTO> listPrefs = new ArrayList<>();
		
		if (preferencias != null) {
			
			for(String pref : preferencias) {
				PrefereciaMusicalDTO prefereciaMusical = new PrefereciaMusicalDTO();
				prefereciaMusical.setIdPreferencia(Integer.parseInt(pref));
				
				listPrefs.add(prefereciaMusical);
			}
		}
		
		try {
			
			PessoaDTO pessoaDTO = new PessoaDTO();
			pessoaDTO.setNome(nome);
			pessoaDTO.setCpf(cpf);
			pessoaDTO.setDtNasc(dtnasc);
			pessoaDTO.setCometario(comentarios);
			pessoaDTO.setSexo(sexo != null ? sexo.charAt(0) : ' ');
			pessoaDTO.setPreferencia(listPrefs);
			
			EnderecoDTO enderecoDTO = new EnderecoDTO();
			enderecoDTO.setLogradouro(logradouro);
			CidadeDTO cidadeDTO  = new CidadeDTO();
			cidadeDTO.setIdCidade(idCidade != null ? Integer.parseInt(idCidade) : null);
			
			EstadoDTO estadoDTO = new EstadoDTO();
			estadoDTO.setId_uf(idUf != null ? Integer.parseInt(idUf) : null);
			
			cidadeDTO.setEstado(estadoDTO);
			enderecoDTO.setCidade(cidadeDTO);
			pessoaDTO.setEndereco(enderecoDTO);
			
			
			 boolean isValido =  pessoaBO.validarPessoa(pessoaDTO);
			 if (!isValido) {
				 req.setAttribute("msgErro", MensagemContantes.MSG_ERR_PESSOA_DADOS_INVALIDOS);
			}
			
		} catch (Exception e) { 
			req.setAttribute("msgErro", e.getMessage()); 
			}
		
		
		return prox;
	}
	

}
