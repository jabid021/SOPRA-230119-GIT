//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

  var posX=0;
  var posY=0;
  var posOeufX =300;
  var posOeufY =300;
  var random1=0;
  var random2=0;


  var pokemon="pikachu";
  var img="Down.png";



  imgPikachu.setAttribute("src","assets/img/"+pokemon+img);
  btnStart.onclick = lancerAventure;

  document.body.onkeydown = deplacement;

  inputName.onkeyup=verifLogin

  function verifLogin(event){
      if(event.key=="Enter")
      {
        lancerAventure();
      }
   }

  function lancerAventure()
  {
    if(inputName.value !="")
    {
      theme.play();

      formStart.style.display ="none";
      grass.style.display ="block";
      pikachu.setAttribute("title",inputName.value);
    }

  }

  function deplacement(event)
  {
    if(event.key=="ArrowDown" || event.key=="s" )
    {
      img="Down.png";
      if(posY<612)
      {
      posY+=30;
      }

    }
    else if(event.key=="ArrowRight" || event.key=="d" )
    {
      img="Right.png";
      if(posX < 612)
      {
      posX+=30;
      }
    }

    else if(event.key=="ArrowLeft" || event.key=="q")
    {
      img="Left.png";
      if(posX > 0)
      {
      posX-=30;
      }
    }

    else if(event.key=="ArrowUp" || event.key=="z")
    {
      img="Up.png";
      if(posY > 0)
      {
      posY-=30;
      }
    }


    pikachu.style.top=posY+"px";
    pikachu.style.left=posX+"px";
    imgPikachu.setAttribute("src","assets/img/"+pokemon+img);

    if(posY > (posOeufY - 30) && posY < (posOeufY+30 )&& posX > (posOeufX-30 ) && posX < (posOeufX+30))
    {

      pokemon=(pokemon=="pikachu")?"coincoin":"pikachu";
      //pokemon = "coincoin"
      theme.setAttribute("src","assets/audio/surftheme.mp3")
      theme.play();
    }

  }

  oeufQuiBouge = setInterval(deplacerOeuf,1000);

  function deplacerOeuf()
  {

    random1 = Math.random()*100-50;
    random2 = Math.random()*100-50;
    console.log(posOeufX +"+ :" + random1 +", "+posOeufY +" + :" + random2);
    if((posOeufX + random1) <700 && (posOeufX + random1) >0)
    { console.log("deplacement");
      posOeufX += random1;
      oeuf.style.top = random1 +"px";}
    if((posOeufY + random2) <700 && (posOeufY + random2) >0)
    {console.log("deplacement");
      posOeufY += random2;
      oeuf.style.left = random2 +"px";}
  }
