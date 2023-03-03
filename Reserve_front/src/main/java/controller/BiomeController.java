package controller;

import java.io.IOException;
import java.time.LocalDate;
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
import model.Biome;
import model.Ranger;
import model.Zone;

@WebServlet("/biome")
public class BiomeController extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//findALL
		if(request.getParameter("id")==null) 
		{	
			List<Biome> biomes = Singleton.getInstance().getDaoBiome().findAll();
			Zone tab[] = Zone.values();
			request.setAttribute("zones", tab);
			request.setAttribute("biomes", biomes);
			this.getServletContext().getRequestDispatcher("/WEB-INF/biomes.jsp").forward(request, response);
		}
		else 
		{
			//findById
			if(request.getParameter("delete")==null) 
			{
				
				Integer id =Integer.parseInt(request.getParameter("id"));
				Biome b1 = Singleton.getInstance().getDaoBiome().findById(id);
				Zone tab[] = Zone.values();
				request.setAttribute("zones", tab);
				request.setAttribute("biome", b1);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateBiome.jsp").forward(request, response);
			}
			//delete
			else 
			{
				Integer id =Integer.parseInt(request.getParameter("id"));
				Singleton.getInstance().getDaoBiome().delete(id);
				response.sendRedirect("biome");
			}
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//INSERT
		if(request.getParameter("id")==null) 
		{
			String nom = request.getParameter("nom");
			int superficie = Integer.parseInt(request.getParameter("superficie"));
			
			Zone zone = Zone.valueOf(request.getParameter("zone"));
		
			
			Biome b = new Biome(nom, superficie, zone);
			
			Singleton.getInstance().getDaoBiome().save(b);
			response.sendRedirect("biome");
		}
		//UPDATE
		else 
		{
			Integer id =Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			int superficie = Integer.parseInt(request.getParameter("superficie"));
			Zone zone = Zone.valueOf(request.getParameter("zone"));
		
			
			Biome b = new Biome(id,nom, superficie, zone);
			
			Singleton.getInstance().getDaoBiome().save(b);
			response.sendRedirect("biome");
		}
	}

}
