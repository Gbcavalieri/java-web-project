package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;


@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		
		try {
			UsuarioDAO uDAO = new UsuarioDAO();
			Usuario usuario = uDAO.findUsuario(id);
			
			req.setAttribute("usuario", usuario);
			
			RequestDispatcher rd = req.getRequestDispatcher("atualizar.jsp");
			rd.forward(req, res);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(req.getParameter("id")));			
			usuario.setNome(req.getParameter("nome"));
			usuario.setSobrenome(req.getParameter("sobrenome"));
			usuario.setEmail(req.getParameter("email"));
			usuario.setCelular(req.getParameter("celular"));
			usuario.setSenha(req.getParameter("senha"));
			UsuarioDAO uDAO = new UsuarioDAO();
			uDAO.updateUsuario(usuario);
			
			res.sendRedirect("ReadController");
		} catch (Exception e) {
			
		}
		
		
		
		
	}

}
