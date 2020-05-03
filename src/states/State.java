
package states;

import java.awt.Graphics2D;


public abstract class State {
    
    protected Manager manager;
    
    public State(Manager manager){
        this.manager = manager;
    }
    
    public abstract void update(double delta);
    
    public abstract void render(Graphics2D graphics2D);
    
}
