package entity;

import game.WindowCanvas;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Modelo {

    protected Image imagen;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int speedplus;

    public Modelo(int x, int y, String ruta, int width, int height, int speedplus) {
        imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speedplus = speedplus;
    }

    public Modelo(int x, int y, int width, int height, int speedplus) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speedplus = speedplus;
    }

    public void update(double delta) {

    }

    public void moveleft() {
        x -= speedplus;
        if (x < -width) {
            x = WindowCanvas.WIDTHCANVAS + 50;
        }
    }

    public void moverigth() {
        x += speedplus;
        if (x > WindowCanvas.WIDTHCANVAS + 50) {
            x = -width;
        }
    }

    public void render(Graphics2D g2d) {
        g2d.drawImage(imagen, x, y, width, height, null);
    }

    public void render(Graphics2D g2d, Image turtle) {
        g2d.drawImage(turtle, x, y, width, height, null);
    }

}
