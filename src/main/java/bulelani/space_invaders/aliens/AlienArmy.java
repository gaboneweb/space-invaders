package bulelani.space_invaders.aliens;

import bulelani.space_invaders.Coordinates.Coordinates;
import bulelani.space_invaders.direction.Direction;

import java.util.ArrayList;

public class AlienArmy {
    private final int numberOfAlienForRow = 10;
    ArrayList<Alien> aliens = new ArrayList<>();
    Direction currentDirection = Direction.RIGHT;

    public AlienArmy(int entitySize){
        createAliens(entitySize);

    }

    private void createAliens(int entitySize){

        int startY = 0;

        for (int i = 0; i < 3; i++){
            int startX = 196;
            for(int j = 0; j < this.numberOfAlienForRow; j++ ){
                this.aliens.add(new Alien(new Coordinates((float)startX,(float)startY), 1,entitySize));
                startX += 96;
            }
            startY += 96;
        }

    }

    public ArrayList<Alien> getAliens() {
        return this.aliens;
    }


    public void updateAliens(){
        Direction prevDir = currentDirection;
        if(isAtTheBound()){
            currentDirection = Direction.DOWN;
            updateDateDir();
            changeDir(prevDir);
            updateDateDir();
        }
        else{
            updateDateDir();
        }

    }

    public void updateDateDir(){
        for(Alien alien : aliens){
            alien.move(currentDirection);
        }
    }

    public boolean isAtTheBound(){
        return aliens.stream().anyMatch(alien -> alien.isOutOfBounds());
    }

    private void changeDir(Direction dir){
        if(dir == Direction.RIGHT){
            currentDirection = Direction.LEFT;
        }
        else{
            currentDirection = Direction.RIGHT;
        }
    }
}
