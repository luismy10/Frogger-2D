package entity;

import game.WindowCanvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.ImageIcon;
import util.Tools;

public class Winner {

    private Image[] frog_winner;
    private int width;
    private int height;
    private int x;
    private int y;
    private boolean state_win;
    private int animacion;
    private int iterador;

    public Winner(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        state_win = false;
        frog_winner = new Image[2];
        for (short i = 0; i < frog_winner.length; i++ ) {
            frog_winner[i] = new ImageIcon(getClass().getResource("/image/win_"+i+".png")).getImage();
        }
        
        animacion = 0;
        iterador = 0;
    }

    public void update(double delta) {
        animacion++;
            int frame = animacion / 20;
            iterador = frame == 2 ? 0 : frame;
            if (frame >= 2) {
                animacion = 0;
            }
    }

    public void render(Graphics2D g2d) {
        if (!state_win) {
//            g2d.setColor(Color.red);
//            g2d.drawRect(x, y, width, height);
        } else {
            g2d.drawImage(frog_winner[iterador], x, y, width, height, null);
        }
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public void setState_win(boolean state_win) {
        this.state_win = state_win;
    }
}
