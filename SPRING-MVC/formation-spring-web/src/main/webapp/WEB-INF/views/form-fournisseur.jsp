<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Ajouter un fournisseur</title>
</head>
<body>
	<form method="POST">
		<div>
			<label>Nom :</label>
			<input type="text" name="nom" value="${ fournisseur.nom }" />
			<div>${ error.getFieldError("nom").defaultMessage }</div>
		</div>
		
		<div>
			<c:if test="${ fournisseur == null }">
				<input type="submit" value="Ajouter" />
			</c:if>
			
			<c:if test="${ fournisseur != null }">
				<input type="submit" value="Modifier" />
			</c:if>
		</div>
	</form>
	
</body>
</html>