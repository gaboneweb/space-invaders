package bulelani.space_invaders.window;

import bulelani.space_invaders.gamepanel.GamePanel;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class Window {
    private final JFrame window;

    public Window(){
        this.window = new JFrame();
        this.initSettings();
    }

    public void initSettings(){
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setResizable(false);
        this.window.setTitle("Space Invaders");
        this.window.setLocationRelativeTo(null);
        this.window.setVisible(true);
        this.window.setLocation(20, 0);
    }

    public void addGamePanel(GamePanel panel){
        this.window.add(panel);
        this.window.pack();
    }
}
