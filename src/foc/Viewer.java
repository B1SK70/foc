package foc;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;

public class Viewer extends Canvas implements Runnable{

    private int w;
    private int h;
    private Flame flame;
    
    
    public Viewer( Flame flame) {
        this.w = flame.getWidth();
        this.h = flame.getHeight();
        this.flame = flame;
        
        setBackground(Color.black);
        setSize(w, h);
    }
    
    public void paint(Graphics g) {        
        g.drawImage(flame.getFlameImage(),0, 0, null);
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
