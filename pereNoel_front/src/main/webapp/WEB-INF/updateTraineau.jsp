<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Modifier Traineau</title>
</head>
<body>

<div id="content">

  <h3>Modifier Traineau ${traineau.id}</h3>
  <form action="traineau" method="post">
    <input type="hidden" name="id" value="${traineau.id}">
 	<table>
        <tr><td>Autonomie : </td><td>  <input required type='number' value="${traineau.autonomie}" name='autonomie' placeholder='Saisir autonomie'></td></tr>
        <tr><td>Clochettes : </td><td><input required type='number' value="${traineau.clochettes}" name='clochettes' placeholder='Saisir clochettes'></td></tr>
        <tr><td>Poids</td><td><input required type='number' value="${traineau.poids}" step="0.01" name='poids' placeholder='Saisir poids'></td></tr>
        </table>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="traineau"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>



</body>
</html>