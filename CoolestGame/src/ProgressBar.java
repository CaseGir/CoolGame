import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by cassandra_varnau on 3/28/17.
 */
public class ProgressBar{

        private int drawHealth, needyNeedy;
        private Sprite cat;
        private ArrayList<Sprite> kitties;



    public ProgressBar(int h, int n, Sprite c, ArrayList <Sprite> k) {
            drawHealth = h;
            needyNeedy = n;
            cat = c;
            kitties = k;

        }
        public void hit(){
            for(Sprite s : kitties){
                if(cat.intersects(s)){
                    drawHealth += 1;
                }
            }
        }

        public void paint(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, needyNeedy, 30); //draws healthbar outline
            g.setColor(Color.WHITE);
            g.fillRect(2, 2, drawHealth - 2, 26); //draws health
        }

    }