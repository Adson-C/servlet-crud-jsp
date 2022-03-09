package br.adsweb.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.adsweb.command.Command;
import br.adsweb.command.LoginCommand;

@WebServlet("/main" )
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Command> comandos = new HashMap<String, Command>();
	
	@Override
	public void init() throws ServletException {
		comandos.put("login", new LoginCommand());
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String acao = req.getParameter("acao");
		String prox = null;
		
		try {
		
		Command comando = verificarCommand(acao);
			prox = comando.execute(req);				
				
			} catch (Exception e) {
				req.setAttribute("msgErro", e.getMessage());
				
			}
			
		req.getRequestDispatcher(prox).forward(req, resp);
	}
	
	private Command verificarCommand(String acao) {
		Command comando = null;
		for (String key : comandos.keySet()) {
			if (key.equalsIgnoreCase(acao)) {
				comando = comandos.get(key);
			}
		}
		return comando;
	}

}
