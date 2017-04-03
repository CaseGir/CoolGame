import java.awt.*;

/**
 * Created by cassandra_varnau on 3/15/17.
 */
public class KittyCatFat extends Sprite{

    private int steps, maxSteps;
    private ProgressBar prog;


    public KittyCatFat(int x, int y, int dir, ProgressBar pro){
        super(x,y, dir);
        steps = 0;
        setPic("baseCat.png", NORTH);
        prog = pro;
    }
    @Override
    public void update(){

        super.update();
    }

}