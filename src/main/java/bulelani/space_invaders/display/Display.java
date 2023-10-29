package bulelani.space_invaders.display;


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
            graphics.fillOval((int) bullet.getXpos(), (int) bullet.getYpos(), bullet.getEntitySize(), bullet.getEntitySize());
        }
    }


    public void drawMissiles(Graphics2D graphics, ArrayList<Missile> bullets) {
        graphics.setColor(Color.green);

        for (Missile bullet : bullets) {
            ImageIcon image = new ImageIcon("./src/main/resources/images/missile_1.png");
            graphics.drawImage(image.getImage(),(int) bullet.getXpos(), (int) bullet.getYpos(), bullet.getEntitySize(), bullet.getEntitySize(),null);
        }
    }

    public void drawBackground(Graphics2D graphics,int width,int height){
        ImageIcon image = new ImageIcon("./src/main/resources/images/background_2.jpg");
        graphics.drawImage(image.getImage(), 0, 0,width,height, null);
    }

    public void drawPlayerLives(Graphics2D graphics,int playerLives){
        int startY = 0;
        int startX = 0;
        for(int i = 0; i < playerLives; i++){
            ImageIcon image = new ImageIcon("./src/main/resources/images/heart.png");
            graphics.drawImage(image.getImage(), startX, startY,48,48, null);
            startX += 60;
        }

    }

    public void drawScore(Graphics2D graphics,int playerScore,int screenWidth){
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Arial", Font.BOLD, 48));
        
        String scoreText = "Score: " + playerScore;
        
        graphics.drawString(scoreText, screenWidth/2 + screenWidth/4 , 48); // Adjust the coordinates as needed

    }

    public void gameOver(Graphics2D graphics,int screenWidth,int screenHeight){
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Arial", Font.BOLD, 100));
        
        String scoreText = "GAME OVER!!!!!!";
        
        graphics.drawString(scoreText, screenWidth/2 - screenWidth/4 , screenHeight/2 - screenHeight/4 ); // Adjust the coordinates as needed
    }



}
