package bulelani.space_invaders.Entity;


import bulelani.space_invaders.Coordinates.Coordinates;
import bulelani.space_invaders.direction.Direction;

public class Entity {
     protected Coordinates position;
     protected   float speed = (float) 4;

     protected  int numberOfLives;

     protected int entitySize;

     protected Coordinates topRightPos;

     Coordinates bottomLeftPos;

     Coordinates bottomRightPos;


     protected  boolean alive = true;

     public Entity(Coordinates position, int numberOfLives,int entitySize){
          this.numberOfLives = numberOfLives;
          this.position = position;
          this.entitySize = entitySize;
          this.topRightPos = new Coordinates(position.getXpos() + this.entitySize - 1,position.getYpos());
          this.bottomLeftPos = new Coordinates(position.getXpos(),position.getYpos() + this.entitySize - 1);
          this.bottomRightPos = new Coordinates(position.getXpos() + this.entitySize - 1,position.getYpos()+ this.entitySize - 1);
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
          if (this.numberOfLives > 1){
               this.numberOfLives--;
               if(this.numberOfLives == 0){
                    this.alive =false;
               }
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

     public boolean collide(Entity obj){

          // Check if this entity's right edge is to the left of the other entity's left edge
          boolean isLeftOf = this.position.getXpos() + this.entitySize < obj.position.getXpos();
          
          // Check if this entity's left edge is to the right of the other entity's right edge
          boolean isRightOf = this.position.getXpos() > obj.position.getXpos() + obj.entitySize;

          // Check if this entity's bottom edge is above the other entity's top edge
          boolean isAbove = this.position.getYpos() + this.entitySize < obj.position.getYpos();

          // Check if this entity's top edge is below the other entity's bottom edge
          boolean isBelow = this.position.getYpos() > obj.position.getYpos() + obj.entitySize;

          // If any of the conditions above are true, there is no collision
          return !(isLeftOf || isRightOf || isAbove || isBelow);
     }

}
