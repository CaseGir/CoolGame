import java.awt.*;

/**
 * Created by cassandra_varnau on 3/16/17.
 */
public class GodCat extends FoodCat {
    //better food

    public GodCat(World aworld) {
        super(aworld);
        setPic("baseCat.png", NORTH);
        int a = (int)((Math.random() * 1200));
        int b = (int)((Math.random() * 800 ));
        setLoc(new Point(a,b));
        setSpeed(1);
    }

    @Override
    public void update(){

    }

}
