<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Liste des produist</title>
</head>
<body>
	<a href="ajouter">Ajouter un nouveau produit</a>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Libellé</th>
				<th>Prix</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${ produits }" var="produit">
				<tr>
					<td>${ produit.id }</td>
					<td>${ produit.libelle }</td>
					<td>${ produit.prix }</td>
					<td>?</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>