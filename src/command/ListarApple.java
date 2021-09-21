package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Produto;
import service.ProdutoService;

public class ListarApple implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ProdutoService ps = new ProdutoService();
		ArrayList<Produto> lista = null;
		HttpSession session = request.getSession();
		
		lista = ps.listarApple();
			
			
			session.setAttribute("lista", lista);
			
			
		RequestDispatcher dispatcher = request
		.getRequestDispatcher("TelaApple.jsp");
		dispatcher.forward(request, response);

	}
}


