package loaders;

import game.WindowCanvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import states.Manager;
import states.State;
import util.Sound;

public class SplashScreen extends State{

    private final Image[] tiburones;
    private short iterador;
    private int speed;
    private int speedy;
    private int inicio;
    private final Sound sound;

    private boolean stopTitle;
    private final String title[] = {"M", "a", "m", "i", " ", "l", "l", "e", "g", "o", " ", "t", "u", " ", "t", "i", "b", "u", "r", "ó", "n", " ", "a", "i", "u", "d", "a", "!", "!", "!", "!"};
    private String auxiliar;

    public SplashScreen(Manager manager) {
        super(manager);
        tiburones = new Image[6];
        tiburones[0] = new ImageIcon(getClass().getResource("/image/tiburon1.png")).getImage();
        tiburones[1] = new ImageIcon(getClass().getResource("/image/tiburon2.png")).getImage();
        tiburones[2] = new ImageIcon(getClass().getResource("/image/tiburon3.png")).getImage();
        tiburones[3] = new ImageIcon(getClass().getResource("/image/tiburon4.png")).getImage();
        tiburones[4] = new ImageIcon(getClass().getResource("/image/tiburon5.png")).getImage();
        tiburones[5] = new ImageIcon(getClass().getResource("/image/tiburon6.png")).getImage();

        speed = 1;
        speedy = 1;
        iterador = 0;
        inicio = -1;

        sound = new Sound("/sound/tiburon-cut.wav");
        sound.music();
        
        stopTitle = false;
        auxiliar = "";
    }

    @Override
    public void update(double delta) {
        speed++;   
        speedy++;
        if(!stopTitle){
          if(speedy >= 9){
              inicio++;
              auxiliar += title[inicio]; 
              speedy =0 ;
              if(inicio == title.length-1){
                  stopTitle=true;
                  sound.stop();
                  manager.getStacks().pop();
                  manager.getStacks().push(new Menu(manager));
              }
          }
        }
        if (speed >= 90) {
            iterador++;
            speed = 0;
            if (iterador == 6) {
                iterador = 0;
            }
        }
    }

    @Override
    public void render(Graphics2D g2d) {        
        g2d.setFont(new Font("Impact", Font.PLAIN, 24));
        g2d.setColor(Color.white);
        g2d.drawString(auxiliar, 90, 200);
        g2d.drawImage(tiburones[iterador], (WindowCanvas.WIDTHCANVAS - 128) / 2, (WindowCanvas.HEIGHTCANVAS - 128) / 2 + 100, null);    
    }

    @Override
    public void keyPressed(KeyEvent key) {
        
    }

    @Override
    public void keyReleased(KeyEvent key) {
        
    }

}
