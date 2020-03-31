package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Window {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame("Frogger 2D");
            window.getContentPane().setBackground(new Color(0x194894));
            window.setUndecorated(false);
            window.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            WindowCanvas windowadapter = new WindowCanvas();
            window.getContentPane().setPreferredSize(new Dimension(WindowCanvas.WIDTHCANVAS, WindowCanvas.HEIGHTCANVAS));
            window.getContentPane().setLayout(null);
            window.getContentPane().add(windowadapter);
//            window.setExtendedState(JFrame.MAXIMIZED_BOTH);
            window.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    windowadapter.setLocation((window.getContentPane().getSize().width - windowadapter.getWidth()) / 2,
                            (window.getContentPane().getSize().height - windowadapter.getHeight()) / 2);
                    if(window.getExtendedState() == 6){                        
                        window.getContentPane().setBackground(new Color(0x194894));
                        window.getContentPane().repaint();
                        window.repaint();
                    } 
                }
            });
            
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);
            windowadapter.start();            
        });
    }

}
