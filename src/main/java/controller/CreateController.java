package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;


@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Usuario usuario = new Usuario();		
	
		usuario.setNome(req.getParameter("nome"));
		usuario.setSobrenome(req.getParameter("sobrenome"));
		usuario.setEmail (req.getParameter("email"));
		usuario.setCelular(req.getParameter("celular"));
		usuario.setSenha (req.getParameter("senha"));
		
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.createUsuario(usuario);
			
			
			res.sendRedirect("ReadController");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

}