package foc;

import java.awt.Color;
import java.util.ArrayList;

public class FlamePalete {
    
    private ArrayList<TargetColor> targetColors = new ArrayList<TargetColor>();
    private int[] colors;
    
    public void addTargetColor(TargetColor tc) {
        targetColors.add(tc);
    }

    public int getColor(int temp) {
        if (colors == null) createColors();
        return colors[temp];
    }
    
    //Call interpolateColors for every fillable interval
    private void createColors() {
            colors = new int[256];
        for (int i = 0 ; i < targetColors.size()-1 ; i++) {
            interpolateColors(targetColors.get(i), targetColors.get(i+1));
        } 
    }
    
    //Generate generable value
    private void interpolateColors(TargetColor from, TargetColor to) {
        
        Color fromColor = from.getColor();
        Color toColor = to.getColor();
        
        //Starting color
        int[] fromColors = new int[]{ 
            fromColor.getRed(), 
            fromColor.getGreen(), 
            fromColor.getBlue() 
        };
        //Ending color
        int[] toColors = new int[]{ 
            toColor.getRed(), 
            toColor.getGreen(), 
            toColor.getBlue() 
        };

        //Amount of colors to fill
        float valuesToFill = from.getTemperature() - to.getTemperature(); 
        
        //Color variation per jump
        float redVariation = (toColors[0] - fromColors[0]) / valuesToFill;
        float greenVariation = (toColors[1] - fromColors[1]) / valuesToFill;
        float blueVariation = (toColors[2] - fromColors[2]) / valuesToFill;
               
        int i = 0;
        for (int temp = from.getTemperature() ; temp > to.getTemperature() ; temp--) {
            Color newColor = new Color(
                    (int) ( fromColors[0] + (redVariation * i) ),
                    (int) ( fromColors[1] + (greenVariation * i) ), 
                    (int) ( fromColors[2] + (blueVariation * i) ) );
            colors[temp] = newColor.getRGB();
            i++;
        }
    }
}