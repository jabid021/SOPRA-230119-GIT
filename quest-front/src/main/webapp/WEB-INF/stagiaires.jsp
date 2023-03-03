<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Liste des Stagiaires</title>
</head>
<body>




<div id="content">
<h1>Liste des Stagiaires</h1>
     <input id="btnAddStagiaire" type="button" class ="btn btn-success" value="Ajouter">
     <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

     <table class="table table-striped">
       <thead>
         <tr>
           <th>Id</th>
           <th>Nom</th>
           <th>Prenom</th>
           <th>Email</th>
           <th>Filiere</th>
           <th>Actions</th>
           </tr>
       </thead>
       <tbody>
       <c:forEach items="${stagiaires}" var="s">
       
       <tr>
           <td>${s.id}</td>
           <td>${s.nom}</td>
           <td>${s.prenom}</td>
           <td>${s.email}</td>
           <td>${s.filiere.id} - ${s.filiere.libelle}</td>
           <td>
             <a href="stagiaire?id=${s.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
             <a href="stagiaire?id=${s.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
           </td>
         </tr>
       </c:forEach>
         

       </tbody>
     </table>





     <div id="addFormStagiaire" class="formAjout">
            <h3>Ajouter Stagiaire</h3>
            <form action="stagiaire" method="post">
            Nom :<input name="nom" type="text" placeholder="Saisir votre nom"><br>
            Prenom :<input name="prenom" type="text" placeholder="Saisir votre prenm"><br>
            Email :<input name="email" type="email" placeholder="Saisir votre email"><br>
            Filiere
              <select name="filiere">
              <c:forEach items="${filieres}" var="f">
             	  <option value="${f.id}" >${f.id} - ${f.libelle}</option>
              </c:forEach>
                 
              </select><br>
              <input class ="btn btn-success" type="submit" value="Ajouter">
            </form>
        </div>

</div>



</body>
</html>


<script>

btnAddStagiaire.onclick=function()
{
  addFormStagiaire.style.display="block";
}

</script>