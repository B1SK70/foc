package foc;

import java.awt.Color;
import javax.swing.*;

public class MyFlame extends JFrame {
    
    ControlPanel controlPanel = new ControlPanel();
    
    private int width;
    private int height;
    
    FlamePalete flamePalete;
    
    public MyFlame() {
        //APPLY CONTROL PANEL
        setParametrizables();
        
        //SET WINDOW PARAMS
        this.setVisible(true);
        this.setSize(width,height);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //CREAT FLAME PALETE
        setFlamePalete();
        
        //CREATE RUNNABLE ELEMENTS
        Flame flame = new Flame( controlPanel, flamePalete );
        Viewer viewer = new Viewer( controlPanel, flame );
        
        //ADD VIEWER
        this.add(viewer);
        
        //RUN FIRE
        Thread flameThread = new Thread( flame );
        flameThread.start();
        
        //RUN CANVAS
        Thread ViewerThread = new Thread( viewer );
        ViewerThread.start();
        
    }
      
    public void setFlamePalete() {
        flamePalete = new FlamePalete();
        
        flamePalete.addTargetColor( new TargetColor(255, Color.yellow) );
        flamePalete.addTargetColor( new TargetColor(190, Color.orange) );
        flamePalete.addTargetColor( new TargetColor(100, Color.red) );
        flamePalete.addTargetColor( new TargetColor(0, Color.black) );
    }
    
    private void setParametrizables() {
        width = controlPanel.getWidth();
        height = controlPanel.getHeight();
    }
    
    public static void main(String[] args) {
        new MyFlame();    
    }
    
}
