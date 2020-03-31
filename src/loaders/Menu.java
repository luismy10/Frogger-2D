package loaders;

import game.WindowCanvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Menu {

    private Image logo;
    private String inicio;
    private int speed;
    private boolean isVisible;
    
    public Menu() {
        logo = new ImageIcon(getClass().getResource("/image/tittle.png")).getImage();
        inicio = "Presione space para iniciar";
        speed = 0;
        isVisible=true;
    }

    public void update(double delta) {
        speed ++;
        if(speed > 20){            
            speed = 0;
            isVisible=!isVisible;
        }
    }

    public void render(Graphics2D g2d) {        
        g2d.setColor(new Color(17, 67, 152));
        g2d.fillRect(0, 0, WindowCanvas.WIDTHCANVAS, (WindowCanvas.HEIGHTCANVAS / 2) + 50);
        g2d.drawImage(logo, (WindowCanvas.WIDTHCANVAS-260)/2, 60, 260, 100, null);
        if(isVisible){
            g2d.setFont(new Font("Impact", Font.PLAIN, 24));
            g2d.setColor(Color.WHITE);
            g2d.drawString(inicio, 100, 280);
        }
        
    }

}
