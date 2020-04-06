package entity;

import game.WindowCanvas;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Pisodos extends Modelo {

    private int iterador;
    private int animacion;
    private int speed;
    private Image[] tortuga;

    public Pisodos(int x, int y, String ruta, int width, int height, int speedplus) {
        super(x, y, ruta, width, height, speedplus);
    }

    public Pisodos(int x, int y, int width, int height, int speedplus) {
        super(x, y, width, height, speedplus);
        iterador = 0;
        animacion = 0;
    }

    public void tortuga() {
        tortuga = new Image[6];
        tortuga[0] = new ImageIcon(getClass().getResource("/image/turtle_0.png")).getImage();
        tortuga[1] = new ImageIcon(getClass().getResource("/image/turtle_1.png")).getImage();
        tortuga[2] = new ImageIcon(getClass().getResource("/image/turtle_2.png")).getImage();
        tortuga[3] = new ImageIcon(getClass().getResource("/image/turtle_3.png")).getImage();
        tortuga[4] = new ImageIcon(getClass().getResource("/image/turtle_4.png")).getImage();
        tortuga[5] = new ImageIcon(getClass().getResource("/image/turtle_5.png")).getImage();
    }

    public void animationTurtle() {

        animacion++;
        if (animacion >= 30) {
            iterador++;
            animacion = 0;
            if (iterador == 5) {
                iterador = 0;
            }
        }

    }

    public void renderturtle(Graphics2D g2d) {
        super.render(g2d, tortuga[iterador]);
    }

}
