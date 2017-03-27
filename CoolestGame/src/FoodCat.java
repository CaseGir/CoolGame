import java.awt.*;
import java.util.ArrayList;

/**
 * Created by cassandra_varnau on 3/15/17.
 */
public class FoodCat extends Sprite {

    private Rectangle leftSide, rightSide, top, bottom;
    private int width, height;

    public FoodCat(int x, int y, int w, int h) {
        super(x,y);
        width = w;
        height = h;
        leftSide = new Rectangle(-5, -5, 10, height+10);
        rightSide = new Rectangle(width-5, -5, 10, height+10);
        top = new Rectangle(-5, -5, width+10, 10);
        bottom = new Rectangle(-5, height-5, width+10, 10);
        setPic("", NORTH);
        int a = (int)((Math.random() * 1200));
        int b = (int)((Math.random() * 800 ));
        setLoc(new Point(a,b));
        setSpeed(1);
    }

    @Override
    public void update(){
        public boolean isOnScreen(x,y){
            return (x > -1 && x < width && y > -1 && y < height);
        }

        public boolean hitLeftSide(Sprite spr){
            Rectangle spriteBox = spr.getBoundingRectangle();
            if(spriteBox.intersects(leftSide))
                return true;
            return false;
        }
        public boolean hitRightSide(Sprite spr){
            Rectangle spriteBox = spr.getBoundingRectangle();
            if(spriteBox.intersects(rightSide))
                return true;
            return false;
        }
        public boolean hitTop(Sprite spr){
            Rectangle spriteBox = spr.getBoundingRectangle();
            if(spriteBox.intersects(top))
                return true;
            return false;
        }
        public boolean hitBottom(Sprite spr){
            Rectangle spriteBox = spr.getBoundingRectangle();
            if(spriteBox.intersects(bottom))
                return true;
            return false;
        }
    }

    // we will eat these to get bigger
    // they will randomly spawn
    // we will need more and more each time to level up
    //close to the end, we should also add different types of bait (like the angels/god) but maybe that's another class.

}
