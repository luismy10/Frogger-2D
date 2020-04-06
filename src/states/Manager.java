
package states;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Stack;
import loaders.Levelone;
import loaders.Menu;
import loaders.SplashScreen;

public class Manager {
    
    private Stack<State> stacks;
    
    public Manager(){
        stacks = new Stack<>(); 
        stacks.push(new Levelone(this));
    }

    public void update(double delta){
        stacks.peek().update(delta);
    }
    
    public void render(Graphics2D graphics2D){
        stacks.peek().render(graphics2D);
    }
    
    public void keyPressed(KeyEvent key){
        stacks.peek().keyPressed(key);
    }
    
    public void keyReleased(KeyEvent key){
        stacks.peek().keyReleased(key);
    }

    public Stack<State> getStacks() {
        return stacks;
    }   
        
}
