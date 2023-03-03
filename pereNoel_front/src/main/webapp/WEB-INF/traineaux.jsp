<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Gestion des traineaux</title>
</head>
<body>



<div id="content">
  <h1>Liste des Traineaux</h1>
  <input id="btnAddTraineau" type="button" class ="btn btn-success" value="Ajouter">
  <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Autonomie</th>
        <th>Clochettes</th>
        <th>Poids</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${traineaux}" var="t">
    
    <tr>
        <td>${t.id}</td>
        <td>${t.autonomie}</td>
        <td>${t.clochettes}</td>
        <td>${t.poids}</td>
        <td>
          <a href="traineau?id=${t.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="traineau?id=${t.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
    
    </c:forEach>
      
    </tbody>
  </table>





  <div id="addFormTraineau" class="formAjout">
    <h3>Ajouter un Traineau</h3>
    <form action="traineau" method="post">

      <table>
        <tr><td>Autonomie : </td><td>  <input required type='number' name='autonomie' placeholder='Saisir autonomie'></td></tr>
        <tr><td>Clochettes : </td><td><input required type='number' name='clochettes' placeholder='Saisir clochettes'></td></tr>
        <tr><td>Poids</td><td><input required type='number' step="0.01" name='poids' placeholder='Saisir poids'></td></tr>
        </table>

      <input class ="btn btn-success" type="submit" value="Ajouter">
    </form>
  </div>

</div>


</body>
</html>


<script>

  btnAddTraineau.onclick=function()
  {
    addFormTraineau.style.display="block";
  }

</script>
