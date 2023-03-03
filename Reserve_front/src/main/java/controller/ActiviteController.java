package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import model.Activite;
import model.Biome;
import model.Scientifique;
import model.Tourisme;
import model.Vehicule;


@WebServlet("/activite")

public class ActiviteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//findALL
		if(request.getParameter("id")==null) 
		{	
			List<Activite> activites = Singleton.getInstance().getDaoActivite().findAll();
			List<Biome> biomes = Singleton.getInstance().getDaoBiome().findAll();
			request.setAttribute("activites", activites);
			request.setAttribute("biomes", biomes);
			request.setAttribute("vehicules", Vehicule.values());
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/activites.jsp").forward(request, response);
		}
		else 
		{
			//findById
			if(request.getParameter("delete")==null) 
			{

				Integer id =Integer.parseInt(request.getParameter("id"));
				Activite a1 = Singleton.getInstance().getDaoActivite().findById(id);
				List<Biome> biomes = Singleton.getInstance().getDaoBiome().findAll();
				request.setAttribute("activite", a1);
				request.setAttribute("biomes", biomes);
				request.setAttribute("vehicules", Vehicule.values());
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateActivite.jsp").forward(request, response);
			}
			//delete
			else 
			{
				Integer id =Integer.parseInt(request.getParameter("id"));
				Singleton.getInstance().getDaoActivite().delete(id);
				response.sendRedirect("activite");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		//INSERT
		if(request.getParameter("id")==null) 
		{
			Integer idBiome = Integer.parseInt(request.getParameter("biome"));
			Integer duree = Integer.parseInt(request.getParameter("duree"));
			boolean guide = (request.getParameter("guide").equals("oui"))?true:false;
			Double prix = Double.parseDouble(request.getParameter("prix"));
			Vehicule vehicule = Vehicule.valueOf(request.getParameter("vehicule"));
			Biome biome = Singleton.getInstance().getDaoBiome().findById(idBiome);
			
			Activite a = null;
			
			if(request.getParameter("typeActivite").equals("Tourisme"))
			{
				a = new Tourisme(guide, prix, duree, biome, vehicule);
			}
			if(request.getParameter("typeActivite").equals("Scientifique"))
			{
				a = new Scientifique(guide, prix, duree, biome, vehicule);
			}			
				

			Singleton.getInstance().getDaoActivite().save(a);
			response.sendRedirect("activite");
		}
		//UPDATE
		else 
		{
			Integer id =Integer.parseInt(request.getParameter("id"));
			Integer idBiome = Integer.parseInt(request.getParameter("biome"));
			Integer duree = Integer.parseInt(request.getParameter("duree"));
			boolean guide = (request.getParameter("guide").equals("oui"))?true:false;
			Double prix = Double.parseDouble(request.getParameter("prix"));
			Vehicule vehicule = Vehicule.valueOf(request.getParameter("vehicule"));
			Biome biome = Singleton.getInstance().getDaoBiome().findById(idBiome);
			
			Activite a = null;

			if(request.getParameter("typeActivite").equals("Tourisme"))
			{
				a = new Tourisme(id, guide, prix, duree, biome, vehicule);
			}
			if(request.getParameter("typeActivite").equals("Scientifique"))
			{
				a = new Scientifique(id, guide, prix, duree, biome, vehicule);
			}			
				

			Singleton.getInstance().getDaoActivite().save(a);
			response.sendRedirect("activite");
		}
	}
}