package foc;

import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;

public class Flame extends BufferedImage implements Runnable {

    private int width;
    private int height;
    private int[][] heatMap;
    private FlamePalete flamePalete;

    public Flame(ControlPanel controlPanel, FlamePalete flamePalete) {
        //SET PARAMETRIZABLES
        super(controlPanel.getWidth(), controlPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        setParametrizables(controlPanel);
        this.flamePalete = flamePalete;
        
        //INITIALIZE HEATMAP
        heatMap = new int[width][height];
    }

    //IMAGE GETTER
    public BufferedImage getFlameImage() {
        return this;
    }

    //BOTTOM IGNITION
    private void sparks() {
        for (int x = 0; x < width; x++) {
            if (((int) (Math.random() * 10 + 1)) < 5) {
                heatMap[height - 1][x] = 255;
            }
        }
    }

    //EXPAND EXISTING HEAT
    private void heatDispersion() {
        int[][] newHeatMapStatus = new int[width][height];

        for (int x = 1; x < width - 1; x++) {
            for (int y = 1; y < height - 2; y++) {

                //IF ( HEAT > 0 )  APPLY HEAT LOSS
                if ((int) ((heatMap[x + 1][y - 1] + heatMap[x + 1][y] + heatMap[x + 1][y + 1] + (heatMap[x][y] * 0.3)) / 3.3 - 1) > 0) {
                    newHeatMapStatus[x][y] = (int) ((heatMap[x + 1][y - 1] + heatMap[x + 1][y] + heatMap[x + 1][y + 1] + (heatMap[x][y] * 0.3)) / 3.3 - 1);
                } else  newHeatMapStatus[x][y] = 0;

            }
        }
        heatMap = newHeatMapStatus;
    }

    //RANDOM COLD SPOTS TO IRREGULARIZE HEAT LOSS
    private void coldSparks() {
        for (int x = 200; x < 385; x++) {
            for (int y = 2; y < width - 2; y++) {

                if (((int) (Math.random() * 100)) < 1) {
                    heatMap[x][y] = 0;
                }

            }
        }
    }

    //APPLY HEATMAP TO IMAGE PIXELS
    private void updateImage() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                
                this.setRGB(y, x, flamePalete.getColor(heatMap[x][y]));

            }
        }
    }

    private void fireTick() {
        sparks();
        heatDispersion();
        coldSparks();
        updateImage();
    }

    //IMPORT PARAMETRIZABLE VALUES
    private void setParametrizables(ControlPanel controlPanel) {
        width = controlPanel.getWidth();
        height = controlPanel.getHeight();

    }

    @Override
    public void run() {
        while (true) {
            
            fireTick();
                    
            try {
                sleep(30);
            } catch (Exception e) {
                System.out.println("Flame class" + e);
            }
        }
    }
}