package bulelani.space_invaders.display;

import bulelani.space_invaders.Coordinates.Coordinates;

import bulelani.space_invaders.player.Player;
import java.awt.*;

public class Display {
    public void drawPlayer(Graphics2D graphics, Player player, int entitySize){
        graphics.setColor(Color.green);
        Coordinates pos = player.getPosition();
        graphics.fillRect((int)player.getXpos(),(int)player.getYpos(),entitySize,entitySize);
    }


}
