package entity;

import game.WindowCanvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class Player {

    private enum FrogState {
        IDLE, JUMPING, DYING, DIED, WIN
    }
    private FrogState frogState = FrogState.IDLE;

    public Image[] playerone;
    private int x;
    private int y;
    private final int w;
    private final int h;
    private final int speed;
//    private double moveSpeed;
//    private double maxSpeed;
//    private double stopSpeed;
    private Map<String, Image[]> animations;
    private int frameIndex;
    private int posxAnimation;

    public Player(int width, int height) {
        playerone = new Image[3];
        playerone[0] = new ImageIcon(getClass().getResource("/image/frog_up_2.png")).getImage();
        playerone[1] = new ImageIcon(getClass().getResource("/image/frog_up_1.png")).getImage();
        playerone[2] = new ImageIcon(getClass().getResource("/image/frog_up_0.png")).getImage();
        x = (WindowCanvas.WIDTHCANVAS - width) / 2;
        y = 226 * 2;
        w = width;
        h = height;
        speed = 32;

        animations = new HashMap<>();
        for (short i = 0; i < 3; i++) {

        }
        animations.put("frog_up", playerone);
        System.out.println(animations.get("frog_up").length);
        
        frameIndex = 0;
        posxAnimation = 0;
    }

    private void changeFrogState(FrogState frogState) {
        if (this.frogState != frogState) {
            this.frogState = frogState;
        }
    }

    public void update(double delta) {
        switch (frogState) {
            case IDLE:

                break;
            case JUMPING:
                updateJumping();
                break;
        }
//        speedfrog++;        
//        if (speedfrog >= 30) {
//            iterador++;
//            speedfrog = 0;
//            if (iterador == 3) {
//                iterador = 0;
//            }
//        }

//        if(up){
//            dy -= moveSpeed;
//            if(dy < -maxSpeed){
//                dy = -maxSpeed;
//            }
//        }else if(down){
//            dy += moveSpeed;
//            if(dy > maxSpeed){
//                dy = maxSpeed;
//            }
//        }else{
//            if(dy > 0){
//                dy -= stopSpeed;
//                if(dy < 0){
//                    dy = 0;
//                }
//            }else if(dy < 0){
//                dy += stopSpeed;
//                if(dy > 0){
//                    dy = 0;
//                }
//            }
//        }
//        x = dx;
    }

    public void render(Graphics2D g2d) {
        g2d.drawImage(playerone[posxAnimation], x, y, w, h, null);

    }

    public void move(int vx, int vy) {
        x += vx * speed;
        y += vy * speed;
        frameIndex = 0;
        changeFrogState(FrogState.JUMPING);
    }

    private void updateJumping() {
        frameIndex++;
        int frame = (int) (frameIndex / 2.5);
        System.out.println(frame);
        posxAnimation = frame == 3 ? 0 : frame;
        if (frame > 2.5) {
            changeFrogState(FrogState.IDLE);
        }
    }

    public void keypressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            move(0, -1);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            move(0, 1);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            move(-1, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            move(1, 0);
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
