import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] fall;
public void setup()
{ 
  //your code here
  size(500,500);
  background(0,0,0);
  fall = new SnowFlake[200];

  for(int i = 0; i<fall.length;i++){
    fall[i] = new SnowFlake();
   }

  }

public void draw()
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


public void mouseDragged()
{
  //your code here
  for(int i = 0; i < fall.length; i++){
    fall[i].stop();
    fall[i].lookDown();
    fall[i].show();
    
  }
}
public void keyPressed(){
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
  public void show()
  {
    //your code here

    noStroke();
    fill(255, 0, 128);
    ellipse(myX,myY,15,15);
  }
  public void lookDown()
  {
    //your code here
    if((myY <= 515 && myY >= -15)&&((get(myX,myY+10))!= color (255,255,255)&&(get(myX,myY+10))!= color (255, 0, 128))){
      isMoving = true;
    }
    else{
      isMoving = false;
    }
  }
  public void erase()
  {
    noStroke();
    fill(0,0,0);
    ellipse(myX,myY,20,20);

  }
  public void start(){
    noStroke();
    fill(0,0,0);
    ellipse(mouseX,mouseY,20,20);
  }  
  public void stop(){
    //your code here
    //size(7);
    noStroke();
    fill(255,255,255);
    ellipse(mouseX,mouseY,20,20);
  }
  public void move()
  {
    //your code here
    if(isMoving == true){
      myY++;
    }
  }
  public void wrap()
  {
    //your code here
    if(myY > 500){
      myY = 0;
      myX = (int)(Math.random()*501);
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
