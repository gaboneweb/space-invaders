package bulelani.space_invaders.gamepanel;

import bulelani.space_invaders.Coordinates.Coordinates;
import bulelani.space_invaders.aliens.AlienArmy;
import bulelani.space_invaders.collision.CollisionHandler;
import bulelani.space_invaders.display.Display;
import bulelani.space_invaders.keyandler.KeyHandler;
import bulelani.space_invaders.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    private int score = 0;
   //Screen settings
    public int originalEntitySize = 16;
    public final int scale = 3;

    private Thread gameThread;

    public KeyHandler key = new KeyHandler();

    private final int FPS = 100;

    private Display display = new Display();

    public int entitySize = originalEntitySize * scale;

    private Player player = new Player(new Coordinates(672,720),3,entitySize  );

    private AlienArmy aliens = new AlienArmy(entitySize);

    private CollisionHandler collisionHandler = new CollisionHandler();

    private final int maxScreenCol = 28;//28
    private final int maxScreenRow = 16;//16
    private final int  screenWidth = entitySize * maxScreenCol;// 1344

    private final int  screenHeight = (entitySize * maxScreenRow);//768

   public GamePanel(){
     this.setPreferredSize(new Dimension(screenWidth,screenHeight));
     this.setBackground(Color.BLACK);
     this.setDoubleBuffered(true);
     this.addKeyListener(key);
     this.setFocusable(true);
     startGameThread();
   }
    public void startGameThread(){
       this.gameThread = new Thread(this);
       this.gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;


        while(gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/ drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                // Update: update information of the game entity
                update();
                // DRAW: draw the update entity information
                repaint();

                delta--;
            }


        }
    }
    public void update(){
        if(player.isAlive() &&  !aliens.isAllDead()){
            player.updatePlayer(key);
            player.updatePlayerMissiles();
            aliens.updateAliens();
            collisionHandler.checkCollisions(player, aliens);
            score += collisionHandler.getPointEarned();
        }
    }

    public void paintComponent(Graphics g){

       super.paintComponent(g);
       Graphics2D g2 = (Graphics2D) g;
       display.drawBackground(g2, screenWidth, screenHeight);
       display.drawPlayer(g2,player);
       display.drawAliens(g2,aliens);
       display.drawMissiles(g2,player.getBullets());
       display.drawAlienMissiles(g2,aliens);
       display.drawPlayerLives(g2, player.getNumberOfLives());
       display.drawScore(g2, score, screenWidth);
       if(!player.isAlive() ||  aliens.isAllDead()){
            display.gameOver(g2, screenWidth, screenHeight);
       }
       g2.dispose();
   }

   
}




//The sleep method for the game loop
//    @Override
//    public void run() {
//       double drawInterval = 1000000000/FPS;
//       double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while(gameThread != null){
//
//            // Update: update information of the game entity
//            update();
//            // DRAW: draw the update entity information
//            repaint();
//
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000;
//                Thread.sleep((long)remainingTime);
//                nextDrawTime +=drawInterval;
//
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//
//        }
//    }
