import java.awt.*;

/**
 * Created by cassandra_varnau on 3/16/17.
 */
public class GodCat extends Sprite {
    //better food

    public GodCat(int x, int y, int nSteps){
        super(x,y, EAST);
        setPic("GodCat.png", NORTH);
        int a = (int)((Math.random() * 1200));
        int b = (int)((Math.random() * 800 ));
        setLoc(new Point(a,b));
        setSpeed(1);
    }

    @Override
    public void update(){

    }

}
