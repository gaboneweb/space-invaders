package bulelani.space_invaders.aliens;

import bulelani.space_invaders.Coordinates.Coordinates;
import bulelani.space_invaders.direction.Direction;
import bulelani.space_invaders.projectiles.Missile;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class AlienArmy {
    private final int numberOfAlienForRow = 10;
    ArrayList<Alien> aliens = new ArrayList<>();

    private ArrayList<Missile> bullets = new ArrayList<>();
    Direction currentDirection = Direction.RIGHT;

    private long lastShotTime = 0;

    private static final long SHOT_DELAY_MS = 750;

    public AlienArmy(int entitySize){
        createAliens(entitySize);

    }

    private void createAliens(int entitySize){

        int startY = 0;

        for (int i = 0; i < 4; i++){
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
        this.removeAliens();
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
        this.removeBullets();
        for(Alien alien : aliens){
            alien.move(currentDirection);
        }
        for(Missile missile: bullets){
            missile.move(Direction.DOWN);
        }
        this.armyShoot();

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
    private void removeBullets() {
        this.bullets = (ArrayList<Missile>) bullets.stream().filter(missile -> missile.isAlive()).collect(Collectors.toList());
    }

    private void removeAliens() {
        this.aliens = (ArrayList<Alien>) aliens.stream().filter(alien -> alien.isAlive()).collect(Collectors.toList());
    }

    public static <T> T getRandomElement(ArrayList<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("The list is empty.");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(list.size());

        return list.get(randomIndex);
    }
    public void armyShoot(){
            long now = System.currentTimeMillis();
            if (now - lastShotTime >= SHOT_DELAY_MS) {
                bullets.add(getRandomElement(this.aliens).shoot());
                lastShotTime = now;
            }
    }

    public ArrayList<Missile> getBullets(){
        return this.bullets;
    }
}
