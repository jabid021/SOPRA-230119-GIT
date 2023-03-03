<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

<meta charset="UTF-8">
<title>Modifier Enfant</title>
</head>
<body>

<div id="content">

  <h3>Modifier Enfant ${enfant.id}</h3>
  <form action="enfant" method="post">
    <input type="hidden" name="id" value="${enfant.id}">

    <table>
        <tr><td>Nom : </td><td>  <input required value="${enfant.nom}" type='text' name='nom' placeholder='Saisir nom'></td></tr>
        <tr><td>Prenom : </td><td><input required value="${enfant.prenom}" type='text' name='prenom' placeholder='Saisir prénom'></td></tr>
        <tr><td>Mechant :</td><td>
       
        	<c:choose>
        		<c:when test="${enfant.mechant==true}">
        		 	<input required type='radio' checked name='mechant' value='oui'>Oui 
		  			<input required type='radio' name='mechant' value='non'>Non </td>
        		</c:when>
        		<c:otherwise>
        			<input required type='radio'  name='mechant' value='oui'>Oui 
		  			<input required type='radio' checked name='mechant' value='non'>Non </td>
        		</c:otherwise>
        	</c:choose>
        
      	 
		</tr>
        <tr><td>Numero</td><td><input  required type='text' value="${enfant.adresse.numero}" name='numero' placeholder='Saisir numero'></td></tr>
        <tr><td>Voie</td><td><input required  value="${enfant.adresse.voie}"type='text' name='voie' placeholder='Saisir voie'></td></tr>
        <tr><td>Ville</td><td><input required value="${enfant.adresse.ville}" type='text' name='ville' placeholder='Saisir ville'></td></tr>
        <tr><td>CP</td><td><input required type='text' value="${enfant.adresse.cp}" name='cp' placeholder='Saisir cp'></td></tr>
      </table>


    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="enfant"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>



</body>
</html>