package entity;

import game.WindowCanvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import util.Keyboard;

public class Player {

    private enum FrogState {
        CALM, MOVE, DIED
    }

    private FrogState frogState = FrogState.CALM;

    private int x;
    private int y;
    private final int w;
    private final int h;
    private final int speed;

    private final Map<String, Image[]> animations;
    public Image[] frames;
    private int frameIndex;
    private int posxAnimation;

    private ArrayList<Modelo> carros;

    private Modelo tronquitos;
    private River river;

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
        setAnimation("frog_dying_", (short) 4);

        frames = animations.get("frog_up_");

        frameIndex = 0;
        posxAnimation = 0;
    }

    public void setModeloCarros(ArrayList modelos) {
        this.carros = modelos;
    }

    public void setModeloTronquito(Modelo modelo) {
        this.tronquitos = modelo;
    }
    public void setRiver(River river){
        this.river = river;
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

                for (Modelo modelo1 : carros) {
                    if (collision(getRectangle(), modelo1.getRectangle())) {
                        changeFrogState(FrogState.DIED);
                        frameIndex = 0;
                        setMovimiento("frog_dying_");
                    }
                }

                if (collision(getRectangle(), tronquitos.getRectangle())) {
                    x += tronquitos.getSpeedplus();
                }
                if(collision(getRectangle(), river.getRectangle())){
                    changeFrogState(frogState.DIED);
                    setMovimiento("frog_dying_");
                }

                break;
            case MOVE:
                updateJumping();
                break;
            case DIED:
                updatedDied();
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
        int frame = (int) (frameIndex / 4);
        posxAnimation = frame == 3 ? 0 : frame;
        if (frame > 2.5) {
            changeFrogState(FrogState.CALM);
        }
    }

    private void updatedDied() {
        frameIndex++;
        int frame = (int) (frameIndex / 15);
        posxAnimation = frame == 4 ? 0 : frame;
        if (frame > 3.5) {
            changeFrogState(FrogState.CALM);
            reset();
        }
    }

    private void reset() {
        x = (WindowCanvas.WIDTHCANVAS - w) / 2;
        y = 226 * 2;
        frames = animations.get("frog_up_");
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, w, h);
    }

    private boolean collision(Rectangle src, Rectangle des) {
        return src.x < des.x + des.width
                && src.x + src.width > des.x
                && src.y < des.y + des.height
                && src.height + src.y > des.y;
    }

    private void setMovimiento(String value) {
        frames = animations.get(value);
    }

    public void render(Graphics2D g2d) {
        g2d.drawImage(frames[posxAnimation], x, y, w, h, null);
    }

    public void keypressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                move(0, -1);
                break;
            case KeyEvent.VK_DOWN:
                move(0, 1);
                break;
            case KeyEvent.VK_LEFT:
                move(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                move(1, 0);
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
