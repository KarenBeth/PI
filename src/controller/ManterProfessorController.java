package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Professor;
import service.ProfessorService;

@WebServlet("/ManterProfessor.do")
public class ManterProfessorController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 @see HttpServlet#doGet(HttpServletRequest request, HttpServletReponse reponse)
	 */
	
	protected void doGet(HttpSevletRequest request, HttpServletReponse reponse) throws ServletException, IOException {
		do Post(request, response);
	}

	/**
	 * 
	 @see HttpServlet#doGet(HttpServletRequest request, HttpServletReponse reponse)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Nome = request.getParameter("nome");
		String Matricula = request.getParameter("matricula");
		String Email = request.getParameter("email");
		String Senha = request.getParameter("senha");
		
		
		Professor professor = new Professor(Email, Senha);
			professor.setNome(Nome);
			professor.setMatricula(Matricula);
			professor.setEmail(Email);
			professor.setSenha(Senha);
			
		ProfessorService pf = new ProfessorService();
			pf.update(professor);
			professor = pf.load(professor.getId());
		
		request.setAttribute("professor", professor);
			
		RequestDispatcher view = 
		request.getRequestDispatcher("Professor.jsp");
		view.forward(request,response);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Usuario</title></head><body>");
						
		out.println(	"nome: "+professor.getNome()+"<br>");
		out.println("matricula: " +professor.getMatricula()+"<br>");
		out.println("email:" +professor.getEmail()+"<br>");
			
			out.println(	"populacao: "+professor.getSenha()+"<br>");
			 
		   out.println("</body></html>");
		
	}
	
}
