import java.awt.*;
/**
 * Created by crystal_wong on 4/6/17.
 */
public class Instruct extends Sprite {
    public Instruct(int x, int y, int dir){
        super(x,y,dir);
        setSpeed(0);
        setPic("instructions.jpg", EAST);
    }
}
