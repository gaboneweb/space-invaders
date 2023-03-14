package bulelani.space_invaders.player;

import bulelani.space_invaders.Coordinates.Coordinates;
import bulelani.space_invaders.Entity.Entity;
import bulelani.space_invaders.direction.Direction;
import bulelani.space_invaders.keyandler.KeyHandler;

public class Player extends Entity {
    public Player(Coordinates position, int numberOfLives) {
        super(position, numberOfLives);
    }

    @Override
    public void move(Direction dir){
        switch(dir){
            case RIGHT:
                this.position.setXpos(this.position.getXpos() + this.speed);
                if (this.isOutOfBounds()){
                    this.position.setXpos((float)1294);
                }
                break;
            case LEFT:
                this.position.setXpos(this.position.getXpos() - this.speed);
                if (this.isOutOfBounds()){
                    this.position.setXpos((float)0);
                }
                break;

        }
    }

    public void updatePlayer(KeyHandler key){
        if(key.leftPressed){
            this.move(Direction.LEFT);

        }
        else if(key.rightPressed ) {
            this.move(Direction.RIGHT);
        }
        else if(key.downPressed){
            this.move(Direction.DOWN);
        }else if(key.upPressed){
            this.move(Direction.UP);
        }
    }

    private boolean isOutOfBounds(){
        if (this.position.getXpos() < 0 || this.position.getXpos() > 1294){
            return true;
        }
        else{
            return false;
        }
    }
}
