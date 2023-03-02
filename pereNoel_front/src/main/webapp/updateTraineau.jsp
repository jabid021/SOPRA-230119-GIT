<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

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