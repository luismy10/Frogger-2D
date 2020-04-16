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

    private ArrayList<Pisodos> pisodoses;

    public Levelone(Manager manager) {
        super(manager);

        background = new ImageIcon(getClass().getResource("/image/background.png")).getImage();
        river = new River();
        pisounos = new ArrayList();

        pisodoses = new ArrayList();

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

        Pisodos turtle11 = new Pisodos(WindowCanvas.WIDTHCANVAS + 30, 225, 30, 30, 2, "left", true);
        turtle11.tortuga();
        Pisodos turtle12 = new Pisodos(WindowCanvas.WIDTHCANVAS + 30 + 30, 225, 30, 30, 2, "left", true);
        turtle12.tortuga();
        Pisodos turtle13 = new Pisodos(WindowCanvas.WIDTHCANVAS + 30 + 30 + 30, 225, 30, 30, 2, "left", true);
        turtle13.tortuga();
        pisodoses.add(turtle11);
//        pisodoses.add(turtle12);
//        pisodoses.add(turtle13);

        pisodoses.add(new Pisodos(128, 199, "/image/log_0.png", 84, 20, 2, "right"));
        pisodoses.add(new Pisodos(320, 199, "/image/log_0.png", 84, 20, 2, "right"));
        pisodoses.add(new Pisodos(384, 199, "/image/log_0.png", 84, 20, 2, "right"));

        pisodoses.add(new Pisodos(0, 168, "/image/log_0.png", 84, 20, 1, "right"));
        pisodoses.add(new Pisodos(160, 168, "/image/log_0.png", 84, 20, 1, "right"));
        pisodoses.add(new Pisodos(320, 168, "/image/log_0.png", 84, 20, 1, "right"));

        Pisodos turtle2 = new Pisodos(WindowCanvas.WIDTHCANVAS + 30, 130, 30, 30, 1, "left", true);
        turtle2.tortuga();
        pisodoses.add(turtle2);

        pisodoses.add(new Pisodos(0, 103, "/image/log_0.png", 84, 20, 1, "right"));
        pisodoses.add(new Pisodos(128, 103, "/image/log_0.png", 84, 20, 1, "right"));
        pisodoses.add(new Pisodos(156, 103, "/image/log_0.png", 84, 20, 1, "right"));
        pisodoses.add(new Pisodos(384, 103, "/image/log_0.png", 84, 20, 1, "right"));

        player = new Player(28, 28);
        player.setModeloCarros(pisounos);
        player.setModeloTronquito(pisodoses);
        player.setRiver(river);
    }

    @Override
    public void update(double delta) {

        pisounos.forEach((pisouno) -> {
            pisouno.update(delta);
        });

        pisodoses.forEach((pisodos) -> {
            pisodos.animationTurtle();
            pisodos.update(delta);
        });
        
        river.update(delta);
        
        player.update(delta);
        
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.drawImage(background, 0, 0, WindowCanvas.WIDTHCANVAS, WindowCanvas.HEIGHTCANVAS, null);

        river.render(g2d);
        
        pisounos.forEach((pisouno) -> {
            pisouno.render(g2d);
        });

        pisodoses.forEach((pisodos) -> {
            if (pisodos.isType()) {
                pisodos.renderturtle(g2d);
            } else {
                pisodos.render(g2d);
            }

        });

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
