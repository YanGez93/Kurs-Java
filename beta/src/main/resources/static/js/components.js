class Player {
  constructor(name,sprite = "citizen" , x, y) {
    this.name = name;
    this.sprite = sprite;
    this.width = 40;
    this.height = 40;
    this.speed = 10;
    this.x = x;
    this.y = y;
    this.passThrough = false;
    this.cyle = 0;
    this.direction = 1;
    this.position = [16, 3, 0]; //x y z
    this.oldPos = this.position; //x y z
    this.phantomPos = equalArr(this.position);
    this.walking = 0;
    this.walkFps = 0;
    this.roznicaX = 0;
    this.roznicaY = 0;
    this.health = 1000;
    this.maxHealth = 1000;
    this.targetlist = [];
    this.currentTarget = false;
    this.isTarget = false;
    this.currentExshoust = false;
    this.fistExhoust = 15;
  }
  controls = (key) => {
    this.phantomPos = [this.position[0], this.position[1], this.position[2]];
    if (key == 39) {this.phantomPos[0]++;}// right key
    if (key == 37) {this.phantomPos[0]--;}// left key
    if (key == 38) {this.phantomPos[1]--;}// up key
    if (key == 40) {this.phantomPos[1]++;}// down key
    // check if the arrow key is clicked
    if ([37, 38, 39, 40].includes(key)) {
      // check if he can go there
      let isFloor = false;
      for (let grid of map.grids) {
        if (compareTables(grid.position, this.phantomPos)) {
          if (grid.type == "stairs") {
            this.phantomPos = grid.attr;
            this.walking = "stairs";
          }else{
            this.walking = "walk";
          }          
          isFloor = true;
          break;
        }        
      }
      // add ceil to this "compareTables"
      let [dX, dY, dZ] = dragon.phantomPos;
      let [tX, tY, tZ] = this.phantomPos;
      let dragonFloored = [Math.floor(dX), Math.floor(dY), dZ];
      let thisFloored = [Math.floor(tX), Math.floor(tY), tZ];
      if (compareTables(dragonFloored, thisFloored)){
        isFloor = false;
      }
      if (!isFloor) {
        this.walking = false;
        inGameConsole.text = "There's no enough room.";
      }
    }
    if(key == 84){  // "t" key
      this.target(true);
    }
    // inGameConsole.text = key;
    //  inGameConsole.text = this.position;
    //  inGameConsole.text = this.walking;
  }
  update = () => {
    
    let ctx = gamePlane.context;

    if(this.health <= 0){
      this.die();
    }
    this.target()
    if(this.currentTarget){
      this.attack();
    }

    if(this.health > 0){
      let maxBarWidth = 28;
      let barWidth = (maxBarWidth * this.health) / this.maxHealth;
      let percHealth = (100 * this.health) / this.maxHealth;
      ctx.fillStyle = hpColor(percHealth);
      ctx.strokeStyle = 'black';
      ctx.lineWidth = 0.8;
      ctx.font = '900 10px Tahoma';
      ctx.textAlign = "center";
      ctx.fillText(this.name, this.x + 5, this.y - 22);
      ctx.strokeText(this.name, this.x + 5, this.y - 22);
      ctx.beginPath();
      ctx.rect(this.x - 11, this.y - 18, 30, 5);
      ctx.fillRect(this.x - 10, this.y - 17, barWidth, 3);
      ctx.stroke();
    }  
  
  }
  hit = (val, name, type = "fist") => {
    this.health = this.health - val;
    inGameConsole.text = "You lose "+val+" healthpoints an attack by a "+name+".";
  }
  target = (click) => {
    // get monsters in view
    this.targetlist = [];
    let [mX,mY,mZ] = dragon.position;
    let [tX,tY,tZ] = this.position;
    if(tZ == mZ && Math.abs(mX-tX) < 6 && Math.abs(mY-tY) < 6 ){
      this.targetlist.push(dragon);
    }else{
      dragon.onTarget = false;
      this.currentTarget = false;
      //inGameConsole.text = "Target lost."
    }
    // lose target on change

    // target first element
    if(click){
      if(this.targetlist.length > 0){
      
        this.targetlist[0].onTarget = true;
        this.isTarget = true;
        this.currentTarget = dragon;
      }else{
        inGameConsole.text = "There's nobody to target.";
      }
  
    }
    return player;
  } 
  die = () => {
    console.log("You are dead.")
    gamePlane.stop();
    let [x,y,z] = this.position;
    player = {
      position : [Math.ceil(x),Math.ceil[y],z]
    };
    this.direction = 4;
    this.position = [Math.ceil(x),Math.ceil[y],z]; 
    this.cyle = 0;    
  }
  attack(){
    let [mX,mY,mZ] = dragon.position;
    let [tX,tY,tZ] = this.position;
    if(tZ == mZ && Math.abs(mX-tX) <= 1 && Math.abs(mY-tY) <= 1 ){
      if(this.currentExshoust == false){
        this.currentExshoust = this.fistExhoust;
        this.currentTarget.hit(150,this.name);   
      //  hitText.push(new Text(200,20,"xD"));  
      }else{
        this.currentExshoust--;
        if(this.currentExshoust == 0){
          this.currentExshoust = false;
        }
      }
    }





  }
  draw(){
    // console.log(player.direction)
    let ctx = gamePlane.context;
    let img = gamePlane.sprites[player.sprite];
    ctx.drawImage(img,
      player.cyle * 64, player.direction * 64, 64, 64,
      this.x-24, this.y-40, 80, 80);
  }
 
}
class Grid {
  constructor(t) {
    if (typeof t[4] == "undefined") { t[4] = "floor"; }
    this.texture = t[0];
    this.position = [t[1], t[2], t[3]];
    this.type = t[4];
    this.width = 40;
    this.height = 40;
    this.zIndex = t[3];
    this.checked = false;
    if (typeof t[5] != "undefined") {this.attr = t[5][2];}
    this.passThrough = true;
    if (t[4] != "floor") { this.passThrough = false; }
    this.x = (this.position[0]) * this.width;
    this.y = (this.position[1]) * this.height;
  }
  update = () => {
    this.x = (this.position[0] - player.position[0] + 5) * this.width;
    this.y = (this.position[1] - player.position[1] + 5) * this.height;
  }
  draw = () => {
    let ctx = gamePlane.context;
    if (this.type == "floor") {
      var img = gamePlane.sprites.floors;
      ctx.drawImage(img, this.texture * 40, 0, 40, 40,
        this.x, this.y, 40, 40);
    }
    if (this.type == "stairs") {
      var img = gamePlane.sprites.stairs;
      ctx.drawImage(img, this.texture * 80, 0, 80, 80,
        this.x - 40, this.y - 40, 80, 80);
    }
    if (this.checked) {
      ctx.fillStyle = "rgba(255,0,0,0.3)";
      ctx.fillRect(this.x, this.y, this.width, this.height);
    }
  }
}
class Character {
  constructor(name, sprite = "monsters", [x, y, z]) {
    this.name = name;
    this.sprite = sprite;
    this.position = [x, y, z];
    this.firstPosition = [x, y, z];
    this.maxHealth = 1000;
    this.health = 1000;
    this.passThrough = false;
    this.z = z;
    this.x = x;
    this.y = y;
    this.w = 40;
    this.h = 40;
    this.zIndex = this.position[2];
    this.speed = 5; // kratki na sekundę
    this.direction = 1;
    this.walking = false;
    this.walkFps = 0;
    this.goMode = "random";
    this.route = [];
    this.phantomPos = [];
    this.cyle = 0;
    this.fistExhoust = 5;
    this.currentExshoust = false;
    this.onTarget = false;
  }
  changePosition = () => {
    // Set goMode (random / follow / escape)
    if (Math.abs(this.position[0] - player.position[0]) < 6
      && Math.abs(this.position[1] - player.position[1]) < 6
      && this.position[2] == player.position[2]) {
      // if player is in area
      if (this.health > 200) {
        this.goMode = "follow";
      } else {
        this.goMode = "escape";
      }
    } else {
      this.goMode = "random";
    }
    this.phantomPos = equalArr(this.position);
    let r;
    if (this.goMode == "random") {
      r = Math.floor(Math.random() * 4);
    }
    if (this.goMode == "follow") {
      let [monX,monY] = this.position;
      let [plaX,plaY] = player.position; 
      let posibilites = [];
      if(monX > plaX){posibilites.push(3);}
      if(monX < plaX){posibilites.push(1);}
      if(monY < plaY){posibilites.push(2);}
      if(monY > plaY){posibilites.push(0);}      
      let posibilitesId = Math.round(Math.random()*(posibilites.length-1));
      r = posibilites[posibilitesId];
      // set it done
      if(posibilites.length == 1 && 
        (Math.abs(monX-plaX) == 1 || Math.abs(monY-plaY) == 1)
        ){
        r = -1;
      }
    }
    if(this.goMode == "escape"){
      let [monX,monY] = this.position;
      let [plaX,plaY] = player.position; 
      let posibilites = [];
      if(monX <= plaX){posibilites.push(3);}
      if(monX >= plaX){posibilites.push(1);}
      if(monY >= plaY){posibilites.push(2);}
      if(monY <= plaY){posibilites.push(0);}      
      let posibilitesId = Math.round(Math.random()*(posibilites.length-1));
      r = posibilites[posibilitesId];
    }

    if (r == 0) {this.phantomPos[1]--;} // up
    if (r == 1) {this.phantomPos[1]++;} // down
    if (r == 2) {this.phantomPos[0]++;} // right
    if (r == 3) {this.phantomPos[0]--;} // left
    // r == -1 -> stop, but wait this time 

    let isFloor = false;
    for(let grid of map.grids) {
      if (compareTables(grid.position, this.phantomPos) && grid.passThrough) {
        isFloor = true;
      }
    }

    let [tX, tY, tZ] = this.phantomPos;
    let [dX, dY, dZ] = player.phantomPos;
    let playerFloored = [Math.floor(dX), Math.floor(dY), dZ];
    let thisFloored = [Math.floor(tX), Math.floor(tY), tZ];
    if(compareTables(playerFloored, thisFloored)){
      isFloor = false;
    }
    if ((isFloor && !compareTables(this.position, this.phantomPos)) || r == -1) {
      this.walking = true;
      if(r == -1){
        this.isGoing = false;
      }else{
        this.isGoing = true;
        this.direction = r;
      }
    }
  }
  update = () => {
    if(this.health <= 0){
      this.die();
    }
    if (this.walking) {
      let ik = Math.round(gamePlane.fps / this.speed); // ile razy ma iterować
      if(!this.isGoing){
        this.walkFps++;
        if (ik == this.walkFps) {
          this.walking = false;
          this.walkFps = 0;
          this.attack();
        }
      }else{

        if (this.walkFps < ik / 2) { this.cyle = 1; } else { this.cyle = 2; }
        if (this.walkFps == 0) {
          this.roznicaX = this.phantomPos[0] - this.position[0];
          this.roznicaY = this.phantomPos[1] - this.position[1];
        }
        this.position[0] = this.position[0] + (this.roznicaX / ik);
        this.position[1] = this.position[1] + (this.roznicaY / ik);

        this.walkFps++;
        if (ik == this.walkFps) {
          this.position[1] = Math.round(this.position[1]);
          this.position[0] = Math.round(this.position[0]);
          this.position[2] = this.phantomPos[2];
          this.walking = false;
          this.walkFps = 0;
          this.cyle = 0;
        }
      }
    }
    this.x = (this.position[0] - player.position[0] + 5) * 40;
    this.y = (this.position[1] - player.position[1] + 5) * 40;
  }
  draw = () => {
    if (!map.hideFloor.includes(this.zIndex)) {
      let ctx = gamePlane.context;      
      if(this.onTarget){
        ctx.beginPath();
        ctx.fillStyle = "red";
        ctx.strokeStyle = 'red';
        ctx.lineWidth = 3;
        ctx.rect(this.x, this.y, this.w, this.h);
        ctx.stroke();
      }
      var img = gamePlane.sprites[this.sprite];
      ctx.drawImage(img,
        this.cyle * 64, this.direction * 64, 64, 64,
        this.x-24, this.y-40, 80, 80);
     
      
      if (this.position[2] == player.position[2] && this.health > 0) {
        let maxBarWidth = 28;
        let barWidth = (maxBarWidth * this.health) / this.maxHealth;
        let percHealth = (100 * this.health) / this.maxHealth;
        ctx.fillStyle = hpColor(percHealth);
        ctx.strokeStyle = 'black';
        ctx.lineWidth = 0.8;
        ctx.font = '900 10px Tahoma';
        ctx.textAlign = "center";
        ctx.fillText(this.name, this.x + 5, this.y - 22);
        ctx.strokeText(this.name, this.x + 5, this.y - 22);
        ctx.beginPath();
        ctx.rect(this.x - 11, this.y - 18, 30, 5);
        ctx.fillRect(this.x - 10, this.y - 17, barWidth, 3);
        ctx.stroke();
      }
    }
  }
  attack = () => {
    if(this.currentExshoust == false){
      this.currentExshoust = this.fistExhoust;
      player.hit(250,this.name);   
    //  hitText.push(new Text(200,20,"xD"));  
    }else{
      this.currentExshoust--;
      if(this.currentExshoust == 0){
        this.currentExshoust = false;
      }
    }
  }
  hit = (val) => {
    this.health = this.health - val;
  }
  die = () => {
    this.walking = 0;
    this.direction = 4;
    this.onTarget = false;
    this.cyle = 0;
//    console.log("You're slain the "+this.name);
  } 
  
}
class Text {
  constructor(w = gamePlane.width, h = 20, text = "") {
    this.w = w;
    this.h = h;
    this.text = text;
    this.oldText = "";
    this.showingLength = 25;
    this.showFPS = 0;
  }
  update = () => {
    if (this.text != "") {
      if (this.text == this.oldText) {
        this.showFPS++;
      } else {
        this.oldText = this.text;
        this.showFPS = 0;
      }
      let ctx = gamePlane.context;
      ctx.fillStyle = '#fff';
      ctx.strokeStyle = 'black';
      ctx.lineWidth = 0.8;
      ctx.font = '900 10px Tahoma';
      ctx.textAlign = "center";
      ctx.fillText(this.text, player.x, player.y + 230);
      ctx.strokeText(this.text, player.x, player.y + 230);
      if (this.showFPS == this.showingLength) {
        this.text = "";
        this.showFPS = 0;
      }
    }
  }
}
