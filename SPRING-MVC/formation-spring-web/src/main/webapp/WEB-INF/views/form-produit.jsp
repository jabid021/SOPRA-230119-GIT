<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<div>${ error.getFieldError("libelle").defaultMessage }</div>
		</div>
		
		<div>
			<label>Prix :</label>
			<input type="number" name="prix" value="${ produit.prix }" />
			<div>${ error.getFieldError("prix").defaultMessage }</div>
		</div>
		
		<div>
			<label>Fournisseur :</label>
			
			<select name="fournisseurId">
				<c:forEach items="${ fournisseurs }" var="fournisseur">
					<c:if test="${ fournisseur.id == produit.fournisseur.id }">
						<option selected value="${ fournisseur.id }">${ fournisseur.nom }</option>
					</c:if>
					
					<c:if test="${ fournisseur.id != produit.fournisseur.id }">
						<option value="${ fournisseur.id }">${ fournisseur.nom }</option>
					</c:if>			
				</c:forEach>
			</select>
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