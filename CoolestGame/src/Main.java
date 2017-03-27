/**
 *
 * to do:
 - find more cats for the thing to turn into
 - make Sprite bounce off walls
 - make a bar to show how many we have eaten - make this number increase once the goal is reached
 - make Food randomly spawn
    - if the number needed for food is 500, then also have GodCat you can eat
 - these will be worth more in the food bar
 - make a cool window that will explain what it is if an icon is clicked
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JPanel {

    public static final int FRAMEWIDTH = 1200, FRAMEHEIGHT = 800;

    private Timer timer;
    private Sprite cat;

    private boolean[] keys;

    public Main() {
        keys = new boolean[512];
        cat = new KittyCatFat(100, 100,Sprite.EAST);

        loadlevel(1);
        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //This will call update on each sprite.
                if(keys[KeyEvent.VK_W] ) {
                    cat.setDir(Sprite.NORTH);
                    cat.update();
                }
                if(keys[KeyEvent.VK_A] ) {
                    cat.setDir(Sprite.WEST);
                    cat.update();
                }
                if(keys[KeyEvent.VK_D] ) {
                    cat.setDir(Sprite.EAST);
                    cat.update();
                }
                if(keys[KeyEvent.VK_S] ) {
                    cat.setDir(Sprite.SOUTH);
                    cat.update();
                }

                repaint();
            }
        });
        timer.start();


        //EventListeners.  Not using them at the moment.
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                keys[keyEvent.getKeyCode()] = true;
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                keys[keyEvent.getKeyCode()] = false;

            }
        });

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                //Ask the world if any sprites contain the click
//                theWorld.click(mouseEvent);

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

    public void loadlevel (int level) {

        if (level == 1) {
            new GodCat(400, 400,Sprite.EAST);
        }
    }
    //Our paint method.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(new Color(7, 175, 82));
        g2.fillRect(0,0,1200,800);

        //Draws all the sprites.
        theWorld.drawSprites(g2);

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