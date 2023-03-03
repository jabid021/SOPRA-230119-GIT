<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier biome</title>
</head>
<body>
<div id="content">

  <h3>Modifier Biome ${biome.id}</h3>
  <form action="biome" method="post">
    <input type="hidden" name="id" value="${biome.id}">

    <table>
        <tr><td>Nom Biome : </td><td>  <input type="text" name="nom" value="${biome.nom}" placeholder="nom du biome"></td></tr>
        <tr><td>Superfecie (km²) : </td><td><input name="superficie" type="number" min="0" max="100" value="${biome.superficie}" placeholder="superficie"></td></tr>
        <tr><td>Zone :</td>
            <td> <select name="zone"> 
           
                    <c:forEach items="${zones}" var="z">
                     <c:choose>
            			<c:when test="${biome.zone == z}"> <option selected>${z}</option></c:when>
            			<c:otherwise> <option>${z}</option></c:otherwise>
           			 </c:choose>
                   
            </c:forEach>
                </select>
        </td></tr>
      </table>


    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="biome"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>