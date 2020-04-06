package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player {

    public Image playerone;
    private int dx;
    private int dy;
    private int x;
    private int y;

    public Player() {
        playerone = new ImageIcon(getClass().getResource("/image/player.png")).getImage();
        x = 0;
        y = 0;
    }

    public void update(double delta) {
        mover();
    }

    public void render(Graphics2D g2d) {
        g2d.drawImage(playerone, x, y, 40, 40, null);
    }

    public void mover() {
        x += dx;
        y += dy;
    }

    public void keypressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            dy = -2;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            dy = 2;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dx = -2;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}
