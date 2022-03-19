
package carexplosion;

import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.*; 
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarexPlosion2 extends JApplet implements ActionListener {
    private final int TIME_DELAY = 100;
    private final int MOVE = 20;
    private int carX = 600;
    private int carY = 300;
    private int ballX = 620;
    private int ballY = 10;
    private int ambulanceX = 0;
    private Timer timer; 
    private Image carImg=new ImageIcon("car.png").getImage();
    private Image img2=new ImageIcon("fruit.png").getImage();
    private Image img3=new ImageIcon("unnamed.png").getImage();
    private Image backImg=new ImageIcon("road.jpg").getImage();
    private Image ambulanceImg=new ImageIcon("ambulance.png").getImage();
    URL url,url2;
    AudioClip audio,ambulanceAudio;
    int s=0;
    
    public CarexPlosion2() throws MalformedURLException{
        this.url = new URL("file:Explosion.wav");
        this.audio= Applet.newAudioClip(url);
        
        //ambulance audio
        this.url2 = new URL("file:ambulance.WAV");
        this.ambulanceAudio= Applet.newAudioClip(url2);
    }
    
    public void init() {
        
        timer = new Timer(TIME_DELAY,this); 
        timer.start(); 
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backImg, 0, 0,680,416,null);
        g.drawImage(carImg, carX, carY,60,60,null);
        g.drawImage(img2, ballX, ballY,null);
        
        
        
        if(ballY>=300){
            g.drawImage(img3, carX,carY,60,60,null);
            if(s==1){
                 
                 audio.play();
            
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CarexPlosion2.class.getName()).log(Level.SEVERE, null, ex);
                }
                audio.stop();
                s=0;
            }
            g.drawImage(ambulanceImg, ambulanceX,294,40,40,null);
            
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(ballY<=300){
             carX-=MOVE;
             ballX-=MOVE;
             ballY+=MOVE;
             
             repaint();
        }
        else if(ballY>=300&&ambulanceX<=250){
            if(ambulanceX==0)
                 s=1;
            ambulanceAudio.play();
            ambulanceX+=MOVE;
            repaint();
        }
        else{
            try {
                
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CarexPlosion2.class.getName()).log(Level.SEVERE, null, ex);
            }
            ambulanceAudio.stop();
            carX = 600;
            carY = 300;
            ballX = 620;
            ballY = 10;
            ambulanceX=0;
            repaint();
            timer.setDelay(100);
        }
    }
    
}
