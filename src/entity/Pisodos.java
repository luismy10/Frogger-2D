package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class Pisodos extends Modelo {

    private boolean type;
    private boolean explotion;
    private int iterador;
    private int animacion;
    private Image[] tortuga;
    private Map<String, Image[]> animatios;
    private int contador;
    private boolean collision;

    public Pisodos(int x, int y, String ruta, int width, int height, int speedplus, String direction) {
        super(x, y, ruta, width, height, speedplus, direction);
    }

    public Pisodos(int x, int y, int width, int height, int speedplus, String direction, boolean type, boolean explotion) {
        super(x, y, width, height, speedplus, direction);
        iterador = 0;
        animacion = 0;
        animatios = new HashMap<>();
        this.type = type;
        this.explotion = explotion;
        contador = 0;
        collision = false;
    }

    public void tortuga() {
        Image[] firt_animation = new Image[3];
        firt_animation[0] = new ImageIcon(getClass().getResource("/image/turtle_0.png")).getImage();
        firt_animation[1] = new ImageIcon(getClass().getResource("/image/turtle_1.png")).getImage();
        firt_animation[2] = new ImageIcon(getClass().getResource("/image/turtle_2.png")).getImage();

        Image[] second_animation = new Image[3];
        second_animation[0] = new ImageIcon(getClass().getResource("/image/turtle_3.png")).getImage();
        second_animation[1] = new ImageIcon(getClass().getResource("/image/turtle_4.png")).getImage();
        second_animation[2] = new ImageIcon(getClass().getResource("/image/turtle_5.png")).getImage();

        animatios.put("firt", firt_animation);
        animatios.put("second", second_animation);

        tortuga = animatios.get("firt");
        
    }

    public void animationTurtle() {
        if (!explotion) {
            animacion++;
            int frame = animacion / 20;
            iterador = frame == 3 ? 0 : frame;
            if (frame > 2) {
                animacion = 0;
            }
            collision = true;
        } else {
            animacion++;
            int frame = animacion / 20;
            iterador = frame == 3 ? 0 : frame;
            if (frame > 2) {
                animacion = 0;
                contador++;
                if (contador > 3) {                    
                    tortuga = animatios.get("second");               
                    contador = 0;
                    collision=false;
                } else {
                    tortuga = animatios.get("firt");  
                    collision=true;
                }
            }
        }

    }

    public void renderturtle(Graphics2D g2d) {
        g2d.setColor(Color.red);
        super.render(g2d, tortuga[iterador]);
        g2d.drawRect(x, y, width, height);
    }

    public boolean isType() {
        return type;
    }

    public boolean isExplotion() {
        return explotion;
    }
    
    public boolean isCollision(){
        return collision;
    }
}
