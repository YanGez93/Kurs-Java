let map = {
  position:[1,1,1],
  grids: [],
  // template:[
  //   // x, y, z
  //   // first tower floor
  //   [1,0,0,0],
  //   [1,1,0,0],
  //   [1,2,0,0],
  //   [1,3,0,0],
  //   [1,4,0,0],
  //   [1,0,1,0],
  //   [1,1,1,0],
  //   [1,3,1,0],
  //   [1,4,1,0],
  //   [1,0,2,0],
  //   [1,1,2,0],
  //   [1,2,2,0],
  //   [1,3,2,0],
  //   [1,4,2,0],
  //   [1,0,3,0],
  //   [1,1,3,0],
  //   [0,2,3,0],
  //   [1,3,3,0],
  //   [1,4,3,0],
  //   [1,0,4,0],
  //   [1,1,4,0],
  //   [1,2,4,0],
  //   [1,3,4,0],
  //   [1,4,4,0],
  //   [1,2,1,0,"stairs",["up","north",[1,-1,1]]],
    

  //   // first tower uppstairs
  //   [0,1,-1,1],
  //   [0,2,-1,1],
  //   [0,3,-1,1],
  //   [0,4,-1,1],
  //   [0,4,0,1],
  //   [0,4,1,1],
  //   [0,4,2,1],
  //   [0,4,3,1],
  //   [0,4,4,1],
  //   [0,4,5,1],
  //   [0,3,5,1],
  //   [0,2,6,1],
  //   [0,2,7,1],
  //   [0,1,6,1],
  //   [1,1,7,1],
  //   [0,0,7,1],
  //   [0,0,6,1],
  //   [0,2,5,1],
  //   [0,1,5,1],
  //   [0,0,5,1],
  //   [0,-1,5,1],
  //   [0,-2,5,1],
  //   [0,-2,4,1],
  //   [0,-2,3,1],
  //   [0,-2,2,1],
  //   [0,-2,1,1],
  //   [0,-2,0,1],
  //   [0,-2,-1,1],
  //   [0,-1,-1,1],
  //   [0,0,-1,1],
  //   [0,0,8,1],
  //   [0,1,8,1],
  //   [0,2,8,1],
  //   [0,1,0,1,"stairs",["down","south",[2,2,0]]],


  //   // road between towers
  //   [1,5,2,0],
  //   [1,5,1,0],
  //   [1,6,2,0],
  //   [1,6,1,0],    
  //   [1,7,2,0],
  //   [1,7,1,0],
  //   [1,8,2,0],
  //   [1,8,1,0],
  //   [1,9,2,0],
  //   [1,9,1,0],
  //   [1,10,2,0],
  //   [1,10,1,0],
  //   [1,11,2,0],
  //   [1,11,1,0],    
  //   [1,12,2,0],
  //   [1,12,1,0],
  //   [1,13,2,0],
  //   [1,13,1,0],

  //   //second tower floor
  //   [1,14,0,0],
  //   [1,14,1,0],
  //   [1,14,2,0],
  //   [1,14,3,0],
  //   [1,14,4,0],
  //   [1,15,0,0],
  //   [1,15,1,0],
  //   [1,15,2,0],
  //   [1,15,3,0],
  //   [1,15,4,0],
  //   [1,16,0,0],
  //   [1,16,2,0],
  //   [0,16,3,0],
  //   [1,16,4,0],
  //   [1,17,0,0],
  //   [1,17,1,0],
  //   [1,17,2,0],
  //   [1,17,3,0],
  //   [1,17,4,0],
  //   [1,18,0,0],
  //   [1,18,1,0],
  //   [1,18,2,0],
  //   [1,18,3,0],
  //   [1,18,4,0],
  //   [1,16,1,0,"stairs",["up","north",[15,-1,1]]],

  //   // second tower ustairs
  //   [0,12,-1,1],
  //   [0,12,0,1],
  //   [0,12,1,1],
  //   [0,12,2,1],
  //   [0,12,3,1],
  //   [0,12,4,1],
  //   [0,12,5,1],
  //   [0,13,5,1],
  //   [0,14,5,1],
  //   [0,15,5,1],
  //   [0,16,5,1],
  //   [0,17,5,1],
  //   [0,18,5,1],
  //   [0,18,4,1],
  //   [0,18,3,1],
  //   [0,18,2,1],
  //   [0,18,1,1],
  //   [0,18,0,1],
  //   [0,18,-1,1],
  //   [0,17,-1,1],
  //   [0,16,-1,1],
  //   [0,15,-1,1],
  //   [0,14,-1,1],
  //   [0,13,-1,1],

  //   [0,14,6,1],
  //   [0,15,6,1],
  //   [0,16,6,1],
  //   [0,16,7,1],
  //   [1,15,7,1],
  //   [0,14,7,1],
  //   [0,14,8,1],
  //   [0,15,8,1],
  //   [0,16,8,1],
  //   [0,15,0,1,"stairs",["down","south",[16,2,0]]],
  // ],
  load(callback){
    console.log("map loading.")
    fetch("../json/map.json").then(dt => dt.json()).then(data => {
      map.template = data;
      callback();
    })
  },
  generate(callback){
    this.load(()=>{
      for(t of this.template){
        this.grids.push(new Grid(t));     
      }  
    });
    callback();
  },
  update(){
    for(g of this.grids){
      g.update();
    }
  },
  draw(zIndex){
    this.hideFloor = [];
    // get info loop
    for(g of this.grids){
      // render only nearest objects
      if(Math.abs(g.position[0] - player.position[0]) < 7
      && Math.abs(g.position[1] - player.position[1]) < 7){
        // set zIndex when player is for smth (za czyms)
        if(g.type == "stairs"){
          if(
            (Math.ceil(player.position[0])+1 == g.position[0] && Math.ceil(player.position[1]) == g.position[1])
            ||(Math.ceil(player.position[1])+1 == g.position[1] && Math.ceil(player.position[0]) == g.position[0])
            ||(Math.ceil(player.position[1])+1 == g.position[1] && Math.ceil(player.position[0])+1 == g.position[0])
          ){
            g.zIndex = g.position[2]+1;
            g.lastZIndex = g.zIndex;
  //          g.draw(g.zIndex);
          }else{
            g.zIndex = g.position[2];
          }
          if(g.lastZIndex != g.zIndex){
            g.lastZIndex = g.zIndex;
            g.draw(g.zIndex);   
          }
        }
        // hide floor when player is below smth
        if(Math.floor(player.position[0]) == g.position[0] && Math.floor(player.position[1]) == g.position[1] && Math.floor(player.position[2])+1 == g.position[2]){
          if(g.type != "stairs"){
            this.hideFloor.push(g.position[2]);
          }
        }
      }
    }
    // render elements loop
    for(g of this.grids){
      // render only nearest objects
      if(Math.abs(g.position[0] - player.position[0]) < 7
      && Math.abs(g.position[1] - player.position[1]) < 7){
        //first draw
        if(zIndex == -1 && g.zIndex < Math.floor(player.position[2])){
          g.draw(zIndex);
        }      
        // second draw
        if(zIndex == 0 && g.zIndex == Math.floor(player.position[2])){
          g.draw(zIndex);
        }
        // third draw
        if(zIndex == 1 && g.zIndex > Math.floor(player.position[2]) && !this.hideFloor.includes(g.zIndex)){
          g.draw(zIndex);
        }


      }
    }
  }
}
