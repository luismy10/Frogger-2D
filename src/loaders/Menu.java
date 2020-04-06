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

public class Menu extends State{

    private Image logo;
    private String inicio;
    private String desarrollo;
    private String presentacion1;
    private String presentacion2;
    private int speed;
    private boolean isVisible;
    
    public Menu(Manager manager) {
        super(manager);
        logo = new ImageIcon(getClass().getResource("/image/tittle.png")).getImage();
        inicio = "PRESIONE SPACE PARA CONTINUAR";
        desarrollo = "DESARROLLADO POR NENAS 2020";
        presentacion1 = "JUEGO ORIGINAL POR";
        presentacion2 = "KONAMI © 1981";
        speed = 0;
        isVisible=true;
    }

    @Override
    public void update(double delta) {
        speed ++;
        if(speed > 20){            
            speed = 0;
            isVisible=!isVisible;
        }
    }

    @Override
    public void render(Graphics2D g2d) {        
        g2d.setColor(new Color(17, 67, 152));
        g2d.fillRect(0, 0, WindowCanvas.WIDTHCANVAS, (WindowCanvas.HEIGHTCANVAS / 2) + 50);
        g2d.drawImage(logo, (WindowCanvas.WIDTHCANVAS-260)/2, 70, 260, 100, null);
        if(isVisible){
            g2d.setFont(new Font("Impact", Font.PLAIN, 24));
            g2d.setColor(Color.WHITE);
            g2d.drawString(inicio, 70, 270);
        }
        g2d.setFont(new Font("Cooper Black", Font.PLAIN, 18));
        g2d.setColor(Color.WHITE);
        g2d.drawString(desarrollo, 60, 370);
        g2d.drawString(presentacion1, 120, 420);
        g2d.drawString(presentacion2, 160, 450);
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
