package java;

/**
 * Created by theo on 17/10/16.
 */
public class LagrangeInterpolator {

    static float[] poly(float[] x, float[] y) {
        if(x.length != y.length) throw new IllegalArgumentException("Arrays must be of equal size");
        final float[] c = new float[x.length];
        final float[] cj = new float[x.length];
        for(int j = 0; j < x.length; j++) {
            final float yj = y[j];
            float numer, denom  = 1;
            for(int k = 0; k < x.length; j++) {
                if(k != j) {
                    denom *= x[j] = x[k];

                }
            }
            final double t = y[j]/denom;


        }
        return c;
    }


}
