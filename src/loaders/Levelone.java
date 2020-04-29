package loaders;

import entity.Modelo;
import entity.Pisodos;
import entity.Pisouno;
import entity.Player;
import entity.River;
import entity.Winner;
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
    
    private Winner[] winner;

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

        pisounos.add(new Pisouno(0, 358, "/image/car_b_0.png", 30, 20, 2, "left"));
        pisounos.add(new Pisouno(150, 358, "/image/car_b_0.png", 30, 20, 2, "left"));
        pisounos.add(new Pisouno(300, 358, "/image/car_b_0.png", 30, 20, 2, "left"));

        pisounos.add(new Pisouno(60, 388, "/image/car_d_0.png", 28, 24, 1, "right"));
        pisounos.add(new Pisouno(160, 388, "/image/car_d_0.png", 28, 24, 1, "right"));
        pisounos.add(new Pisouno(360, 388, "/image/car_d_0.png", 28, 24, 1, "right"));

        pisounos.add(new Pisouno(10, 322, "/image/car_e_0.png", 32, 28, 5, "right"));

        for (short i = 0; i < 3; i++) {
            Pisodos turtle_a1 = new Pisodos(32 * (i), 225, 30, 30, 2, "left", true, false);
            turtle_a1.tortuga();
            pisodoses.add(turtle_a1);

            Pisodos turtle_a2 = new Pisodos(32 * (i + 4), 225, 30, 30, 2, "left", true, true);
            turtle_a2.tortuga();
            pisodoses.add(turtle_a2);

            Pisodos turtle_a3 = new Pisodos(32 * (i + 8), 225, 30, 30, 2, "left", true, false);
            turtle_a3.tortuga();
            pisodoses.add(turtle_a3);
            
        }

        for (short i = 0; i < 2; i++) {
            Pisodos turtle_a4 = new Pisodos(32 * (i + 12), 225, 30, 30, 2, "left", true, false);
            turtle_a4.tortuga();
            pisodoses.add(turtle_a4);

            Pisodos turtle_b1 = new Pisodos(32 * i, 130, 30, 30, 1, "left", true, true);
            turtle_b1.tortuga();
            pisodoses.add(turtle_b1);
            
            Pisodos turtle_b2 = new Pisodos(32 * (i + 3), 130, 30, 30, 1, "left", true, false);
            turtle_b2.tortuga();
            pisodoses.add(turtle_b2);
            
            Pisodos turtle_b3 = new Pisodos(32 * (i + 6), 130, 30, 30, 1, "left", true, false);
            turtle_b3.tortuga();
            pisodoses.add(turtle_b3);
            
            Pisodos turtle_b4 = new Pisodos(32 * (i + 9), 130, 30, 30, 1, "left", true, false);
            turtle_b4.tortuga();
            pisodoses.add(turtle_b4);
            
            Pisodos turtle_b5 = new Pisodos(32 * (i + 12), 130, 30, 30, 1, "left", true, false);
            turtle_b5.tortuga();
            pisodoses.add(turtle_b5);
        }

        pisodoses.add(new Pisodos(128, 199, "/image/log_0.png", 84, 20, 2, "right"));
        pisodoses.add(new Pisodos(320, 199, "/image/log_0.png", 84, 20, 2, "right"));
        pisodoses.add(new Pisodos(384, 199, "/image/log_0.png", 84, 20, 2, "right"));

        pisodoses.add(new Pisodos(0, 168, "/image/log_0.png", 84, 20, 1, "right"));
        pisodoses.add(new Pisodos(160, 168, "/image/log_0.png", 84, 20, 1, "right"));
        pisodoses.add(new Pisodos(320, 168, "/image/log_0.png", 84, 20, 1, "right"));

        pisodoses.add(new Pisodos(0, 103, "/image/log_0.png", 84, 20, 1, "right"));
        pisodoses.add(new Pisodos(128, 103, "/image/log_0.png", 84, 20, 1, "right"));
        pisodoses.add(new Pisodos(156, 103, "/image/log_0.png", 84, 20, 1, "right"));
        pisodoses.add(new Pisodos(384, 103, "/image/log_0.png", 84, 20, 1, "right"));
        
        winner = new Winner[5];
        winner[0] = new Winner(13, 60, 37, 35);
        winner[1] = new Winner(109, 60, 37, 35);
        winner[2] = new Winner(205, 60, 37, 35);
        winner[3] = new Winner(301, 60, 37, 35);
        winner[4] = new Winner(397, 60, 37, 35);

        player = new Player(28, 28);
        player.setModeloCarros(pisounos);        
        player.setModeloTronquito(pisodoses);
        player.setWinner(winner);        
        
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
        
        for(Winner lol : winner){
            lol.update(delta);
        }

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
        
       for(Winner space :winner){
           space.render(g2d);
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
