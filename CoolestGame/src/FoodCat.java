import java.awt.*;

/**
 * Created by cassandra_varnau on 3/15/17.
 */
public class FoodCat extends Sprite {

    public FoodCat(World aworld) {
        super(aworld);
        setPic("", NORTH);
        int a = (int)((Math.random() * 1200));
        int b = (int)((Math.random() * 800 ));
        setLoc(new Point(a,b));
        setSpeed(1);
    }

    @Override
    public void update(){

    }
    // we will eat these to get bigger
    // they will randomly spawn
    // we will need more and more each time to level up
    //close to the end, we should also add different types of bait (like the angels/god) but maybe that's another class.

}
