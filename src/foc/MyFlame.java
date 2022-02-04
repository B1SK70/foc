package foc;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MyFlame extends JFrame {
    
    private int width;
    private int height;

    GridBagConstraints c;
    private Flame flame;
    private FlamePalete FP = createFlamePalete();
    
    public MyFlame() throws IOException {
        width = 600;
        height = 600;
        
        setWindowParams();
                
        File backgroundFile = new File("src/valley.jpg");
        BufferedImage background = ImageIO.read(backgroundFile);
        
        flame = new Flame( width, height, background );
        flame.setFlamePalete( FP );
        
               
        ControlPanel cp1 = new ControlPanel(this, FP);
        c = new GridBagConstraints();
        c.gridx = 0;
        this.add(cp1,c);
        
        Viewer viewer = new Viewer( flame );
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridwidth = 1;
        this.add(viewer,c);
        
        
        new Thread( flame ).start();

        new Thread( viewer ).start();
        
        this.pack();
    }
    
    public void setFireMsSpeed(int ms){
        flame.setFireMsSpeed(ms);
    }
    
    public void setHeatLoss(int hl){
        flame.setHeatLoss(hl);
    }
    
    public void setSparks(int sprks){
        flame.setSparks(sprks);
    }
    
    public void switchPauseState(){
        flame.switchPauseState();
    }
    
      
    public void restartFlame() {
        flame.restart();
    }
    
    public FlamePalete getColorPalete() {
        return FP;
    }
    
    public void removeTargetColor(int i) {
        FP = getColorPalete();
        FP.removeTargetColor(i);
    }
    
    private FlamePalete createFlamePalete() {
        FlamePalete flamePalete = new FlamePalete();
        
        flamePalete.addTargetColor( new TargetColor(0, new Color(0, 0, 0, 0)) );
        flamePalete.addTargetColor( new TargetColor(90, new Color(255, 0, 0, 220)) );
        flamePalete.addTargetColor( new TargetColor(170, new Color(255, 165, 0, 255) ) );
        flamePalete.addTargetColor( new TargetColor(255, new Color(255, 255, 255, 255) ) );
        
        return flamePalete;
    }
        
    private void setWindowParams() {
    
        this.setVisible( true );
        this.setLayout( new GridBagLayout() );        
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    
    }
    
    public static void main(String[] args) throws IOException {
        new MyFlame();    
    }
    
}
