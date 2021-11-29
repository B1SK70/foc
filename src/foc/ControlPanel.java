package foc;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class ControlPanel extends JPanel{

    GridBagConstraints c;
    
    public ControlPanel(MyFlame programa) {
        super(new GridBagLayout());
        
        this.setPreferredSize(new Dimension(200, 600));
        this.setBackground(Color.gray);
        
                
        //SPARKS
        JLabel sparksLb = new JLabel("Sparks  (rec: 65)");
        sparksLb.setPreferredSize(new Dimension(160, 50));
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        
        this.add(sparksLb,c);
        
        JSlider sparks = new JSlider(JSlider.HORIZONTAL, 1, 100, 65);
        sparks.setPreferredSize(new Dimension(160, 40));
        sparks.setMajorTickSpacing(20);
        sparks.setMinorTickSpacing(10);
        sparks.setPaintTicks(true);
        sparks.setPaintLabels(true);
        sparks.addChangeListener( new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                programa.setSparks(sparks.getValue());
            }
        });
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 2;
        
        this.add(sparks,c);
     
        
        ///////////////////////
        
        //HEATLOSS
        JLabel heatLossLb = new JLabel("HeatLoss  (rec: 50)");
        heatLossLb.setPreferredSize(new Dimension(160, 50));
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 3;
        c.gridheight = 1;
        
        this.add(heatLossLb,c);
        
        JSlider heatLoss = new JSlider(JSlider.HORIZONTAL, 1, 100, 50);
        heatLoss.setPreferredSize(new Dimension(160, 40));
        heatLoss.setMajorTickSpacing(20);
        heatLoss.setMinorTickSpacing(10);
        heatLoss.setPaintTicks(true);
        heatLoss.setPaintLabels(true);
        heatLoss.addChangeListener( new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                programa.setHeatLoss(heatLoss.getValue());
            }
        });
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 4;
        c.gridheight = 2;
        
        this.add(heatLoss,c);
        
        
        ///////////////////////
        
        //AIR RESIDUAL HEAT
        JLabel airHeatConservationLb = new JLabel("Heat duration (rec: 50)");
        airHeatConservationLb.setPreferredSize(new Dimension(160, 50));
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 6;
        c.gridheight = 1;
        
        this.add(airHeatConservationLb,c);
        
        JSlider residualHeat = new JSlider(JSlider.HORIZONTAL, 1, 100, 50);
        residualHeat.setPreferredSize(new Dimension(160, 40));
        residualHeat.setMajorTickSpacing(20);
        residualHeat.setMinorTickSpacing(10);
        residualHeat.setPaintTicks(true);
        residualHeat.setPaintLabels(true);
        residualHeat.addChangeListener( new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                programa.setAirHeatConservation(residualHeat.getValue());
            }
        });
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 7;
        c.gridheight = 2;
        
        this.add(residualHeat,c);
        
        ///////////////////////
        
        
        //SPEED
        JLabel msSpedLb = new JLabel("MS refresh (rec: 25)");
        msSpedLb.setPreferredSize(new Dimension(160, 50));
        
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 9;
        c.gridheight = 1;
        
        this.add(msSpedLb,c);
        
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
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 10;
        c.gridheight = 2;
        
        this.add(framesPerSecond,c);
        
        
                
                
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
