package multiGlyph;

import multiGlyph.cipher.CipherMatch;

import static multiGlyph.cipher.CipherMatch.GlyphColor.BROWN;
import static multiGlyph.cipher.CipherMatch.GlyphColor.GREY;

/*
Determine the color of an object using weights and biases calculated by a python
machine learning algorithm
*/

public class GlyphColorDetection {
    //Initialize weights for each color and biases
    private static final double ALPHA_COEF = -0.7219657;
    private static final double RED_COEF = 4.41198906;
    private static final double GREEN_COEF = -0.56744802;
    private static final double BLUE_COEF = -2.26867769;
    private static final double BIAS = 1.08390786;

    int colorInt;

    //Calculate sigmoid of inputted data

    public static double sigmoid(double x) {
        return 1 / (1 + Math.pow(Math.E, (-x)));
    }

    public CipherMatch.GlyphColor GlyphColor() {
        colorInt = (int) Math.round(sigmoid((
                robot.firstGlyphColorSensor.alpha() * ALPHA_COEF +
                robot.firstGlyphColorSensor.red() * RED_COEF +
                robot.firstGlyphColorSensor.green() * GREEN_COEF +
                robot.firstGlyphColorSensor.blue() * BLUE_COEF) + BIAS));

        return (colorInt == 0) ? GREY : BROWN;
    }
}


