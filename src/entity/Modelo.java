package entity;

import game.WindowCanvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Modelo {

    protected Image imagen;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int speedplus;
    protected String direction;

    public Modelo(int x, int y, String ruta, int width, int height, int speedplus, String direction) {
        imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speedplus = speedplus;
        this.direction = direction;
    }

    public Modelo(int x, int y, int width, int height, int speedplus, String direction) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speedplus = speedplus;
        this.direction = direction;
    }

    public void update(double delta) {
        if (direction.equalsIgnoreCase("left")) {
            x -= speedplus;
            if (x < -width) {
                x = WindowCanvas.WIDTHCANVAS + 50;
            }
        } else if (direction.equalsIgnoreCase("right")) {
            x += speedplus;
            if (x > WindowCanvas.WIDTHCANVAS + 50) {
                x = -width;
            }
        }
    }

    public void render(Graphics2D g2d) {
        g2d.drawImage(imagen, x, y, width, height, null);
        g2d.setColor(Color.red);
        g2d.drawRect(x, y, width, height);
    }

    public void render(Graphics2D g2d, Image turtle) {
        g2d.drawImage(turtle, x, y, width, height, null);
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public int getSpeedplus() {
        return speedplus;
    }

    public String getDirection() {
        return direction;
    }    

}
