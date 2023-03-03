<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Liste des Activites</title>
</head>
<body>




<div id="content">
<h1>Liste des Activites</h1>
     <input id="btnAddActivite" type="button" class ="btn btn-success" value="Ajouter">
     <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

     <table class="table table-striped">
       <thead>
         <tr>
                <th>Id</th>
                <th>Guide</th>
                <th>Prix</th>
                <th>Duree</th>
                <th>Vehicule</th>
                <th>Biome</th>
                <th>Type</th>
                <th>Actions</th>
            </tr>
       </thead>
       <tbody>
       <c:forEach items="${activites}" var="a">
       
       <tr>
           <tr>
                <td>${a.id}</td>
                <td>${a.guide}</td>
                <td>${a.prix}</td>
                <td>${a.duree}</td>
                <td>${a.vehicule}</td>
               	<td>${a.biome.id} - ${a.biome.nom} </td>
               	<td>${a.getClass().getSimpleName()} </td>            
           <td>
             <a href="activite?id=${a.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
             <a href="activite?id=${a.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
           </td>
         </tr>
       </c:forEach>
         

       </tbody>
     </table>





     <div id="addFormActivite" class="formAjout">
            <h3>Ajouter Activite</h3>
            <form action="activite" method="post">
            <table>
                <tr>
                    <td>Type d'Activite</td>
                    <td> <input required type="radio" name="typeActivite" value="Tourisme"> Tourisme <input required  type="radio" name="typeActivite" value="Scientifique"> Scientifique
                    </td>
                </tr>
                <tr>
                    <td> guide </td>
                    <td><input required name="guide" type="checkBox" ></td>
                </tr>
                <tr>
                    <td>Prix :</td>
                    <td> <input required name="prix" type="number" step = "0.01" placeholder="indiquer le prix"></td>
                </tr>
                <tr>
                    <td>Duree </td>
                    <td><input required name="duree" type="number" placeholder="Saisir la duree"></td>
                </tr>
                <tr>
                    <td>vehichule</td>
                   
                    <select name="vehicule">
                    	<c:forEach items="${vehicules}" var ="v">
                    		<option value="${v}">${v}</option>
                    	</c:forEach>
                    </select>
                </tr>
                <tr>
                    <td>Biome</td>
                   
                    <select name="biome">
                    	<c:forEach items="${biomes}" var ="b">
                    		<option value="${b.id}">${b.id} - ${b.nom}</option>
                    	</c:forEach>
                    </select>
                </tr>
          
            </table>
              <input class ="btn btn-success" type="submit" value="Ajouter">
            </form>
        </div>

</div>



</body>
</html>


<script>

btnAddActivite.onclick=function()
{
  addFormActivite.style.display="block";
}

</script>