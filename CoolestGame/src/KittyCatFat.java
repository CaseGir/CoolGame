import java.awt.*;

/**
 * Created by cassandra_varnau on 3/15/17.
 */
public class KittyCatFat extends Sprite{

    private int steps, maxSteps;


    public KittyCatFat(int x, int y, int dir){
        super(x,y, EAST);
        steps = 0;
        setPic("baseCat.png", NORTH);
    }
    @Override
    public void update(){

        super.update();
    }

}