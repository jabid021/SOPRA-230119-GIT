package servletNAZE;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import model.Adresse;
import model.Enfant;

@WebServlet("/home")
public class Home extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//response.getWriter().println();
		Integer id =Integer.parseInt(request.getParameter("id"));
		Enfant enfant = Singleton.getInstance().getDaoEnfant().findById(id);
		
		response.getWriter().println("<html>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Fiche de l'enfant "+id+"</h1>");
		response.getWriter().println("<table border>");
		response.getWriter().println("<tr><th>Nom</th><th>Prénom</th><th>Mechant ?</th><th>Adresse</th></tr>");
		response.getWriter().println("<tr><th>"+enfant.getNom()+"</th><th>"+enfant.getPrenom()+"</th><th>"+enfant.isMechant()+"</th><th>"+enfant.getAdresse()+"</th></tr>");
		response.getWriter().println("</table>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		boolean isMechant = (request.getParameter("mechant").equals("oui"))?true:false;
		String numero=request.getParameter("numero");
		String voie=request.getParameter("voie");
		String ville=request.getParameter("ville");
		String cp=request.getParameter("cp");
		
		Adresse a = new Adresse(numero,voie,ville,cp);
		Enfant e = new Enfant(nom,prenom,isMechant,a);
		
		e=Singleton.getInstance().getDaoEnfant().save(e);
		
		
		response.sendRedirect("home?id="+e.getId());
		
	}

}
