package foc;

import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;

public class Flame extends BufferedImage implements Runnable {

    private int w;
    private int h;
    private int[][] heatMap;
    private FlamePalete flamePalete;

    //Parametrizables
    private double heatLoss = 1.5;
    private int sparks = 65;
    private int fireMsSpeed = 25;
    private double airHeatConservation = 0.3; 
    
    public Flame( int w, int h ) {
        super(w, h, BufferedImage.TYPE_INT_ARGB);
        this.w = w;
        this.h = h;
                     
        heatMap = new int[w][h];

    }

    public void setFlamePalete(FlamePalete flamePalete) {
        this.flamePalete = flamePalete;
    }
    
    
    public BufferedImage getFlameImage() {
        return this;
    }

    public void setFireMsSpeed(int ms){
        fireMsSpeed = ms;
    }
    

    private void sparks() {
        for (int x = 0; x < w; x++) {
            if (((int) (Math.random() * 100 + 1)) < sparks) {
                heatMap[h - 1][x] = 255;
            }
        }
    }

    private void heatDispersion() {
        int[][] newHeatMapStatus = new int[w][h];

        for (int x = 1; x < w - 1; x++) {
            for (int y = 1; y < h - 2; y++) {

                //IF ( HEAT > 0 )
                if ((int) ((heatMap[x + 1][y - 1] + heatMap[x + 1][y] + heatMap[x + 1][y + 1] + (heatMap[x][y] * airHeatConservation)) / (3+airHeatConservation) - 1) > 0) {
                    newHeatMapStatus[x][y] = (int) ((heatMap[x + 1][y - 1] + heatMap[x + 1][y] + heatMap[x + 1][y + 1] + (heatMap[x][y] * airHeatConservation)) / (3+airHeatConservation) -heatLoss);
                } else  newHeatMapStatus[x][y] = 0;

            }
        }
        heatMap = newHeatMapStatus;
    }    

    private void updateImage() {
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                
                this.setRGB(y, x, flamePalete.getColor(heatMap[x][y]));

            }
        }
    }

    private void fireTick() {
        sparks();
        heatDispersion();
        updateImage();
    }

    @Override
    public void run() {
        while (true) {
            
            fireTick();
                    
            try {
                sleep(fireMsSpeed);
            } catch (Exception e) {
                System.out.println("Flame class" + e);
            }
        }
    }
}