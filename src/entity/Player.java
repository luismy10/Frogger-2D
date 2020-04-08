package entity;

import game.WindowCanvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import util.Keyboard;

public class Player {

    private enum FrogState {
        CALM, MOVE
    }

    private FrogState frogState = FrogState.CALM;

    private int x;
    private int y;
    private final int w;
    private final int h;
    private final int speed;

    private Map<String, Image[]> animations;
    public Image[] frames;
    private int frameIndex;
    private int posxAnimation;

    public Player(int width, int height) {
        x = (WindowCanvas.WIDTHCANVAS - width) / 2;
        y = 226 * 2;
        w = width;
        h = height;
        speed = 32;

        animations = new HashMap<>();
        setAnimation("frog_up_", (short) 3);
        setAnimation("frog_down_", (short) 3);
        setAnimation("frog_left_", (short) 3);
        setAnimation("frog_right_", (short) 3);

        frames = animations.get("frog_up_");

        frameIndex = 0;
        posxAnimation = 0;
    }

    private void setAnimation(String key, short value) {
        Image[] image = new Image[value];
        for (short i = 0; i < image.length; i++) {
            image[i] = new ImageIcon(getClass().getResource("/image/" + key + i + ".png")).getImage();
        }
        animations.put(key, image);
    }

    private void changeFrogState(FrogState frogState) {
        if (this.frogState != frogState) {
            this.frogState = frogState;
        }
    }

    public void update(double delta) {
        switch (frogState) {
            case CALM:
                if (Keyboard.isKeyPressed(VK_LEFT)) {
                    move(-1, 0);
                } else if (Keyboard.isKeyPressed(VK_RIGHT)) {
                    move(1, 0);
                }
                if (Keyboard.isKeyPressed(VK_UP)) {
                    move(0, -1);
                } else if (Keyboard.isKeyPressed(VK_DOWN)) {
                    move(0, 1);
                }
                break;
            case MOVE:

                updateJumping();
                break;
        }
    }

    public void move(int vx, int vy) {
        x += vx * speed;
        y += vy * speed;
        frameIndex = 0;
        String direction = vy > 0 ? "frog_down_" : vy < 0 ? "frog_up_" : vx > 0 ? "frog_right_" : "frog_left_";
        setMovimiento(direction);
        changeFrogState(FrogState.MOVE);
    }

    private void updateJumping() {
        frameIndex++;
        int frame = (int) (frameIndex / 4.5);
        System.out.println(frame);
        posxAnimation = frame == 3 ? 0 : frame;
        if (frame > 2.5) {
            changeFrogState(FrogState.CALM);
        }
    }

    private void setMovimiento(String value) {
        frames = animations.get(value);
    }

    public void render(Graphics2D g2d) {
        g2d.drawImage(frames[posxAnimation], x, y, w, h, null);
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
