<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<base href="/formation-spring-web/" />
<meta charset="UTF-8" />
<title>Liste des fournisseurs</title>
</head>
<body>
	<a href="fournisseur/ajouter">Ajouter un nouveau fournisseur</a>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${ fournisseurs }" var="fournisseur">
				<tr>
					<td>${ fournisseur.id }</td>
					<td>${ fournisseur.nom }</td>
					<td>
						[<a href="fournisseur/modifier/${ fournisseur.id }">Modifier</a>]
						[<a href="fournisseur/supprimer/${ fournisseur.id }">Supprimer</a>]
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>