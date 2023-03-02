<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

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
      <tr>
        <td>${enfants[0].id}</td>
        <td>${enfants[0].nom}</td>
        <td>${enfants[0].prenom}</td>
        <td>${enfants[0].mechant}</td>
        <td>${enfants[0].adresse.numero}, ${enfants[0].adresse.voie}, ${enfants[0].adresse.ville} ${enfants[0].adresse.cp}</td>
        <td>
          <a href="enfant?id=${enfants[0].id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="enfant?id=${enfants[0].id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>

      <tr>
        <td>${enfants[1].id}</td>
        <td>${enfants[1].nom}</td>
        <td>${enfants[1].prenom}</td>
        <td>${enfants[1].mechant}</td>
        <td>${enfants[1].adresse.numero}, ${enfants[1].adresse.voie}, ${enfants[1].adresse.ville} ${enfants[1].adresse.cp}</td>
        <td>
          <a href="enfant?id=${enfants[1].id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="enfant?id=${enfants[1].id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
      
      
       <tr>
        <td>${enfants[2].id}</td>
        <td>${enfants[2].nom}</td>
        <td>${enfants[2].prenom}</td>
        <td>${enfants[2].mechant}</td>
        <td>${enfants[2].adresse.numero}, ${enfants[2].adresse.voie}, ${enfants[2].adresse.ville} ${enfants[2].adresse.cp}</td>
        <td>
          <a href="enfant?id=${enfants[2].id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="enfant?id=${enfants[2].id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
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
