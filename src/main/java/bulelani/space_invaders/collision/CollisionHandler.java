package bulelani.space_invaders.collision;

import bulelani.space_invaders.aliens.Alien;
import bulelani.space_invaders.aliens.AlienArmy;
import bulelani.space_invaders.player.Player;
import bulelani.space_invaders.projectiles.Missile;

public class CollisionHandler {
    private int pointsEarned = 0;

    private void checkBulletAlienCollisions(Player player, AlienArmy aliens) {
        // Implement the collision detection logic between bullets and aliens
        // Update the game state accordingly (e.g., remove collided entities, update scores, etc.)
        for(Alien alien : aliens.getAliens()){
            for(Missile bullet: player.getBullets()){
                if(alien.isAlive() && bullet.isAlive() && alien.collide(bullet)){
                    alien.loseLives();
                    bullet.loseLives();
                    pointsEarned+= 30;
                }
            }
        }

    }

    private void checkBulletPlayerCollisions(Player player, AlienArmy aliens) {
        // Implement the collision detection logic between bullets and aliens
        // Update the game state accordingly (e.g., remove collided entities, update scores, etc.)
        for(Missile bullet: aliens.getBullets()){
            if(player.collide(bullet)){
                player.loseLives();
                bullet.loseLives();
                
                break;
            }
        }
    }

    public void checkCollisions(Player player,AlienArmy aliens){
        checkBulletPlayerCollisions(player, aliens);
        checkBulletAlienCollisions(player, aliens);
    }

    public int getPointEarned(){
        int temp = pointsEarned;
        pointsEarned = 0;
        return temp;
    }

}
