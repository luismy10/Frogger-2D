package entity;

import game.WindowCanvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player {

    public Image[] playerone;
    private int dx;
    private double dy;
    private int x;
    private int y;
    private int speedfrog;
    private int iterador;
    
    private boolean up;
    private boolean down;
    private double moveSpeed;
    private double maxSpeed;
    private double stopSpeed;

    public Player() {
        playerone = new Image[3];
        playerone[0] = new ImageIcon(getClass().getResource("/image/frog_up_2.png")).getImage();
        playerone[1] = new ImageIcon(getClass().getResource("/image/frog_up_1.png")).getImage();
        playerone[2] = new ImageIcon(getClass().getResource("/image/frog_up_0.png")).getImage();
        x = WindowCanvas.WIDTHCANVAS / 2 - 14;
        y = WindowCanvas.WIDTHCANVAS + 3;

        speedfrog = 1;
        iterador = 0;
        
        moveSpeed = 0.6;
        maxSpeed = 4.2;
        stopSpeed = 0.30;
    }

    public void update(double delta) {
//        speedfrog++;        
//        if (speedfrog >= 30) {
//            iterador++;
//            speedfrog = 0;
//            if (iterador == 3) {
//                iterador = 0;
//            }
//        }
        mover();
    }

    public void render(Graphics2D g2d) {
        g2d.drawImage(playerone[iterador], x, y, 28, 28, null);

    }

    public void mover() {
        if(up){
            dy -= moveSpeed;
            if(dy < -maxSpeed){
                dy = -maxSpeed;
            }
        }else if(down){
            dy += moveSpeed;
            if(dy > maxSpeed){
                dy = maxSpeed;
            }
        }else{
            if(dy > 0){
                dy -= stopSpeed;
                if(dy < 0){
                    dy = 0;
                }
            }else if(dy < 0){
                dy += stopSpeed;
                if(dy > 0){
                    dy = 0;
                }
            }
        }
        
        x = dx;
        y += (int) dy;
    }

    public void keypressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {            
            up=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down=true;
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
            up=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}
