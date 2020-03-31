package game;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import loaders.Menu;
import loaders.SplashScreen;

public class WindowCanvas extends Canvas implements Runnable, KeyListener {

    // dimensions
    public static final int WIDTHCANVAS = 224 * 2;
    public static final int HEIGHTCANVAS = 256 * 2;

    // game thread
    private final Thread thread;
    private boolean running;
    private double now, dt = 0, last = System.nanoTime();
    private final double step = 1.00 / 60.00;

    // image
    private BufferedImage image;
    private Graphics2D g2d;

    // game state manager
//    private SplashScreen splashScreen;
    private Menu menu;

    public WindowCanvas() {
        super();
        initComponents();
        thread = new Thread(this);
    }

    private void initComponents() {
        setBounds(0, 0, WIDTHCANVAS, HEIGHTCANVAS);
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    private void init() {
        image = new BufferedImage(WIDTHCANVAS, HEIGHTCANVAS, BufferedImage.TYPE_INT_RGB);
        g2d = (Graphics2D) image.getGraphics();
        // splashScreen = new SplashScreen();
        menu = new Menu();
    }

    public void start() {
        running = true;
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        boolean retry = true;
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public void run() {
        try {
            init();
            while (running) {
                now = System.nanoTime();
                dt = dt + Math.min(1, (now - last) / 1000000000.00);
                while (dt >= step) {
                    dt = dt - step;
                    update(step);
                }
                render();
                last = now;
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        } finally {
            stop();
        }
    }

    private void update(double delta) {
        menu.update(delta);
    }

    private void render() {
        BufferStrategy strategy = getBufferStrategy();
        if (strategy == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics2D g2 = (Graphics2D) strategy.getDrawGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        //    
        g2d.clearRect(0, 0, WindowCanvas.WIDTHCANVAS, WindowCanvas.HEIGHTCANVAS);
        menu.render(g2d);
        //
        Toolkit.getDefaultToolkit().sync();
        g2.dispose();
        strategy.show();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent key) {

    }

    @Override
    public void keyReleased(KeyEvent key) {

    }

}
