<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fiche Enfant</title>
</head>
<body>

	<h1>Fiche de l'enfant ${enfant.id}</h1>
	<table border>
		<tr>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Mechant ?</th>
			<th>Adresse</th>
		</tr>
		<tr>
			<td>${enfant.nom}</td>
			<td>${enfant.prenom}</td>
			<td>${enfant.mechant}</td>
			<td>${enfant.adresse.numero}, ${enfant.adresse.voie}, ${enfant.adresse.ville} ${enfant.adresse.cp}</td>
		</tr>
	</table>


</body>
</html>