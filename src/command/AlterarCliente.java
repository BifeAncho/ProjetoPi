package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

public class AlterarCliente implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pIdCliente = request.getParameter("idCliente");
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		String pCpf = request.getParameter("cpf");
		String pEndereco = request.getParameter("endereco");
		String pPais = request.getParameter("pais");
		String pEstado = request.getParameter("estado");
		String pCep = request.getParameter("cep");
		String pFone = request.getParameter("fone");
		String pNotificacao = request.getParameter("notificacao");
		String pBairro = request.getParameter("bairro");
		String pNumero = request.getParameter("numero");
		String pComplemento = request.getParameter("complemento");
		int idCliente = 1;
		
		try {
			idCliente = Integer.parseInt(pIdCliente);
		}catch (NumberFormatException e) {
			
		}
		
		Cliente cliente = new Cliente();
		cliente.setIdCliente(idCliente);
		cliente.setNome(pNome); 
		cliente.setEmail(pEmail);
		cliente.setSenha(pSenha);
		cliente.setCpf(pCpf);
		cliente.setEndereco(pEndereco);
		cliente.setPais(pPais);
		cliente.setEstado(pEstado);
		cliente.setCep(pCep);
		cliente.setFone(pFone);
		cliente.setNotificacao(pNotificacao);
		cliente.setBairro(pBairro);
		cliente.setNumero(pNumero);
		cliente.setComplemento(pComplemento);	
		
		ClienteService cs = new ClienteService();
		RequestDispatcher view = null;
		
		cs.atualizar(cliente);
		request.setAttribute("cliente", cliente);
		request.setAttribute("alterCli", "Cliente alterado");
		view = request.getRequestDispatcher("VisualizarCliente.jsp");
		view.forward(request, response);
	}

	public int busca(Cliente cliente, ArrayList<Cliente> lista) {
		Cliente to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getIdCliente() == cliente.getIdCliente()) {

				return i;
			}
		}
		return -1;
	} 
}
