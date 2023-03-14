package bulelani.space_invaders.gamepanel;

import bulelani.space_invaders.Coordinates.Coordinates;
import bulelani.space_invaders.Entity.Entity;
import bulelani.space_invaders.keyandler.KeyHandler;
import bulelani.space_invaders.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
   //Screen settings
    public int originalEntitySize = 16;
    public final int scale = 3;

    private Thread gameThread;

    public KeyHandler key = new KeyHandler();

    private final int FPS = 100;

    private Player player = new Player(new Coordinates(920,1032),1   );

    public int entitySize = originalEntitySize * scale;

    private final int maxScreenCol = 40;//27
    private final int maxScreenRow = 23;//19
    private final int  screenWidth = entitySize * maxScreenCol;// 1920

   private final int  screenHeight = (entitySize * maxScreenRow) - 24;//1080

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
       double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){

            // Update: update information of the game entity
            update();
            // DRAW: draw the update entity information
            repaint();


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                Thread.sleep((long)remainingTime);
                nextDrawTime +=drawInterval;

            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public void update(){
        player.updatePlayer(key);
    }

    public void paintComponent(Graphics g){

       super.paintComponent(g);
       Graphics2D g2 = (Graphics2D) g;
       g2.setColor(Color.white);
       Coordinates pos = player.getPosition();
       g2.fillRect((int)player.getXpos(),(int)player.getYpos(),entitySize,entitySize);
       g2.dispose();
   }
}
