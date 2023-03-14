package bulelani.space_invaders.Coordinates;

public class Coordinates {
    private float xPos;
    private float yPos;

    public Coordinates(float x , float y){
        this.xPos = x;
        this.yPos = y;
    }

    public Coordinates(){
        this((float)0,(float) 0);
    }

    public void setXpos(float x){
        this.xPos = x;
    }

    public void setYpos(float y){
        this.yPos = y;
    }

    public float getXpos(){
        return this.xPos;
    }

    public float getYpos(){
        return this.yPos;
    }
}
