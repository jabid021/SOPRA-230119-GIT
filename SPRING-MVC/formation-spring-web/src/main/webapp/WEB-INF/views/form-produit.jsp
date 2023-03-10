<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
			<input type="submit" value="Ajouter" />
		</div>
	</form>
	
</body>
</html>