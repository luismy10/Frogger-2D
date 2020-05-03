
package states;

import java.awt.Graphics2D;
import java.util.Stack;
import loaders.SplashScreen;

public class Manager {
    
    private final Stack<State> stacks;
    
    public Manager(){
        stacks = new Stack<>(); 
        stacks.push(new SplashScreen(this));
    }

    public void update(double delta){
        stacks.peek().update(delta);
    }
    
    public void render(Graphics2D graphics2D){
        stacks.peek().render(graphics2D);
    }   

    public Stack<State> getStacks() {
        return stacks;
    }   
        
}
