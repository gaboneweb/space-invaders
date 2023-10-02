package bulelani.space_invaders.display;

import bulelani.space_invaders.Coordinates.Coordinates;

import bulelani.space_invaders.aliens.Alien;
import bulelani.space_invaders.aliens.AlienArmy;
import bulelani.space_invaders.player.Player;
import bulelani.space_invaders.projectiles.Missile;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Display {
    public void drawPlayer(Graphics2D graphics, Player player){
        graphics.setColor(Color.green);
        Coordinates pos = player.getPosition();
        ImageIcon image = new ImageIcon("./src/main/resources/images/player.png");
        graphics.drawImage(image.getImage(),(int)player.getXpos(),(int)player.getYpos(),player.getEntitySize(),player.getEntitySize(),null);
    }


    public void drawAliens(Graphics2D graphics, AlienArmy aliens) {
        graphics.setColor(Color.blue);

        for (Alien alien : aliens.getAliens()) {
            ImageIcon image = new ImageIcon("./src/main/resources/images/alien.png");
            graphics.drawImage(image.getImage(), (int) alien.getXpos(), (int) alien.getYpos(),alien.getEntitySize(), alien.getEntitySize(), null);
            //graphics.fillOval((int) alien.getXpos(), (int) alien.getYpos(), alien.getEntitySize(), alien.getEntitySize());
        }
    }

    public void drawAlienMissiles(Graphics2D graphics, AlienArmy aliens){
        graphics.setColor(Color.yellow);

        for (Missile bullet : aliens.getBullets()) {
            Coordinates pos = bullet.getPosition();
            graphics.fillOval((int) bullet.getXpos(), (int) bullet.getYpos(), bullet.getEntitySize(), bullet.getEntitySize());
        }
    }


    public void drawMissiles(Graphics2D graphics, ArrayList<Missile> bullets) {
        graphics.setColor(Color.green);

        for (Missile bullet : bullets) {
            Coordinates pos = bullet.getPosition();
            ImageIcon image = new ImageIcon("./src/main/resources/images/missile_1.png");
            graphics.drawImage(image.getImage(),(int) bullet.getXpos(), (int) bullet.getYpos(), bullet.getEntitySize(), bullet.getEntitySize(),null);
        }
    }

    public void drawBackground(Graphics2D graphics,int width,int height){
        ImageIcon image = new ImageIcon("./src/main/resources/images/background_2.jpg");
        graphics.drawImage(image.getImage(), 0, 0,width,height, null);
    }



}
