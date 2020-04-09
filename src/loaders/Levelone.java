package loaders;

import entity.Modelo;
import entity.Pisodos;
import entity.Pisouno;
import entity.Player;
import entity.River;
import game.WindowCanvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import states.Manager;
import states.State;

public class Levelone extends State {

    private Image background;
    private Player player;
    private River river;

    private ArrayList<Pisouno> pisounos;

    private Pisodos[] turtle1;
    private Pisodos[] item2;
    private Pisodos[] item3;
    private Pisodos[] turtle2;
    private Pisodos[] item5;

    public Levelone(Manager manager) {
        super(manager);

        background = new ImageIcon(getClass().getResource("/image/background.png")).getImage();
        river = new River();
        pisounos = new ArrayList();

        pisounos.add(new Pisouno(0, 295, "/image/car_c_0.png", 54, 20, 1, "left"));
        pisounos.add(new Pisouno(96, 295, "/image/car_c_0.png", 54, 20, 1, "left"));
        pisounos.add(new Pisouno(264, 295, "/image/car_c_0.png", 54, 20, 1, "left"));
        pisounos.add(new Pisouno(392, 295, "/image/car_c_0.png", 54, 20, 1, "left"));

        pisounos.add(new Pisouno(0, 417, "/image/car_a_0.png", 32, 28, 2, "right"));
        pisounos.add(new Pisouno(256, 417, "/image/car_a_0.png", 32, 28, 2, "right"));

        pisounos.add(new Pisouno(0, 358, "/image/car_b_0.png", 30, 20, 3, "left"));
        pisounos.add(new Pisouno(150, 358, "/image/car_b_0.png", 30, 20, 3, "left"));
        pisounos.add(new Pisouno(300, 358, "/image/car_b_0.png", 30, 20, 3, "left"));

        pisounos.add(new Pisouno(60, 388, "/image/car_d_0.png", 28, 24, 1, "right"));
        pisounos.add(new Pisouno(160, 388, "/image/car_d_0.png", 28, 24, 1, "right"));
        pisounos.add(new Pisouno(360, 388, "/image/car_d_0.png", 28, 24, 1, "right"));

        pisounos.add(new Pisouno(10, 322, "/image/car_e_0.png", 32, 28, 5, "right"));

//        turtle1 = new Pisodos(WindowCanvas.WIDTHCANVAS + 30, 220, 30, 30, 2);
//        turtle1.tortuga();
        item2 = new Pisodos[3];
        item2[0] = new Pisodos(128, 199, "/image/log_0.png", 84, 20, 2, "right");
        item2[1] = new Pisodos(320, 199, "/image/log_0.png", 84, 20, 2, "right");
        item2[2] = new Pisodos(384, 199, "/image/log_0.png", 84, 20, 2, "right");

        item3 = new Pisodos[3];
        item3[0] = new Pisodos(0, 168, "/image/log_0.png", 84, 20, 1, "right");
        item3[1] = new Pisodos(160, 168, "/image/log_0.png", 84, 20, 1, "right");
        item3[2] = new Pisodos(320, 168, "/image/log_0.png", 84, 20, 1, "right");
//        turtle2 = new Pisodos(WindowCanvas.WIDTHCANVAS + 30, 130, 30, 30, 3);
//        turtle2.tortuga();
        item5 = new Pisodos[4];
        item5[0] = new Pisodos(0, 103, "/image/log_0.png", 84, 20, 1, "right");
        item5[1] = new Pisodos(128, 103, "/image/log_0.png", 84, 20, 1, "right");
        item5[2] = new Pisodos(156, 103, "/image/log_0.png", 84, 20, 1, "right");
        item5[3] = new Pisodos(384, 103, "/image/log_0.png", 84, 20, 1, "right");

        player = new Player(28, 28);
        player.setModeloCarros(pisounos);
        player.setModeloTronquito(item2[0]);
        player.setRiver(river);
    }

    @Override
    public void update(double delta) {

        pisounos.forEach((pisouno) -> {
            pisouno.update(delta);
        });

//        turtle1.animationTurtle();
//        turtle1.moveleft();
        for (short i = 0; i < item2.length; i++) {
            item2[i].update(delta);
        }
        for (short i = 0; i < item3.length; i++) {
            item3[i].update(delta);
        }
//        turtle2.animationTurtle();
//        turtle2.moveleft();
        for (short i = 0; i < item5.length; i++) {
            item5[i].update(delta);
        }
        player.update(delta);
        river.update(delta);
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.drawImage(background, 0, 0, WindowCanvas.WIDTHCANVAS, WindowCanvas.HEIGHTCANVAS, null);
        
        river.render(g2d);
        
        pisounos.forEach((pisouno) -> {
            pisouno.render(g2d);
        });
//        turtle1.renderturtle(g2d);
        for (Pisodos pisodos : item2) {
            pisodos.render(g2d);
        }
        for (Pisodos pisodos : item3) {
            pisodos.render(g2d);
        }
//        turtle2.renderturtle(g2d);
        for (Pisodos pisodos : item5) {
            pisodos.render(g2d);
        }
        
        player.render(g2d);

    }

    @Override
    public void keyPressed(KeyEvent key) {
        player.keypressed(key);
    }

    @Override
    public void keyReleased(KeyEvent key) {
        player.keyReleased(key);
    }
}
