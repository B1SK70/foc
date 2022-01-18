package foc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.*;
import javax.swing.*;

public class FlamePaleteDisplayer extends JPanel {

    GridBagConstraints c;
    FlamePalete FP;
    
    public FlamePaleteDisplayer(ControlPanel CP,FlamePalete FP) {
        super(new GridBagLayout());
        
        this.FP = FP;

        this.setPreferredSize(new Dimension(160, 160));
        this.setBackground(new Color(211,211,211));

        PrintTCs(FP);

    }

    private void PrintTCs(FlamePalete FP) {

        ArrayList<TargetColor> TCs = FP.getTargets();
        
        
        for (int i = 0; i < TCs.size(); i++) {

            //COLOR
            JButton colorBox = new JButton();
            colorBox.setEnabled(false);
            colorBox.setBackground(TCs.get(i).getColor());
            colorBox.setPreferredSize(new Dimension(35, 35));

            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = i;
            c.gridheight = 1;
            c.gridwidth = 1;

            this.add(colorBox, c);

            //TEMP
            int temp = TCs.get(i).getTemperature();
            JLabel colorTemp = new JLabel(  String.valueOf(temp) );
            colorTemp.setPreferredSize(new Dimension(40, 35));
            colorTemp.setForeground(Color.white);
            
            
            c = new GridBagConstraints();
            c.gridx = 1;
            c.gridy = i;
            c.gridheight = 1;
            c.gridwidth = 1;

            this.add(colorTemp, c); 
            
            //BUTTON
            JButton deleteColor = new JButton(); 
            deleteColor.setPreferredSize( new Dimension(35, 35) ); 
            deleteColor.setText("X");
            deleteColor.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 5));
            deleteColor.setVisible(true);
            deleteColor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //FP.removeTargetColor(1);
                }
            });
        
            c = new GridBagConstraints();
            c.gridx = 2;
            c.gridy = i;
            c.gridheight = 1;
            c.gridwidth = 1;

            this.add(deleteColor, c); 
        }
    }
}






