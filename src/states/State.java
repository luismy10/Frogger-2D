
package states;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public abstract class State {
    
    protected Manager manager;
    
    public State(Manager manager){
        this.manager = manager;
    }
    
    public abstract void update(double delta);
    
    public abstract void render(Graphics2D graphics2D);
    
    public abstract void keyPressed(KeyEvent key);
    
    public abstract void keyReleased(KeyEvent key);
    
}
