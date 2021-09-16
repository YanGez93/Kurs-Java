let mobileControls = {
  validate : () => {
    let panel = document.querySelectorAll(".mobileControls");
    if( /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ) {
      console.log("Detect mobile device, setting controls.");
      panel[0].style.display = "flex";
      panel[1].style.display = "flex";
      mobileControls.set();
    }else{
      panel[0].style.display = "none";
      panel[1].style.display = "none";
    }
  },
  set: () => {
    // resolution:
    // window width & height
    let panelWidth; 
    let wW = document.body.offsetWidth;
    let wH = document.body.offsetHeight;
    let panels = document.getElementsByClassName("mobileControl");
    if(wW > wH){
      panelWidth = (wW - wH)/2+"px";
      document.body.style = `grid-template-areas: 'lb gp rb' ;`;
      for(p of panels){
        p.style.width = panelWidth;
        p.style.height = panelWidth;
      }
    }else{
      panelWidth = 50+"vw";
      document.body.style = `grid-template-areas: 'gp gp' 'lb rb' ;`;
      for(p of panels){
        p.style.width = panelWidth;
        p.style.height = panelWidth;
      }
    }
    // mobileControls.rightButtons = new buttons("right");
    // mobileControls.rightButtons.build();

    mobileControls.build("rightPanel");

    // mobileControls.leftButtons = new buttons("left");
    // mobileControls.leftButtons.build();
  },
  build(ctrlID){
    if(ctrlID == "rightPanel"){
      let leftPanel = document.querySelector(".rightPanel");
      leftPanel.innerHTML = "";
      let arrows = ["↑", "←", "→", "↓"];
      let arrowsCodes = [38, 37, 39, 40];
      let arrow = 0;
      for(let i = 0; i < 9; i++){
        let singleField = document.createElement("div");
        
        if(i % 2 != 0){
          singleField.innerHTML = arrows[arrow];
          singleField.className = "arrow";
          singleField.dataset.keyCode = arrowsCodes[arrow];
          arrow++;
        }
        leftPanel.appendChild(singleField);
      }

    }
    if(ctrlID == "leftPanel"){
      let leftPanel = document.querySelector(".leftPanel");
      leftPanel.innerHTML = "<br /><br /><br /><br /><br />Target here";
      

    }
  },
  preventZoom: () => {
    document.addEventListener('gesturestart', function(e) {
        e.preventDefault();
        // special hack to prevent zoom-to-tabs gesture in safari
        document.body.style.zoom = 0.99;
    });
    
    document.addEventListener('gesturechange', function(e) {
        e.preventDefault();
        // special hack to prevent zoom-to-tabs gesture in safari
        document.body.style.zoom = 0.99;
    });
    
    document.addEventListener('gestureend', function(e) {
        e.preventDefault();
        // special hack to prevent zoom-to-tabs gesture in safari
        document.body.style.zoom = 0.99;
    });
  }
}
// class buttons {
//   constructor(direction){
//     this.direction = direction;
//     if(this.direction == "right"){
//       this.c = document.querySelector(".rightBar");
//       this.buttons = [
//         {keyCode : 38,x: 50,  y: 0,   w:50, h:50},
//         {keyCode : 40,x: 50,  y: 100, w:50, h:50},
//         {keyCode : 39,x: 100, y: 50,  w:50, h:50},
//         {keyCode : 37,x: 0,   y: 50,  w:50, h:50},
//       ]
//     }else if(this.direction == "left"){
//       this.c = document.querySelector(".leftBar");
//       this.buttons = [
//         {keyCode : 84, x: 25,  y: 50,   w:100, h:50},
//       ]
//     }
//     this.c.width = 150;
//     this.c.height = 150;
//     this.ct = this.c.getContext("2d"); 
//   }
//   build = () => {
//     this.ct.clearRect(0, 0, this.c.width, this.c.height);
//     let img = gamePlane.sprites["mobile_controls"];
//     setTimeout(()=>{
//       for(let b = 0; b < this.buttons.length; b++){
//         let row = 0;
//         if(this.direction == "left"){row = 50;}

//         this.ct.drawImage(img,
//           b*50, row, this.buttons[b].w, this.buttons[b].h,
//           this.buttons[b].x, this.buttons[b].y, this.buttons[b].w, this.buttons[b].h);          
//       }
//       this.c.onclick = function(e) {
//         let keyCode = checkClick(e,this.direction);
//         if(keyCode){
//           player.controls(keyCode);
//         }
//       }
//     },50)
//   }
// }