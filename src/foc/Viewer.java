package foc;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;

public class Viewer extends Canvas implements Runnable{

    private int width;
    private int height;
    private Flame flame;
    
    
    public Viewer(ControlPanel controlPanel, Flame flame) {
        setParametrizables(controlPanel);
        this.flame = flame;
        
        setBackground(Color.black);
        setSize(width, height);
        
    }
    
    public void paint(Graphics g) {
        g.drawImage(flame.getFlameImage(),0, -40, null);
    }
        
    private void setParametrizables(ControlPanel controlPanel) {
        this.width = controlPanel.getWidth();
        this.height = controlPanel.getHeight();
    }
    
    @Override
    public void run() {
        while (true) {
            paint( this.getGraphics() );
            try {
                sleep(33);
            } catch (Exception e) {
                System.out.println("Viwer class" + e);
            }
            
        }
    }
    
}
