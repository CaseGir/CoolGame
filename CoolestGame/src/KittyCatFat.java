import java.awt.*;

/**
 * Created by cassandra_varnau on 3/15/17.
 */
public class KittyCatFat extends Sprite{
    public KittyCatFat(World aWorld){
        super(aWorld);
        setPic("baseCat.png", NORTH);
        setLoc(new Point(100, 100));
    }
    //this is the cat that eats the other cats.
    @Override
    public void update() {
        World w = getWorld();
        if(w.hitRightSide(this) && facingEast()){
            setDir(SOUTH);
            getLoc().translate(-getSpeed(), 0);
        }
        if(w.hitLeftSide(this)&& facingWest()){
            setDir(NORTH);
            getLoc().translate(getSpeed(), 0);
        }
        if(w.hitTop(this) && facingNorth()){
            setDir(EAST);

            getLoc().translate(0, getSpeed());
        }
        if(w.hitBottom(this) && facingSouth()){
            setDir(WEST);
            getLoc().translate(0, -getSpeed());
        }
        super.update();
    }
    //this must level up each time it gets a certain amount of FoodCats


}
