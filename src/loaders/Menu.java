package loaders;

import game.WindowCanvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import util.FontImage;

public class Menu {

    private final Image logo;
    private int speed;
    private boolean isVisible;
    private final FontImage fontImage;

    public Menu() {
        logo = new ImageIcon(getClass().getResource("/image/tittle.png")).getImage();
        speed = 0;
        isVisible = true;
        fontImage = new FontImage("/image/bitmap.png", 16, 6);
    }

    public void update(double delta) {
        speed++;
        if (speed > 30) {
            speed = 0;
            isVisible = !isVisible;
        }
    }

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

}
