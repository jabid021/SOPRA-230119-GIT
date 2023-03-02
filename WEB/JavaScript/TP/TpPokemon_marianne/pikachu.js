//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

  var posX=0;
  var posY=0;
  var cpt=0;
  var leekBool = false;
  var gotLeek = false;
  const audioBlop = new Audio("assets/audio/blop.wav");
  const audioAngry = new Audio("assets/audio/angry.mp3");
  const audio = new Audio("assets/audio/theme.mp3");
  audio.loop = true;

  var pokemon="pikachu";
  var img="Down.png";

  imgPikachu.setAttribute("src","assets/img/"+pokemon+img);

  inputName.onkeyup = verifChamp;
  btnStart.onclick = lancerAventure;
  imgCoin.onclick = conversation;
  document.body.onkeyup = checkEnter;
  
  function verifChamp(event){
    if (inputName.value == ""){
      btnStart.disabled = true;
    }else{
      btnStart.disabled = false;
      if (event.key == "Enter"){
        lancerAventure();
      }
    }
  }

  function lancerAventure()
  {
    imgPikachu.setAttribute("title", inputName.value);
    formStart.style.display = "none";
    grass.style.display = "inline-block";
    document.body.onkeydown = deplacement;
  }

  function deplacement(event) //check if pikachu is inside grass & not next to coin
  {
    if(event.key=="ArrowDown" || event.key=="s" )
    {
      if(posY<630){
        if((posX!=570 && posX!=540 && posX!=600) || (posY!=450)){
          posY+=30;}
      }
      img = "Down.png";
    }
    else if(event.key=="ArrowRight" || event.key=="d" )
    {
      if (posX<630){
        if(posX!=510 || (posY!=510 && posY!=540 && posY!=480)){
           posX+=30;}
        }  
      img = "Right.png";
    }

    else if(event.key=="ArrowLeft" || event.key=="q")
    {
      if (posX>0){
        if(posX!=630 || (posY!=510 && posY!=540 && posY!=480)){
          posX-=30;}
        }
      img = "Left.png";
    }

    else if(event.key=="ArrowUp" || event.key=="z")
    {
      if (posY>0){
        if((posX!=570 && posX!=540 && posX!=600) || posY!=570){
          posY-=30;}
        }
      img = "Up.png";
    }


    pikachu.style.top=posY+"px";
    pikachu.style.left=posX+"px";
    imgPikachu.setAttribute("src","assets/img/"+pokemon+img);

    if(leekBool){
      if (pikachu.style.top == "90px" && pikachu.style.left == "60px"){
        leek.style.display = "none";
        audioBlop.play();
        gotLeek = true;
      }
    }
  }

  function checkEnter(event){
    if(event.key == "Enter"){
      conversation();
    }
  }

  function conversation(){
    //modify HTML text info depending on cpt
    if (cpt == 1){
      bulle2.innerHTML = "Coin ?";
    }else if (cpt == 2){
      bulle2.innerHTML = "Coin-Coin, coin !";
    }else if (cpt == 3){
      bulle2.innerHTML = "&#128128;";
      imgCoin.title = "Angry Coin";
    }else if (cpt == 6){
      bulle2.innerHTML = "COIN !!!!!";
    }else if (cpt == 10){
      bulle2.innerHTML = "<a href='https://www.youtube.com/watch?v=eBGIQ7ZuuiU' target='_blank'>Leave me alone!</a>";
      imgCoin.title = "Very Angry Coin";
      leekBool = true;
    }else if (cpt == 11){
      bulle2.innerHTML = "Leave me alone!";
      imgCoin.title = "Very Angry Coin";
    }

    //check if leek has been picked up & if so, coin becomes friendly
    if(gotLeek){
      bulle2.innerHTML = "&#10084;";
      imgCoin.title = "Loving Coin";
      audio.play();
    }

    //check pikachu position and if next to coin, conversation begins
    if(pikachu.style.left == "510px" && (pikachu.style.top == "510px" || pikachu.style.top == "480px" || pikachu.style.top == "540px") && imgPikachu.getAttribute("src") == "assets/img/pikachuRight.png"){
      changeCoin("Left", cpt); //change coin orientation & displays speech
      cpt++;
    }else if((pikachu.style.left == "570px" || pikachu.style.left == "540px" || pikachu.style.left == "600px") && pikachu.style.top == "450px" && imgPikachu.getAttribute("src") == "assets/img/pikachuDown.png"){
      changeCoin("Up", cpt);
      cpt++;
    }
    else if((pikachu.style.left == "570px" || pikachu.style.left == "540px" || pikachu.style.left == "600px") && pikachu.style.top == "570px" && imgPikachu.getAttribute("src") == "assets/img/pikachuUp.png"){
      changeCoin("Down", cpt);
      cpt++;
    }
    else if(pikachu.style.left == "630px" && (pikachu.style.top == "510px" || pikachu.style.top == "540px" || pikachu.style.top == "480px") && imgPikachu.getAttribute("src") == "assets/img/pikachuLeft.png"){
      changeCoin("Right", cpt); 
      cpt++;
    }

    
    setTimeout(hide, 5000); //hide coin's speech after 5sec
  }

  function hide(){
    bulle2.style.display = "none";
  }

  function changeCoin(orient, cpt){
    bulle2.style.display = "inline-block";
    imgCoin.setAttribute("src", "assets/img/coincoin"+orient+".png");
    if(!gotLeek){
      audioAngry.play();
      if (cpt >= 10){
        if(orient == "Left"){
          posX = 420;
          pikachu.style.left= "420px";
        }else if(orient == "Right"){
          posX = 630;
          pikachu.style.left= "630px";
        }else if(orient == "Up"){
          posY = 360;
          pikachu.style.top= "360px";
        }else if(orient == "Down"){
          posY = 630;
          pikachu.style.top= "630px";
        }
      }
    }
    
  }