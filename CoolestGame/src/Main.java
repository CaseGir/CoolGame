
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JPanel {

    public static final int FRAMEWIDTH = 1200, FRAMEHEIGHT = 800;

    private Timer timer;
    private Sprite cat,instruct;
    private ProgressBar prog;
    private ArrayList<Sprite> kitties;
    private boolean[] keys;
    private int need, have;

    public Main() {
        need = 150;
        have = 0;
        keys = new boolean[512];
        cat = new KittyCatFat(100, 100,Sprite.NORTH, getProg());
        instruct = new Instruct(500,300,Sprite.EAST);
        kitties = new ArrayList<Sprite>();
        prog = new ProgressBar(have, need, getCat(), getKitties());
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

                prog.hit();  //Checks for intersections and stuff

                if(Math.random() < 0.06){
                    int a = (int)(Math.random()*1000);
                    int b = (int)(Math.random()*600);

                    int c = (int)(Math.random()*1000);
                    int d = (int)(Math.random()*600);

                    if (prog.needed() >= 1000){
                        kitties.add(new GodCat(a,b,Sprite.NORTH));
                        kitties.add(new FoodCat(c,d,Sprite.NORTH, prog));

                    }
                    else{
                        kitties.add(new FoodCat(a,b,Sprite.NORTH, prog));
                    }

                }
                if(prog.isFull() && prog.needed() >= 1050){
                    cat.setPic("Cat8.png", Sprite.NORTH);
                    prog.setHave();
                    prog.setNeed();
                }
                else if(prog.isFull() && prog.needed() >=900) {
                    cat.setPic("Cat7.png", Sprite.NORTH);
                    prog.setNeed();
                    prog.setHave();
                }
                else if(prog.isFull() && prog.needed() >=750) {
                    cat.setPic("Cat6.png", Sprite.NORTH);
                    prog.setHave();
                    prog.setNeed();
                }
                else if(prog.isFull() && prog.needed() >=600) {
                    cat.setPic("Cat5.png", Sprite.NORTH);
                    prog.setHave();
                    prog.setNeed();
                }
                else if(prog.isFull() && prog.needed() >=450) {
                    cat.setPic("Cat4.png", Sprite.NORTH);
                    prog.setHave();
                    prog.setNeed();
                }
                else if(prog.isFull() && prog.needed() >=300) {
                    cat.setPic("Cat3.png", Sprite.NORTH);
                    prog.setHave();
                    prog.setNeed();
                }
                else if(prog.isFull() && prog.needed() >=150) {
                    cat.setPic("Cat2.png", Sprite.NORTH);
                    prog.setHave();
                    prog.setNeed();
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
            int a = (int)(Math.random()*1000);
            int b = (int)(Math.random()*600);
            kitties.add(new FoodCat(a,b,Sprite.NORTH, prog));
        }
    }

    //Our paint method.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(new Color(206, 255, 195));
        g2.fillRect(0,0,1200,800);
        g2.setColor(new Color(173, 232, 154));
        g2.fillRect(100,300,300,200);
        g2.fillRect(800,100,200,300);
        g2.fillRect(500,600,300,200);
        g2.fillRect(100,100,200,300);
        g2.fillRect(900,400,300,300);
        g2.fillRect(800,50,300,200);
        g2.fillRect(450,100,250,200);
        g2.fillRect(50,600,300,200);
        instruct.draw(g2);
        //Draws all the sprites.
        for(Sprite s: kitties){
            s.draw(g2);
        }
        cat.draw(g2);
        prog.paint(g2);

    }

    //sets ups the panel and frame.
    public static void main(String[] args) {

        JFrame window = new JFrame("KITTY EVOLUTION");
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


    public Sprite getCat(){return cat;}
    public ArrayList getKitties(){return kitties;}
    public ProgressBar getProg(){return prog;}

}