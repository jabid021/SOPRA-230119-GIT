//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX=0;
var posY=0;

var pokemon="pikachu";
var img="Down.png";

imgPikachu.setAttribute("src","assets/img/"+pokemon+img);

inputName.onkeyup = verifName;
btnStart.onclick=lancerAventure;


function verifName(event)
{
  if(inputName.value!="")
  {
    btnStart.disabled=false;
    if(event.key=="Enter")
    {
      lancerAventure();
    }
  }
  else
  {
    btnStart.disabled=true;
  }
}

function lancerAventure()
{
  grass.style.display="block";
  formStart.style.display="none";
  pikachu.setAttribute("title",inputName.value);
  //theme.play();
  document.body.onkeyup=deplacement;
}

function deplacement(event)
{
  if(event.key=="ArrowDown" || event.key=="s" )
  {
    if(posY<=600)
    {
      posY+=30;
    }
    img="Down.png";
  }
  else if(event.key=="ArrowRight" || event.key=="d" )
  {
    if(posX<=600)
    {
      posX+=30;
    }
    img="Right.png";
  }

  else if(event.key=="ArrowLeft" || event.key=="q")
  {
    if(posX>=30)
    {
      posX-=30;
    }
    img="Left.png";
  }

  else if(event.key=="ArrowUp" || event.key=="z")
  {
    if(posY>=30)
    {
      posY-=30;
    }
    img="Up.png";
  }


  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
  imgPikachu.setAttribute("src","assets/img/"+pokemon+img);

}
