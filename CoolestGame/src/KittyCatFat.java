import java.awt.*;

/**
 * Created by cassandra_varnau on 3/15/17.
 */
public class KittyCatFat extends Sprite{
    public KittyCatFat(World aWorld){
        super(aWorld);
        setPic(" ", NORTH);
        setLoc(new Point(100, 100));
        setSpeed(this.getBoundingRectangle().height);
    }
    //this is the cat that eats the other cats.
    @Override
    public void update() {

        if (this.facingEast() || this.facingWest()) {
            setPic("", NORTH);
        }
        if( this.facingNorth() || this.facingSouth()){
            setPic("", NORTH);
        }

        super.update();
    }


}
