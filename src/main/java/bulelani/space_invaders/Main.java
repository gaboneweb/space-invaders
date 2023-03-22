package bulelani.space_invaders;

import bulelani.space_invaders.gamepanel.GamePanel;
import bulelani.space_invaders.window.Window;

public class Main {

    public static void main(String[] args){
        Window window = new Window();
        GamePanel screen = new GamePanel();

        window.addGamePanel(screen);

    }
}
