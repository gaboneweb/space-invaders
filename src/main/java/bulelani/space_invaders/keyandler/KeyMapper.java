package bulelani.space_invaders.keyandler;


import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import bulelani.space_invaders.direction.Direction;
import bulelani.space_invaders.gamepanel.GamePanel;
import bulelani.space_invaders.player.Player;

public class KeyMapper  {
    
    private Player player;
    private Action rightAction;
    private Action leftAction;
    private Action shootAction;


    public KeyMapper(Player player,GamePanel panel){
        System.out.println(System.getProperty("os.name").toLowerCase());
        this.player = player;

        this.leftAction = new LeftAction();
        this.rightAction = new RightAction();
        this.shootAction = new ShootAction();

        this.mapActions(panel);
    }


    private void mapActions(GamePanel panel){
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"),"rightAction" );
        panel.getActionMap().put("rightAction", this.rightAction);

        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"),"leftAction" );
        panel.getActionMap().put("leftAction", this.leftAction);

        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"),"spaceAction" );
        panel.getActionMap().put("spaceAction", this.shootAction);

        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"),"upAction" );
        panel.getActionMap().put("upAction", this.shootAction);
    }

    private class LeftAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            player.updatePlayer(Direction.LEFT);
        }

        
    }

    private class RightAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            player.updatePlayer(Direction.RIGHT);


        }
        
    }


    private class ShootAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            player.updatePlayer(Direction.UP);
        }
        
    }
    
}
