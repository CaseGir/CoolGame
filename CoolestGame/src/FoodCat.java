import java.awt.*;
import java.util.ArrayList;

/**
 * Created by cassandra_varnau on 3/15/17.
 */
public class FoodCat extends Sprite {

    private Rectangle leftSide, rightSide, top, bottom;
    private int vx, vy;

    public FoodCat(int x, int y, int vx, int vy) {
       super(x,y);
        this.vx = vx;
        this.vy = vy;
        setPic("baseCat", NORTH);
//        int a = (int)((Math.random() * 1200));
//        int b = (int)((Math.random() * 800 ));
//        setLoc(new Point(a,b));
        setSpeed(1);
    }

        public void move(int w, int h){

            if( x <= 0 ) {  //left side bounce
                vx = -vx;
                x = 0;
            }
            if( y <= 0) {  //top side bounce
                vy = -vy;
                y = 0;
            }
            if( x + getBoundingRectangle() >= w) {  //right side bounce
                vx = -vx;
                x = w - getBoundingRectangle();
            }
            if( y + getBoundingRectangle() >= h) {   //bottom side bounce
                vy = -vy;
                y = h - getBoundingRectangle();
            }
            x += vx;
            y += vy;
        }

    }

    // we will eat these to get bigger
    // they will randomly spawn
    // we will need more and more each time to level up
    //close to the end, we should also add different types of bait (like the angels/god) but maybe that's another class.
