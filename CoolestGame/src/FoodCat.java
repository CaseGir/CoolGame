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
        int a = (int) ((Math.random() * 1000));
        int b = (int) ((Math.random() * 600));
        setLoc(new Point(a, b));
        setSpeed(1);
        int rand = (int) ((Math.random() * 8));
        if (rand <= 2)
            setPic("Food1.png", NORTH);
       else if(rand <= 4)
            setPic("Food2.png", NORTH);
       else if(rand <= 6)
            setPic("Food3.png", NORTH);
       else
            setPic("Food4.png", NORTH);
    }
}