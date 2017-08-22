package java;

import java.util.Random;

/**
 * Created by theo on 16/04/16.
 */
public class Euclid {

    public static double recursiveEuclid(double s, double l) {
        if(s > l) {
            double t = l;
            l = s;
            s = t;
        }
        return l%s == 0 ? s : recursiveEuclid(l%s, s);
    }

    public static double iterativeEuclid(double s, double l) {
        double t;
        while(l%s != 0) {
            if(s > l) {
                t = l;
                l = s;
                s = t;
            }
            l = l%s;
        }
        return s;
    }
}
