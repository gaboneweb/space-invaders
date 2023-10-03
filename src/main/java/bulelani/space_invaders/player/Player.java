package bulelani.space_invaders.player;

import bulelani.space_invaders.Coordinates.Coordinates;
import bulelani.space_invaders.Entity.Entity;
import bulelani.space_invaders.direction.Direction;
import bulelani.space_invaders.keyandler.KeyHandler;
import bulelani.space_invaders.projectiles.Missile;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Player extends Entity {

    private ArrayList<Missile> bullets = new ArrayList<>();

    private long lastShotTime = 0;

    private static final long SHOT_DELAY_MS = 700;
    public Player(Coordinates position, int numberOfLives,int entitySize) {
        super(position, numberOfLives,entitySize);
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
        if(key.leftPressed && this.isAlive()){
            this.move(Direction.LEFT);
        }
        else if(key.rightPressed &&  this.isAlive()) {
            this.move(Direction.RIGHT);
        }else if(key.upPressed || key.spacePressed && this.isAlive()){
            this.shoot();
        }
    }

    public void updatePlayerMissiles(){
        this.removeBullets();
        for(Missile bullet: bullets){
            if(bullet.isAlive()){
                bullet.move(Direction.UP);
            }
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

    private void shoot(){
        long now = System.currentTimeMillis();
        if (now - lastShotTime >= SHOT_DELAY_MS) {
            bullets.add(new Missile(new Coordinates(this.getXpos() + (float) 15, this.getYpos() - (float) 16), 1,this.getEntitySize()/3));
            lastShotTime = now;
        }
    }

    public ArrayList<Missile> getBullets(){
        return this.bullets;
    }

    private void removeBullets() {
        this.bullets = (ArrayList<Missile>) bullets.stream().filter(missile -> missile.isAlive()).collect(Collectors.toList());
    }
}
