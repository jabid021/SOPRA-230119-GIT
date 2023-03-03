<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des biomes</title>
</head>
<body>
	<div id="content">
  <h1>Liste des Biomes</h1>
  <input id="btnAddBiome" type="button" class ="btn btn-success" value="Ajouter">
  <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Superficie</th>
        <th>Zone</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${biomes}" var="b">
      <tr>
        <td>${b.id}</td>
        <td>${b.nom}</td>
        <td>${b.superficie}</td>
        <td>${b.zone}</td>
        <td>
          <a href="biome?id=${b.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="biome?id=${b.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>





  <div id="addFormBiome" class="formAjout">
    <h3>Ajouter Activité</h3>
    <form action="biome" method="post">

      <table>
        <tr><td>Nom Biome : </td><td>  <input type="text" name="nom" placeholder="nom du biome"></td></tr>
        <tr><td>Superfecie (km²) : </td><td><input name="superficie" type="number" min="0" max="100" placeholder="superficie"></td></tr>
        <tr><td>Zone :</td>
            <td> <select name="zone"> 
            <c:forEach items="${zones}" var="z">
                    <option>${z}</option>
            </c:forEach>
                </select>
        </td></tr>
      </table>

      <input class ="btn btn-success" type="submit" value="Ajouter">
    </form>
  </div>

</div>

<script>

  btnAddBiome.onclick=function()
  {
    addFormBiome.style.display="block";
  }

</script>
</body>
</html>