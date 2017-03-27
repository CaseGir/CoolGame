import java.awt.*;

/**
 * Created by cassandra_varnau on 3/15/17.
 */
public class KittyCatFat extends Sprite{

    private int steps, maxSteps;


    public KittyCatFat(int x, int y, int nSteps, World world){
        super(x,y, EAST, world);
        steps = 0;
        maxSteps = nSteps;
        setPic("baseCat.png", NORTH);
    }
    @Override
    public void update(){

        if(steps == maxSteps){
            steps = 0;
            rotateBy(-90);
        }
        steps++;
        super.update();
    }
}