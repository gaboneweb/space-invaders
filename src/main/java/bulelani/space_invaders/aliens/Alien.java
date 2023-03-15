package bulelani.space_invaders.aliens;

import bulelani.space_invaders.Coordinates.Coordinates;
import bulelani.space_invaders.Entity.Entity;
import bulelani.space_invaders.direction.Direction;

public class Alien extends Entity {
    public Alien(Coordinates position, int numberOfLives) {
        super(position, numberOfLives);
        this.setSpeed((float)1.5);
    }

    public boolean isOutOfBounds(){
        if (this.position.getXpos() <= 0 || this.position.getXpos() >= 1294){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public void move(Direction dir){

        switch(dir){
            case UP:
                position.setYpos(position.getYpos() - this.speed);
                break;
            case DOWN:
                position.setYpos(position.getYpos() + (float)10);
                break;
            case RIGHT:
                position.setXpos(position.getXpos() + this.speed);
                break;
            case LEFT:
                position.setXpos(position.getXpos() - this.speed);
                break;

        }

    }
}
