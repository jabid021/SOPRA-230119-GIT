<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Ajouter un produit</title>
</head>
<body>
	${ erreur }
	
	<form method="POST">
		<div>
			<label>Libellé :</label>
			<input type="text" name="libelle" value="${ produit.libelle }" />
		</div>
		
		<div>
			<label>Prix :</label>
			<input type="number" name="prix" value="${ produit.prix }" />
		</div>
		
		<div>
			<c:if test="${ produit == null }">
				<input type="submit" value="Ajouter" />
			</c:if>
			
			<c:if test="${ produit != null }">
				<input type="submit" value="Modifier" />
			</c:if>
		</div>
	</form>
	
</body>
</html>