package entity;

import game.WindowCanvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class River {

    private Image[] background;
    private int iterador;
    private int speed;

    private int x;
    private int y;
    private int width;
    private int height;

    public River() {
        background = new Image[3];
        background[0] = new ImageIcon(getClass().getResource("/image/rio1.png")).getImage();
        background[1] = new ImageIcon(getClass().getResource("/image/rio2.png")).getImage();
        background[2] = new ImageIcon(getClass().getResource("/image/rio3.png")).getImage();

        x = 0;
        y = 95;
        width = WindowCanvas.WIDTHCANVAS;
        height = 160;

        speed = 0;
        iterador = 0;
    }

    public void update(double delta) {
//        speed ++;

//        if(speed >= 20){
//            iterador ++;
//            speed = 0;
//            if(iterador == 3){
//              iterador = 0;  
//            }
//        }
    }

    public void render(Graphics2D g2d) {
//        g2d.drawImage(background[iterador], 0, 58, WindowCanvas.WIDTHCANVAS, 206, null);
        g2d.setColor(Color.red);
        g2d.drawRect(x, y, width, height);
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }
}
