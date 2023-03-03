<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modif Compte</title>
</head>
<body>


<div id="content">

  <h3>Modifier Compte ${compte.id}</h3>
  <form action="compte" method="post">
  <table>
                <tr>
                    <td>Type de compte</td>
                    <td> 
                    
                    <c:choose>
                     <c:when test="${compte.getClass().getSimpleName()=='Admin'}">
                    
                    	<input required checked type="radio" onClick="changeTypeCompte('Admin')" name="typeCompte" value="Admin"> Admin 
                   	 	<input required  onClick="changeTypeCompte('Ranger')" type="radio" name="typeCompte" value="Ranger"> Ranger
                    	<input required  onClick="changeTypeCompte('Client')" type="radio" name="typeCompte" value="Client"> Client
                    
                    </c:when>
                    
                    <c:when test="${compte.getClass().getSimpleName()=='Ranger'}">
                    
                    	<input required type="radio" onClick="changeTypeCompte('Admin')" name="typeCompte" value="Admin"> Admin 
                   	 	<input required checked onClick="changeTypeCompte('Ranger')" type="radio" name="typeCompte" value="Ranger"> Ranger
                    	<input required  onClick="changeTypeCompte('Client')" type="radio" name="typeCompte" value="Client"> Client
                    
                    </c:when>
                    <c:otherwise> 
                    	<input required type="radio" onClick="changeTypeCompte('Admin')" name="typeCompte" value="Admin"> Admin 
                   	 	<input required onClick="changeTypeCompte('Ranger')" type="radio" name="typeCompte" value="Ranger"> Ranger
                    	<input required checked onClick="changeTypeCompte('Client')" type="radio" name="typeCompte" value="Client"> Client</c:otherwise>
                     </c:choose>
                    
                   
                    </td>
                </tr>
                <tr>
                    <td>Login : </td>
                    <td><input required value="${compte.login}" name="login" type="text" placeholder="Saisir le login"></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td> <input required value="${compte.password}" name="password" type="password" placeholder="saisir le Mdp"></td>
                </tr>
                <tr>
                    <td>Nom : </td>
                    <td><input required value="${compte.nom}" name="nom" type="text" placeholder="Saisir votre nom"></td>
                </tr>
                <tr>
                    <td>Prenom : </td>
                    <td><input required value="${compte.prenom}" name="prenom" type="text" placeholder="Saisir votre prénom"></td>
                </tr>
                <tr id="inputAnciennete">
                    <td>Ancienneté :</td>
                    <td> <input class="inputRanger"  name="anciennete" <c:if test="${compte.getClass().getSimpleName()=='Ranger'}">value="${compte.anciennete}"</c:if> type="number" placeholder="Saisir votre ancienneté"></td>
                </tr>
                <tr id="inputNumero">
                    <td>Numéro : </td>
                    <td><input class="inputClient"  name="numero"  <c:if test="${compte.getClass().getSimpleName()=='Client'}">value="${compte.adresse.numero}"</c:if> type="text" placeholder="Saisir votre numéro"></td>
                </tr>
                <tr id="inputVoie">
                    <td>Voie : </td>
                    <td><input  class="inputClient"  name="voie" <c:if test="${compte.getClass().getSimpleName()=='Client'}">value="${compte.adresse.voie}"</c:if> type="text" placeholder="Saisir votre voie"></td>
                </tr>
                <tr id="inputVille">
                    <td>Ville : </td>
                    <td><input class="inputClient"  name="ville" <c:if test="${compte.getClass().getSimpleName()=='Client'}">value="${compte.adresse.ville}"</c:if> type="text" placeholder="Saisir votre ville"></td>
                </tr>
                <tr id="inputCp">
                    <td>Code postal : </td>
                    <td><input  class="inputClient"  name="cp" <c:if test="${compte.getClass().getSimpleName()=='Client'}">value="${compte.adresse.cp}"</c:if> type="text" placeholder="Saisir votre code postal"></td>
                </tr>
                <tr id="inputPays">
                    <td>Pays : </td>
                    <td><input class="inputClient"  name="pays" <c:if test="${compte.getClass().getSimpleName()=='Client'}">value="${compte.adresse.pays}"</c:if> type="text" placeholder="Saisir votre pays"></td>
                </tr>
            </table>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="compte"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>


</body>
</html>

<script>

changeTypeCompte("${compte.getClass().getSimpleName()}");


function changeTypeCompte(type)
{
	inputAnciennete.style.display="none";
	inputNumero.style.display="none";
	inputVoie.style.display="none";
	inputVille.style.display="none";
	inputCp.style.display="none";
	inputPays.style.display="none";
	
	for(b of document.getElementsByClassName("inputRanger"))
	{
		b.required=false;
	}
	for(b of document.getElementsByClassName("inputClient"))
	{
		b.required=false;
	}
	
	
	if(type=="Ranger")
	{
		inputAnciennete.style.display="table-row";
		for(b of document.getElementsByClassName("inputRanger"))
		{
			b.required=false;
		}
	}
	else if(type=="Client")
	{
		inputNumero.style.display="table-row";
		inputVoie.style.display="table-row";
		inputVille.style.display="table-row";
		inputCp.style.display="table-row";
		inputPays.style.display="table-row";
		for(b of document.getElementsByClassName("inputClient"))
		{
			b.required=true;
		}
	}
}
</script>