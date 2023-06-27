package bulelani.space_invaders.projectiles;

import bulelani.space_invaders.Coordinates.Coordinates;
import bulelani.space_invaders.Entity.Entity;
import bulelani.space_invaders.direction.Direction;

public class Missile extends Entity {

    public Missile(Coordinates position, int numberOfLives,int entitySize) {
        super(position, numberOfLives,entitySize);
    }

    @Override
    public void move(Direction dir){

        switch(dir){
            case UP:
                position.setYpos(position.getYpos() - this.speed);
                break;
            case DOWN:
                position.setYpos(position.getYpos() + this.speed);
                break;

        }

    }
}
