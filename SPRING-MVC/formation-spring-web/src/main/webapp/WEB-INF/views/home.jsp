<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Accueil</title>
</head>
<body>
	<h1>Hello ${ utilisateur.username } !?</h1>
	
	
	<a href="produit?id=10">Afficher le produit (avec RequestParam)</a>
	<a href="produit/10">Afficher le produit (avec PathVariable)</a>
	
	
	<form method="POST">
		<input type="text" name="username" />
		<input type="password" name="password" />
		<input type="submit" value="OK !" />
 	</form>
	

</body>
</html>