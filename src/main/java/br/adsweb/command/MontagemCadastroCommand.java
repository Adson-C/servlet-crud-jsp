package br.adsweb.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.adsweb.dao.CadastroDAO;
import br.adsweb.dto.CidadeDTO;
import br.adsweb.dto.EstadoDTO;
import br.adsweb.dto.PrefereciaMusicalDTO;
import br.adsweb.exception.PersistenciaException;

public class MontagemCadastroCommand  implements Command {
	
	private String prox;
	
	private CadastroDAO cadastroDAO;
	
	public String execute(HttpServletRequest req)   {
		
		cadastroDAO = new CadastroDAO();
		prox = "cadastroPessoa.jsp";
		
		String getcidades = req.getParameter("getCidades");
		
		try {
			if (getcidades != null && !"".equals(getcidades)) {
				
				String id = req.getParameter("idEstado");
				int idEstado = Integer.parseInt(id);
				
				List<CidadeDTO> listaCidades = cadastroDAO.consultarCidadePorEstados(idEstado);
				req.setAttribute("listaCidades", listaCidades );
			}
			else {
				
				List<EstadoDTO> listEstados = cadastroDAO.listEstados();
				List<PrefereciaMusicalDTO> listarPreferencias = cadastroDAO.listarPreferencias();
				req.getSession().setAttribute("listEstados", listEstados);
				req.getSession().setAttribute("listarPreferencias", listarPreferencias);
			}
			
		} catch (PersistenciaException e) {
			req.setAttribute("msgErro", e.getMessage());
		}
		
		return prox;
	}
	

}
