package foc;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class FlamePalete {

    private ArrayList<TargetColor> targetColors = new ArrayList<TargetColor>();
    private int[] colors;

    public void addTargetColor(TargetColor tc) {
        targetColors.add(tc);
        createColors();
    }

    public void removeTargetColor(int index) {
        targetColors.remove(index);
        createColors();
    }

    public int getColor(int temp) {
        if (colors == null) {
            createColors();
        }
        return colors[temp];
    }

    public ArrayList<TargetColor> getTargets() {
        return targetColors;
    }

    //Call interpolateColors for every fillable interval
    private void createColors() {
        sortTargetColors();
        colors = new int[256];
        for (int i = 0; i < targetColors.size() - 1; i++) {
            interpolateColors(targetColors.get(i), targetColors.get(i + 1));
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
            fromColor.getBlue(),
            fromColor.getAlpha()
        };
        //Ending color
        int[] toColors = new int[]{
            toColor.getRed(),
            toColor.getGreen(),
            toColor.getBlue(),
            toColor.getAlpha()
        };

        //Amount of colors to fill
        float valuesToFill = from.getTemperature() - to.getTemperature();

        //Color variation per jump
        float redVariation = (toColors[0] - fromColors[0]) / valuesToFill;
        float greenVariation = (toColors[1] - fromColors[1]) / valuesToFill;
        float blueVariation = (toColors[2] - fromColors[2]) / valuesToFill;
        float alphaVariation = (toColors[3] - fromColors[3]) / valuesToFill;

        int i = 0;
        for (int temp = from.getTemperature(); temp > to.getTemperature(); temp--) {
            Color newColor = new Color(
                    (int) (fromColors[0] + (redVariation * i)),
                    (int) (fromColors[1] + (greenVariation * i)),
                    (int) (fromColors[2] + (blueVariation * i)),
                    (int) (fromColors[3] + (alphaVariation * i)));
            colors[temp] = newColor.getRGB();
            i++;
        }
    }

    private void sortTargetColors() {

        int temps[] = new int[targetColors.size()];
        for (int i = 0; i < targetColors.size(); i++) {
            temps[i] = targetColors.get(i).getTemperature();
        }

        Arrays.sort(temps);

        ArrayList<TargetColor> newTargetColors = new ArrayList<TargetColor>();
        for (int i = temps.length - 1; i >= 0; i--) {
            for (TargetColor tc : targetColors) {
                if (tc.getTemperature() == temps[i]) {
                    newTargetColors.add(tc);
                    break;
                }
            }
        }
        targetColors = newTargetColors;
    }
}
