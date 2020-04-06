package loaders;

import game.WindowCanvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import states.Manager;
import states.State;
import util.FontImage;

public class Menu extends State {

    private final Image logo;
    private int speed;
    private boolean isVisible;
    private final FontImage fontImage;

    public Menu(Manager manager) {
        super(manager);
        logo = new ImageIcon(getClass().getResource("/image/tittle.png")).getImage();
        speed = 0;
        isVisible = true;
        fontImage = new FontImage("/image/bitmap.png", 16, 6);
    }

    @Override
    public void update(double delta) {
        speed++;
        if (speed > 30) {
            speed = 0;
            isVisible = !isVisible;
        }
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(new Color(17, 67, 152));
        g2d.fillRect(0, 0, WindowCanvas.WIDTHCANVAS, (WindowCanvas.HEIGHTCANVAS / 2) + 50);
        g2d.drawImage(logo, (WindowCanvas.WIDTHCANVAS - 260) / 2, 80, 260, 100, null);

        fontImage.drawText(g2d, "00000", 40, 20, Color.RED);
        fontImage.drawText(g2d, "00000", 160, 20, Color.RED);
        if (isVisible) {
            fontImage.drawText(g2d, "PUSH SPACE TO START", 80, 240, Color.WHITE);
        }
        fontImage.drawText(g2d, "PROGRAMMED BY O.L (C) 2017", 20, 360, Color.WHITE);
        fontImage.drawText(g2d, "ORIGINAL GAME BY", 90, 420, Color.WHITE);
        fontImage.drawText(g2d, "KONAMI  ©  1981", 100, 460, Color.WHITE);

    }

    @Override
    public void keyPressed(KeyEvent key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
