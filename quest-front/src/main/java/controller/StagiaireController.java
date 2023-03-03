package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import model.Filiere;
import model.Stagiaire;


@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//findALL
		if(request.getParameter("id")==null) 
		{	
			List<Stagiaire> stagiaires = Singleton.getInstance().getDaoStagiaire().findAll();
			List<Filiere> filieres = Singleton.getInstance().getDaoFiliere().findAll();
			request.setAttribute("stagiaires", stagiaires);
			request.setAttribute("filieres", filieres);
			this.getServletContext().getRequestDispatcher("/WEB-INF/stagiaires.jsp").forward(request, response);
		}
		else 
		{
			//findById
			if(request.getParameter("delete")==null) 
			{
				
				Integer id =Integer.parseInt(request.getParameter("id"));
				Stagiaire s1 = Singleton.getInstance().getDaoStagiaire().findById(id);
				List<Filiere> filieres = Singleton.getInstance().getDaoFiliere().findAll();
				request.setAttribute("stagiaire", s1);
				request.setAttribute("filieres", filieres);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateStagiaire.jsp").forward(request, response);
			}
			//delete
			else 
			{
				Integer id =Integer.parseInt(request.getParameter("id"));
				Singleton.getInstance().getDaoStagiaire().delete(id);
				response.sendRedirect("stagiaire");
			}
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//INSERT
		if(request.getParameter("id")==null) 
		{
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere"));
			Filiere f = Singleton.getInstance().getDaoFiliere().findById(idFiliere);
		
			
			Stagiaire e = new Stagiaire(nom,prenom,email,f);
			
			Singleton.getInstance().getDaoStagiaire().save(e);
			response.sendRedirect("stagiaire");
		}
		//UPDATE
		else 
		{
			Integer id =Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere"));
			Filiere f = Singleton.getInstance().getDaoFiliere().findById(idFiliere);
		
			
			Stagiaire e = new Stagiaire(id,nom,prenom,email,f);
			Singleton.getInstance().getDaoStagiaire().save(e);
			response.sendRedirect("stagiaire");
		}
	}
}
