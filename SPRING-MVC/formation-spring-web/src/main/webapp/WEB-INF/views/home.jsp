<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Accueil</title>
</head>
<body>
	<h1>Hello ${ utilisateur } !?</h1>
	
	<form method="POST">
		<input type="text" name="username" />
		<input type="submit" value="OK !" />
 	</form>
	

</body>
</html>