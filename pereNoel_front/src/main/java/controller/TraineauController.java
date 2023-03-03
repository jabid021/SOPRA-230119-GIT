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
import model.Traineau;

@WebServlet("/traineau")
public class TraineauController extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//findALL
		if(request.getParameter("id")==null) 
		{	
			List<Traineau> traineaux = Singleton.getInstance().getDaoTraineau().findAll();
			request.setAttribute("traineaux", traineaux);
			this.getServletContext().getRequestDispatcher("/traineaux.jsp").forward(request, response);
		}
		else 
		{
			//findById
			if(request.getParameter("delete")==null) 
			{
				
				Integer id =Integer.parseInt(request.getParameter("id"));
				Traineau t1 = Singleton.getInstance().getDaoTraineau().findById(id);
				request.setAttribute("traineau", t1);
				this.getServletContext().getRequestDispatcher("/updateTraineau.jsp").forward(request, response);
			}
			//delete
			else 
			{
				Integer id =Integer.parseInt(request.getParameter("id"));
				Singleton.getInstance().getDaoTraineau().delete(id);
				response.sendRedirect("traineau");
			}
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//INSERT
		if(request.getParameter("id")==null) 
		{
			int autonomie = Integer.parseInt(request.getParameter("autonomie"));
			int clochettes = Integer.parseInt(request.getParameter("clochettes"));
			double poids = Double.parseDouble(request.getParameter("poids"));
			
			Traineau t = new Traineau(autonomie,clochettes,poids);
			
			Singleton.getInstance().getDaoTraineau().save(t);
			response.sendRedirect("traineau");
		}
		//UPDATE
		else 
		{
			Integer id =Integer.parseInt(request.getParameter("id"));
			int autonomie = Integer.parseInt(request.getParameter("autonomie"));
			int clochettes = Integer.parseInt(request.getParameter("clochettes"));
			double poids = Double.parseDouble(request.getParameter("poids"));
			
			Traineau t = new Traineau(autonomie,clochettes,poids);
			t.setId(id);
			
			Singleton.getInstance().getDaoTraineau().save(t);
			response.sendRedirect("traineau");
		}
	}

}
