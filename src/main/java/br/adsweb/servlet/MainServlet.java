package br.adsweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.adsweb.bo.UsuarioBO;
import br.adsweb.exception.NegocioException;

@WebServlet("/main" )
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acao = req.getParameter("acao");
		
		String prox = null;
		if ("sair".equals(acao)) {
			prox = "logout.jsp";
			
		} else if ("login".equals(acao)) {
			try {
				
				prox = "index.jsp";
				
				if (!new UsuarioBO().validarUsuario(req)) {
					req.setAttribute("msgErro", "Usuário/Senha inválido!");
					prox = "login.jsp";
				}
				
			} catch (NegocioException e) {
				req.setAttribute("msgErro", e.getMessage());
				
				prox = "login.jsp";
			}
			
		} else if ("consultas".equals(acao)) {
			prox = "consultas.jsp";
		}
		req.getRequestDispatcher(prox).forward(req, resp);
	}
	
	

}
