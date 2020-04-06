package loaders;

import entity.Modelo;
import entity.Pisodos;
import entity.Pisouno;
import entity.Player;
import game.WindowCanvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import states.Manager;
import states.State;

public class Levelone extends State{

    private Image background;
    private Player player;
    private Pisouno[] car1;
    private Pisouno[] car2;
    private Pisouno[] car3;
    private Pisouno car4;
    private Pisouno[] listcamion;

    private Pisodos[] turtle1;
    private Pisodos[] item2;
    private Pisodos[] item3;
    private Pisodos[] turtle2;
    private Pisodos[] item5;
    
    private ArrayList<Pisodos[]> arrayList;

    public Levelone(Manager manager) {
        super(manager);
        background = new ImageIcon(getClass().getResource("/image/background.png")).getImage();
        arrayList = new ArrayList();
       
        
        player = new Player();
        listcamion = new Pisouno[4];
        listcamion[0] = new Pisouno(0, 295, "/image/car_c_0.png", 54, 20, 1);
        listcamion[1] = new Pisouno(96, 295, "/image/car_c_0.png", 54, 20, 1);
        listcamion[2] = new Pisouno(264, 295, "/image/car_c_0.png", 54, 20, 1);
        listcamion[3] = new Pisouno(392, 295, "/image/car_c_0.png", 54, 20, 1);
        
         
        
        car1 = new Pisouno[2];
        car1[0] = new Pisouno(0, 415, "/image/car_a_0.png", 32, 28, 2);
        car1[1] = new Pisouno(256, 415, "/image/car_a_0.png", 32, 28, 2);
        car2 = new Pisouno[3];
        car2[0] = new Pisouno(60, 384, "/image/car_d_0.png", 28, 24, 1);
        car2[1] = new Pisouno(160, 384, "/image/car_d_0.png", 28, 24, 1);
        car2[2] = new Pisouno(360, 384, "/image/car_d_0.png", 28, 24, 1);
        car3 = new Pisouno[3];
        car3[0] = new Pisouno(0, 356, "/image/car_b_0.png", 30, 20, 3);
        car3[1] = new Pisouno(150, 356, "/image/car_b_0.png", 30, 20, 3);
        car3[2] = new Pisouno(300, 356, "/image/car_b_0.png", 30, 20, 3);
        car4 = new Pisouno(10, 322, "/image/car_e_0.png", 32, 28, 5);

//        turtle1 = new Pisodos(WindowCanvas.WIDTHCANVAS + 30, 220, 30, 30, 2);
//        turtle1.tortuga();
//OKOOK YA ESTA LISTO RESPONDE PS CARAJO
//TE ESTOY LLAMANDO INTENTA DE NUEVO
        item2 = new Pisodos[3];
        item2[0] = new Pisodos(128, 190, "/image/log_0.png", 84, 20, 1);
        item2[1] = new Pisodos(320, 190, "/image/log_0.png", 84, 20, 1);
        item2[2] = new Pisodos(384, 190, "/image/log_0.png", 84, 20, 1);
        
        item3 = new Pisodos[3];
        item3[0] = new Pisodos(0, 160, "/image/log_0.png", 84, 20, 5);
        item3[1] = new Pisodos(160, 160, "/image/log_0.png", 84, 20, 5);
        item3[2] = new Pisodos(320, 160, "/image/log_0.png", 84, 20, 5);
//        turtle2 = new Pisodos(WindowCanvas.WIDTHCANVAS + 30, 130, 30, 30, 3);
//        turtle2.tortuga();
        item5 = new Pisodos[4];
        item5[0] = new Pisodos(0, 100, "/image/log_0.png", 84, 20, 1);
        item5[1] = new Pisodos(128, 100, "/image/log_0.png", 84, 20, 1);
        item5[2] = new Pisodos(156, 100, "/image/log_0.png", 84, 20, 1);
        item5[3] = new Pisodos(384, 100, "/image/log_0.png", 84, 20, 1);
        
        arrayList.add(item5);
        
        for(Pisodos[] list : arrayList){
            System.err.println(list.length);
        }
    }

    @Override
    public void update(double delta) {
        
        for (short i = 0; i < car1.length; i++) {
            car1[i].moverigth();
        }
        for (short i = 0; i < car2.length; i++) {
            car2[i].moverigth();
        }
        for (short i = 0; i < car3.length; i++) {
            car3[i].moveleft();
        }
        car4.moverigth();
        for (short i = 0; i < listcamion.length; i++) {
            listcamion[i].moveleft();
        }
//        turtle1.animationTurtle();
//        turtle1.moveleft();
        for (short i = 0; i < item2.length; i++) {
            item2[i].moverigth();
        }
        for (short i = 0; i < item3.length; i++) {
            item3[i].moverigth();
        }
//        turtle2.animationTurtle();
//        turtle2.moveleft();
        for(short i = 0; i < item5.length; i++){
            item5[i].moverigth();
        }
        player.update(delta);
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.drawImage(background, 0, 0, WindowCanvas.WIDTHCANVAS, WindowCanvas.HEIGHTCANVAS, null);
        
        for (Pisouno pisouno : car1) {
            pisouno.render(g2d);
        }
        for (Pisouno pisouno : car2) {
            pisouno.render(g2d);
        }
        for (Pisouno pisouno : car3) {
            pisouno.render(g2d);
        }
        car4.render(g2d);
        for (Pisouno pisouno : listcamion) {
            pisouno.render(g2d);
        }
//        turtle1.renderturtle(g2d);
        for (Pisodos pisodos : item2) {
            pisodos.render(g2d);
        }
        for(Pisodos pisodos : item3){
            pisodos.render(g2d);
        }
//        turtle2.renderturtle(g2d);
        for(Pisodos pisodos : item5){
            pisodos.render(g2d);
        }
        player.render(g2d);
    }

    @Override
    public void keyPressed(KeyEvent key) {
        player.keypressed(key);
    }

    @Override
    public void keyReleased(KeyEvent key) {
        player.keyReleased(key);
    }
}
