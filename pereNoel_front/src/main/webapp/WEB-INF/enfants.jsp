<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Gestion des enfants</title>
</head>
<body>


<div id="content">
  <h1>Liste des Enfants</h1>
  <input id="btnAddEnfant" type="button" class ="btn btn-success" value="Ajouter">
  <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Mechant ?</th>
        <th>Adresse</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    
  
    <c:forEach items="${enfants}" var="enfant">
    
      <tr>
        <td>${enfant.id}</td>
        <td>${enfant.nom}</td>
        <td>${enfant.prenom}</td>
        <td>${enfant.mechant}</td>
        <td>${enfant.adresse.numero}, ${enfant.adresse.voie}, ${enfant.adresse.ville} ${enfant.adresse.cp}</td>
        <td>
          <a href="enfant?id=${enfant.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="enfant?id=${enfant.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
    </c:forEach>
   
    </tbody>
  </table>





  <div id="addFormEnfant" class="formAjout">
    <h3>Ajouter un Enfant</h3>
    <form action="enfant" method="post">

      <table>
        <tr><td>Nom : </td><td>  <input required type='text' name='nom' placeholder='Saisir nom'></td></tr>
        <tr><td>Prenom : </td><td><input required type='text' name='prenom' placeholder='Saisir prénom'></td></tr>
        <tr><td>Mechant :</td><td><input required type='radio' name='mechant' value='oui'>Oui 
					<input required type='radio' name='mechant' value='non'>Non </td></tr>
        <tr><td>Numero</td><td><input required type='text' name='numero' placeholder='Saisir numero'></td></tr>
        <tr><td>Voie</td><td><input required type='text' name='voie' placeholder='Saisir voie'></td></tr>
        <tr><td>Ville</td><td><input required type='text' name='ville' placeholder='Saisir ville'></td></tr>
        <tr><td>CP</td><td><input required type='text' name='cp' placeholder='Saisir cp'></td></tr>
      </table>

      <input class ="btn btn-success" type="submit" value="Ajouter">
    </form>
  </div>

</div>


</body>
</html>


<script>

  btnAddEnfant.onclick=function()
  {
    addFormEnfant.style.display="block";
  }

</script>
