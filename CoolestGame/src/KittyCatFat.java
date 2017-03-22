

/**
 * Created by cassandra_varnau on 3/15/17.
 */
public class KittyCatFat extends Sprite{


    public KittyCatFat(){
        super(600, 700, NORTH);
        setSpeed(this.getBoundingRectangle().height);
    }
    @Override
    public void update() {

        if (this.facingEast() || this.facingWest()) {
            setPic("baseCat.png", NORTH);
        }
        if( this.facingNorth() || this.facingSouth()){
            setPic("baseCat.png", NORTH);
        }

        super.update();
    }

}
