package foc;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class MyFlame extends JFrame {
    
    private int width;
    private int height;

    GridBagConstraints c;
    
    
    public MyFlame() {
        width = 600;
        height = 600;
        
        setWindowParams();
                
        
        Flame flame = new Flame( 400, 400 );
        flame.setFlamePalete( createFlamePalete() );
        
        
        Viewer viewer = new Viewer( flame );
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridwidth = 2;
        this.add(viewer,c);
        
        ControlPanel cp = new ControlPanel();
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridwidth = 1;
        this.add(cp,c);
        

        new Thread( flame ).start();
        

        new Thread( viewer ).start();
        
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
        this.setSize( width, height );
        this.setLayout( new GridBagLayout() );        
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    
    
    }
    
    public static void main(String[] args) {
        new MyFlame();    
    }
    
}
