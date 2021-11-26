package foc;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class MyFlame extends JFrame {
    
    private int width;
    private int height;

    GridBagConstraints c;
    private Flame flame;
    
    
    public MyFlame() {
        width = 600;
        height = 600;
        
        setWindowParams();
                
        
        flame = new Flame( 600, 600 );
        flame.setFlamePalete( createFlamePalete() );
        
               
        ControlPanel cp1 = new ControlPanel(this);
        c = new GridBagConstraints();
        c.gridx = 0;
        this.add(cp1,c);
        
        Viewer viewer = new Viewer( flame );
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridwidth = 1;
        c.weightx = 1;
        this.add(viewer,c);
        
        
        new Thread( flame ).start();
        

        new Thread( viewer ).start();
        
        this.pack();
    }
    
    public void setFireMsSpeed(int ms){
        flame.setFireMsSpeed(ms);
    }
      
    private FlamePalete createFlamePalete() {
        FlamePalete flamePalete = new FlamePalete();
        
        flamePalete.addTargetColor( new TargetColor(255, Color.yellow) );
        flamePalete.addTargetColor( new TargetColor(190, Color.orange) );
        flamePalete.addTargetColor( new TargetColor(100, Color.red) );
        flamePalete.addTargetColor( new TargetColor(0, Color.black) );
        return flamePalete;
    }
    
    private void setWindowParams() {
    
        this.setVisible( true );
        this.setLayout( new GridBagLayout() );        
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    
    
    }
    
    public static void main(String[] args) {
        new MyFlame();    
    }
    
}
