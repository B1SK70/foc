package foc;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{

    public ControlPanel() {
        
        
        this.setSize( 200, 600 );
        this.setLayout( new GridBagLayout() ); 
        
        JButton bttn1 = new JButton();
        
        this.add(bttn1);
        
    }
    
}
