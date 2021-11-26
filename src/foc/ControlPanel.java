package foc;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class ControlPanel extends JPanel{

    public ControlPanel(MyFlame programa) {
        super(new GridBagLayout());
        
        this.setPreferredSize(new Dimension(200, 600));
        this.setBackground(Color.gray);
        
        
        
        
        JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL, 5, 40, 25);
        
        framesPerSecond.setPreferredSize(new Dimension(160, 40));
        framesPerSecond.setMajorTickSpacing(10);
        framesPerSecond.setMinorTickSpacing(1);
        framesPerSecond.setPaintTicks(true);
        framesPerSecond.setPaintLabels(true);
        
        framesPerSecond.addChangeListener( new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                programa.setFireMsSpeed(framesPerSecond.getValue());
            }
        });
        
        this.add(framesPerSecond);
                
                
                
        
//        JButton bttn1 = new JButton();
//        bttn1.setPreferredSize(new Dimension(160, 40));
//        bttn1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            programa.setFireMsSpeed();	
//            }	
//        });
//        
//        
//        
//        this.add(bttn1);
        
    }
    
}
