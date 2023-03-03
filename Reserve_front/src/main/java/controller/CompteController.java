package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import model.Admin;
import model.Adresse;
import model.Client;
import model.Compte;
import model.Ranger;

@WebServlet("/compte")
public class CompteController extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//findALL
		if(request.getParameter("id")==null) 
		{	
			List<Compte> comptes = Singleton.getInstance().getDaoCompte().findAll();
			request.setAttribute("comptes", comptes);
			this.getServletContext().getRequestDispatcher("/WEB-INF/comptes.jsp").forward(request, response);
		}
		else 
		{
			//findById
			if(request.getParameter("delete")==null) 
			{
				
				Integer id =Integer.parseInt(request.getParameter("id"));
				Compte c1 = Singleton.getInstance().getDaoCompte().findById(id);
				request.setAttribute("compte", c1);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateCompte.jsp").forward(request, response);
			}
			//delete
			else 
			{
				Integer id =Integer.parseInt(request.getParameter("id"));
				Singleton.getInstance().getDaoCompte().delete(id);
				response.sendRedirect("compte");
			}
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//INSERT
		if(request.getParameter("id")==null) 
		{
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			Compte c=null;
			if(request.getParameter("typeCompte").equals("Ranger")) 
			{
				Integer anciennete = Integer.parseInt(request.getParameter("anciennete"));
				c = new Ranger(login,password,nom,prenom,anciennete);
			}
			else if(request.getParameter("typeCompte").equals("Client")) 
			{
				String numero = request.getParameter("numero");
				String voie = request.getParameter("voie");
				String ville = request.getParameter("ville");
				String cp = request.getParameter("cp");
				String pays = request.getParameter("pays");
				Adresse adresse = new Adresse(numero,voie,ville,cp,pays);
				c = new Client(login,password,nom,prenom,adresse);
			}
			else
			{
				c = new Admin(login,password,nom,prenom);
			}
			
			Singleton.getInstance().getDaoCompte().save(c);
			response.sendRedirect("compte");
		}
		//UPDATE
		else 
		{
			Integer id =Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			Compte c=null;
			if(request.getParameter("typeCompte").equals("Ranger")) 
			{
				Integer anciennete = Integer.parseInt(request.getParameter("anciennete"));
				c = new Ranger(id,login,password,nom,prenom,anciennete);
			}
			else if(request.getParameter("typeCompte").equals("Client")) 
			{
				String numero = request.getParameter("numero");
				String voie = request.getParameter("voie");
				String ville = request.getParameter("ville");
				String cp = request.getParameter("cp");
				String pays = request.getParameter("pays");
				Adresse adresse = new Adresse(numero,voie,ville,cp,pays);
				c = new Client(id,login,password,nom,prenom,adresse);
			}
			else
			{
				c = new Admin(id,login,password,nom,prenom);
			}
			
			Singleton.getInstance().getDaoCompte().save(c);
			response.sendRedirect("compte");
		}
	}
}
