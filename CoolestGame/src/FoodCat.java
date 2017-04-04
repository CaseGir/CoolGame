import java.awt.*;
import java.util.ArrayList;


/**
 * Created by cassandra_varnau on 3/15/17.
 */
public class FoodCat extends Sprite {

    private ProgressBar prog;

    public FoodCat(int xx, int yy, int dir, ProgressBar pro) {
        super(xx, yy, dir);
        prog = pro;
        setPic("baseCat.png", NORTH);
        int a = (int) ((Math.random() * 1200));
        int b = (int) ((Math.random() * 800));
        setLoc(new Point(a, b));
        setSpeed(1);
    }
}