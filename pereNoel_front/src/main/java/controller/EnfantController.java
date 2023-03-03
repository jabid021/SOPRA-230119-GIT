package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import model.Adresse;
import model.Enfant;

@WebServlet("/enfant")
public class EnfantController extends HttpServlet {
	
	//GET :
		//findAll => PAS D'ID
		//findById => ID
		//delete => ID + delete
	//POST : 
		//insert => PAS D'ID
		//update => ID
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//findALL
		if(request.getParameter("id")==null) 
		{	
			List<Enfant> enfants = Singleton.getInstance().getDaoEnfant().findAll();
			request.setAttribute("enfants", enfants);
			this.getServletContext().getRequestDispatcher("/WEB-INF/enfants.jsp").forward(request, response);
		}
		else 
		{
			//findById
			if(request.getParameter("delete")==null) 
			{
				
				Integer id =Integer.parseInt(request.getParameter("id"));
				Enfant e1 = Singleton.getInstance().getDaoEnfant().findById(id);
				request.setAttribute("enfant", e1);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateEnfant.jsp").forward(request, response);
			}
			//delete
			else 
			{
				Integer id =Integer.parseInt(request.getParameter("id"));
				Singleton.getInstance().getDaoEnfant().delete(id);
				response.sendRedirect("enfant");
			}
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//INSERT
		if(request.getParameter("id")==null) 
		{
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			boolean isMechant = (request.getParameter("mechant").equals("oui"))?true:false;
			String numero=request.getParameter("numero");
			String voie=request.getParameter("voie");
			String ville=request.getParameter("ville");
			String cp=request.getParameter("cp");
			
			Adresse a = new Adresse(numero,voie,ville,cp);
			Enfant e = new Enfant(nom,prenom,isMechant,a);
			
			Singleton.getInstance().getDaoEnfant().save(e);
			response.sendRedirect("enfant");
		}
		//UPDATE
		else 
		{
			Integer id =Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			boolean isMechant = (request.getParameter("mechant").equals("oui"))?true:false;
			String numero=request.getParameter("numero");
			String voie=request.getParameter("voie");
			String ville=request.getParameter("ville");
			String cp=request.getParameter("cp");
			
			Adresse a = new Adresse(numero,voie,ville,cp);
			Enfant e = new Enfant(id,nom,prenom,isMechant,a);
			
			Singleton.getInstance().getDaoEnfant().save(e);
			response.sendRedirect("enfant");
		}
	}

}
