package foc;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import static java.lang.Thread.sleep;

public class Viewer extends Canvas implements Runnable {

    BufferStrategy bs;
    Graphics g;

    private int w;
    private int h;
    private Flame flame;

    public Viewer(Flame flame) {
        this.w = flame.getWidth();
        this.h = flame.getHeight();
        this.flame = flame;

        setBackground(Color.black);
        setSize(w, h);
    }

    public void paint() {

        bs = this.getBufferStrategy();
        g = bs.getDrawGraphics();

        if (bs == null || g == null) {
            return;
        }

        g.drawImage(flame.getFlameImage(), 0, 0, null);

        bs.show();
        g.dispose();

    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
        }
        createBufferStrategy(2);

        while (true) {
            paint();
            try {
                sleep(33);
            } catch (Exception e) {
            }

        }
    }

}
