package br.adsweb.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.adsweb.dao.CadastroDAO;
import br.adsweb.dto.CidaddeDTO;
import br.adsweb.dto.EstadoDTO;
import br.adsweb.exception.PersistenciaException;

public class CadastroCommand  implements Command {
	
	private String prox;
	
	private CadastroDAO cadastroDAO;
	
	public String execute(HttpServletRequest req)   {
		
		cadastroDAO = new CadastroDAO();
		prox = "cadastro.jsp";
		
		String getcidades = req.getParameter("getCidades");
		
		try {
			if (getcidades != null && !"".equals(getcidades)) {
				
				String id = req.getParameter("idEstado");
				int idEstado = Integer.parseInt(id);
				
				List<CidaddeDTO> listaCidades = cadastroDAO.consultarCidadePorEstados(idEstado);
				req.setAttribute("listaCidades", listaCidades );
			}
			else {
				
				List<EstadoDTO> listEstados = cadastroDAO.listEstados();
				req.getSession().setAttribute("listEstados", listEstados);
			}
			
		} catch (PersistenciaException e) {
			req.setAttribute("msgErro", e.getMessage());
		}
		
		return prox;
	}
	

}
