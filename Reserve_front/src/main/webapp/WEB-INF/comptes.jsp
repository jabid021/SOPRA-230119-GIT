<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Liste des Comptes ()</title>
</head>
<body>




<div id="content">
<h1>Liste des Comptes ${demoSession}</h1>
     <input id="btnAddCompte" type="button" class ="btn btn-success" value="Ajouter">
     <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

     <table class="table table-striped">
       <thead>
         <tr>
                <th>Id</th>
                <th>Identifiant</th>
                <th>Mot de passe</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Ancienneté</th>
                <th>Numéro</th>
                <th>Voie</th>
                <th>Ville</th>
                <th>Code Postal</th>
                <th>Pays</th>
                <th>Type</th>
                <th>Actions</th>
            </tr>
       </thead>
       <tbody>
       <c:forEach items="${comptes}" var="c">
       
       <tr>
           <tr>
                <td>${c.id}</td>
                <td>${c.login}</td>
                <td>${c.password}</td>
                <td>${c.nom}</td>
                <td>${c.prenom}</td>
               
	                <c:choose>
	                	<c:when test="${c.getClass().getSimpleName()=='Ranger'}">
	                		 <td>${c.anciennete}</td>
	                	</c:when>
	                	<c:otherwise><td>-</td></c:otherwise>
	                </c:choose> 
                
	                <c:choose>
	                	<c:when test="${c.getClass().getSimpleName()=='Client'}">
	                		<td>${c.adresse.numero}</td>
	                		<td>${c.adresse.voie}</td>
	                		<td>${c.adresse.ville}</td>
	                		<td>${c.adresse.cp}</td>
	                		<td>${c.adresse.pays}</td>
	                	</c:when>
	                	<c:otherwise>
	                		<td>-</td>
	                		<td>-</td>
	                		<td>-</td>
	                		<td>-</td>
	                		<td>-</td>
	                	</c:otherwise>
	                </c:choose> 
                <td>${c.getClass().getSimpleName().toLowerCase()}</td>
           <td>
             <a href="compte?id=${c.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
             <a href="compte?id=${c.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
           </td>
         </tr>
       </c:forEach>
         

       </tbody>
     </table>





     <div id="addFormCompte" class="formAjout">
            <h3>Ajouter Compte</h3>
            <form action="compte" method="post">
            <table>
                <tr>
                    <td>Type de compte</td>
                    <td> <input required type="radio" onClick="changeTypeCompte('Admin')" name="typeCompte" value="Admin"> Admin <input required onClick="changeTypeCompte('Ranger')" type="radio" name="typeCompte" value="Ranger"> Ranger
                        <input required onClick="changeTypeCompte('Client')" type="radio" name="typeCompte" value="Client"> Client
                    </td>
                </tr>
                <tr>
                    <td>Login : </td>
                    <td><input required name="login" type="text" placeholder="Saisir le login"></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td> <input required name="password" type="password" placeholder="saisir le Mdp"></td>
                </tr>
                <tr>
                    <td>Nom : </td>
                    <td><input required name="nom" type="text" placeholder="Saisir votre nom"></td>
                </tr>
                <tr>
                    <td>Prenom : </td>
                    <td><input  name="prenom" type="text" placeholder="Saisir votre prénom"></td>
                </tr>
                <tr id="inputAnciennete">
                    <td>Ancienneté :</td>
                    <td> <input class="inputRanger"   name="anciennete" type="number" placeholder="Saisir votre ancienneté"></td>
                </tr>
                <tr id="inputNumero">
                    <td>Numéro : </td>
                    <td><input class="inputClient"   name="numero" type="text" placeholder="Saisir votre numéro"></td>
                </tr>
                <tr id="inputVoie">
                    <td>Voie : </td>
                    <td><input class="inputClient"  name="voie" type="text" placeholder="Saisir votre voie"></td>
                </tr>
                <tr id="inputVille">
                    <td>Ville : </td>
                    <td><input class="inputClient"  name="ville" type="text" placeholder="Saisir votre ville"></td>
                </tr>
                <tr id="inputCp">
                    <td>Code postal : </td>
                    <td><input class="inputClient"  name="cp" type="text" placeholder="Saisir votre code postal"></td>
                </tr>
                <tr id="inputPays">
                    <td>Pays : </td>
                    <td><input class="inputClient"  name="pays" type="text" placeholder="Saisir votre pays"></td>
                </tr>
            </table>
              <input class ="btn btn-success" type="submit" value="Ajouter">
            </form>
        </div>

</div>



</body>
</html>


<script>

btnAddCompte.onclick=function()
{
  addFormCompte.style.display="block";
}

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
			b.required=true;
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