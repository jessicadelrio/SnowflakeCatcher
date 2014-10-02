SnowFlake [] fall;
void setup()
{ 
  //your code here
  size(500,500);
  background(0,0,0);
  fall = new SnowFlake[200];

  for(int i = 0; i<fall.length;i++){
    fall[i] = new SnowFlake();
   }

  }

void draw()
{
  //your code here
 //background(0,0,0);
  for(int i = 0; i< fall.length; i++){
    fall[i].erase();
    fall[i].lookDown();
    fall[i].move();
    fall[i].wrap();
    fall[i].show();
    
    
  }
  /*if(mousePressed==true){
     for(int i = 0; i < fall.length; i++){
    fall[i].stop();
    fall[i].lookDown();
    fall[i].show();
  }
}*/
}


void mouseDragged()
{
  //your code here
  for(int i = 0; i < fall.length; i++){
    fall[i].stop();
    fall[i].lookDown();
    fall[i].show();
    
  }
}
void keyPressed(){
  for(int i = 0; i < fall.length; i++){
    fall[i].start();
    fall[i].lookDown();
    fall[i].show();
  }
}

class SnowFlake
{
  //class member variable declarations
  int myX, myY;
  boolean isMoving = true;
  SnowFlake()
  {
    //class member variable initializations
    myX = (int)(Math.random()*501);
    myY = (int)(Math.random()*501);
    isMoving = true;
  }
  void show()
  {
    //your code here

    noStroke();
    fill(255, 0, 128);
    ellipse(myX,myY,15,15);
  }
  void lookDown()
  {
    //your code here
    if((myY <= 515 && myY >= -15)&&((get(myX,myY+10))!= color (255,255,255)&&(get(myX,myY+10))!= color (255, 0, 128))){
      isMoving = true;
    }
    else{
      isMoving = false;
    }
  }
  void erase()
  {
    noStroke();
    fill(0,0,0);
    ellipse(myX,myY,20,20);

  }
  void start(){
    noStroke();
    fill(0,0,0);
    ellipse(mouseX,mouseY,20,20);
  }  
  void stop(){
    //your code here
    //size(7);
    noStroke();
    fill(255,255,255);
    ellipse(mouseX,mouseY,20,20);
  }
  void move()
  {
    //your code here
    if(isMoving == true){
      myY++;
    }
  }
  void wrap()
  {
    //your code here
    if(myY > 500){
      myY = 0;
      myX = (int)(Math.random()*501);
    }
  }
}


