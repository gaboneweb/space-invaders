package bulelani.space_invaders.display;

import bulelani.space_invaders.Coordinates.Coordinates;

import bulelani.space_invaders.aliens.Alien;
import bulelani.space_invaders.aliens.AlienArmy;
import bulelani.space_invaders.player.Player;
import bulelani.space_invaders.projectiles.Missile;

import java.awt.*;
import java.util.ArrayList;

public class Display {
    public void drawPlayer(Graphics2D graphics, Player player){
        graphics.setColor(Color.green);
        Coordinates pos = player.getPosition();
        graphics.fillRect((int)player.getXpos(),(int)player.getYpos(),player.getEntitySize(),player.getEntitySize());
    }


    public void drawAliens(Graphics2D graphics, AlienArmy aliens) {
        graphics.setColor(Color.blue);

        for (Alien alien : aliens.getAliens()) {
            Coordinates pos = alien.getPosition();
//            graphics.fillRect((int) alien.getXpos(), (int) alien.getYpos(), entitySize, entitySize);
            graphics.fillOval((int) alien.getXpos(), (int) alien.getYpos(), alien.getEntitySize(), alien.getEntitySize());
        }
    }


    public void drawMissiles(Graphics2D graphics, ArrayList<Missile> bullets) {
        graphics.setColor(Color.blue);

        for (Missile bullet : bullets) {
            Coordinates pos = bullet.getPosition();
            graphics.fillRect((int) bullet.getXpos(), (int) bullet.getYpos(), bullet.getEntitySize(), bullet.getEntitySize());
        }
    }



}
