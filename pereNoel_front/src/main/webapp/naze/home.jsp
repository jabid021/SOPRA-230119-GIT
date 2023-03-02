<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Enfant" %>	
<%@ page import="context.Singleton" %>	
<%@ page import="java.util.List" %>	
<%
try {
	Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
	//Integer id =Integer.parseInt(request.getParameter("id"));
	//Enfant enfant = Singleton.getInstance().getDaoEnfant().findById(id);
	
	List<Enfant> enfants = Singleton.getInstance().getDaoEnfant().findAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tableau enfants</title>
</head>
<body>



	<h1>Fiche de l'enfant 1</h1>

	<table border>
		<tr>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Mechant ?</th>
			<th>Adresse</th>
		</tr>
		
		<%
		
		for(Enfant enfant : enfants)
		{
			out.println("<tr><td>"+enfant.getNom()+"</td><td>"+enfant.getPrenom()+"</td><td>"+enfant.isMechant()+"</td><td>"+enfant.getAdresse()+"</td></tr>");
		}		
		%>
		
	</table>


</body>
</html>


Model Vue Controller