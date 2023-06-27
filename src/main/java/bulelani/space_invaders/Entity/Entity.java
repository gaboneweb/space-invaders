package bulelani.space_invaders.Entity;


import bulelani.space_invaders.Coordinates.Coordinates;
import bulelani.space_invaders.direction.Direction;
import bulelani.space_invaders.keyandler.KeyHandler;

public class Entity {
     protected Coordinates position;
     protected   float speed = (float) 4;

     protected  int numberOfLives;

     protected int entitySize;

     protected Coordinates topRightPos;

     Coordinates topLeftPos;

     Coordinates bottomRightPos;


     protected  boolean alive = true;

     public Entity(Coordinates position, int numberOfLives,int entitySize){
          this.numberOfLives = numberOfLives;
          this.position = position;
          this.entitySize = entitySize;
          this.topRightPos = new Coordinates(position.getXpos() + this.entitySize - 1,position.getYpos() + this.entitySize - 1);
          this.topLeftPos = new Coordinates(position.getXpos(),position.getYpos() + this.entitySize - 1);
          this.bottomRightPos = new Coordinates(position.getXpos() + this.entitySize - 1,position.getYpos());
     }
     public void move(Direction dir){

          switch(dir){
               case UP:
                    position.setYpos(position.getYpos() - this.speed);
                    break;
               case DOWN:
                    position.setYpos(position.getYpos() + this.speed);
                    break;
               case RIGHT:
                    position.setXpos(position.getXpos() + this.speed);
                    break;
               case LEFT:
                    position.setXpos(position.getXpos() - this.speed);
                    break;

          }

     }

     public Coordinates getPosition(){
          return this.position;
     }

     public void moveToPosition(Coordinates newPosition){
          this.position = newPosition;
     }
     public boolean isAlive(){
          return this.alive;
     }

     public int getNumberOfLives(){
          return this.numberOfLives;
     }

     public void loseLives(){
          if (this.numberOfLives > 0){
               this.numberOfLives--;
          }
          else{
               this.numberOfLives = 0;
               this.alive = false;
          }
     }

     public void setSpeed(float speed){
          this.speed = speed;
     }

     public float getXpos(){
          return this.position.getXpos();
     }

     public float getYpos(){
          return this.position.getYpos();
     }

     public int getEntitySize(){
          return  this.entitySize;
     }

     private boolean isIn(Coordinates coordinates){
          boolean isWithInX = coordinates.getXpos() >= this.position.getXpos() &&
                              coordinates.getXpos() <= this.topRightPos.getXpos();

          boolean isWithInY = coordinates.getYpos() >= this.position.getYpos() &&
                  coordinates.getYpos() <= this.topRightPos.getYpos();

          return isWithInX && isWithInY;
     }

     public boolean collide(Entity obj){

          return obj.isIn(this.bottomRightPos) ||
               obj.isIn(this.position) ||
               obj.isIn(this.topLeftPos) ||
               obj.isIn(topRightPos);
     }

}
