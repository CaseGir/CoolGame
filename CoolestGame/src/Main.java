import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JPanel {

    public static final int FRAMEWIDTH = 1200, FRAMEHEIGHT = 800;

    private Timer timer;
    private World theWorld;
    private boolean[] keys;
    //ay wat up
    private Sprite KittyCatFat;


    public Main(){

        theWorld = new World(FRAMEWIDTH, FRAMEHEIGHT);

        //These are the Sprites that are added to the World...
//        theWorld.addSprite(new Sprite(800, 300, Sprite.SE, theWorld));

        System.out.println();

        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                repaint();
            }
        });
        timer.start();


        //EventListeners.  Not using them at the moment.

            //move the KittyCatFat
                if(keys[KeyEvent.VK_W]){
                KittyCatFat.setDir(Sprite.NORTH);
                KittyCatFat.update();
                keys[KeyEvent.VK_W] = false; //probably.
            }
                if(keys[KeyEvent.VK_D]){
                KittyCatFat.setDir(Sprite.EAST);
                KittyCatFat.update();
                keys[KeyEvent.VK_D] = false; //probably.
            }
                if(keys[KeyEvent.VK_A]){
                KittyCatFat.setDir(Sprite.WEST);
                KittyCatFat.update();
                keys[KeyEvent.VK_A] = false; //probably.
            }
                if(keys[KeyEvent.VK_S]){
                KittyCatFat.setDir(Sprite.SOUTH);
                KittyCatFat.update();
                keys[KeyEvent.VK_S] = false; //probably.
            }


        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                //Ask the world if any sprites contain the click
                theWorld.click(mouseEvent);

                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });


    }

    //Our paint method.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //Draws all the sprites.


    }

    //sets ups the panel and frame.
    public static void main(String[] args) {
        JFrame window = new JFrame("Cool Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT + 22); //(x, y, w, h) 20 due to title bar.

        Main panel = new Main();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();


        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}
