<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<base href="/formation-spring-web/" />
<meta charset="UTF-8" />
<title>Liste des produits</title>
</head>
<body>
	<a href="produit/ajouter">Ajouter un nouveau produit</a>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Libell?</th>
				<th>Prix</th>
				<th>Fournisseur</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${ produits }" var="produit">
				<tr>
					<td>${ produit.id }</td>
					<td>${ produit.libelle }</td>
					<td>${ produit.prix }</td>
					<td>${ produit.fournisseur.nom }</td>
					<td>
						[<a href="produit/modifier/${ produit.id }">Modifier</a>]
						[<a href="produit/supprimer?id=${ produit.id }">Supprimer</a>]
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>