import java.util.Random;
import java.util.Scanner;

/**
 * Created by theo on 16/04/16.
 */
public class Euclid implements Test {

    @Override
    public void run() {
        Random r = new Random();
        double[] sValues;
        double[] lValues;
        for(int i = 1000; i < 1E9; i *= 10) {
            for(int j = 10; j < 1E5; j *= 10) {
                sValues = new double[i];
                lValues = new double[i];
                for(int k = 0; k < sValues.length; k++) {
                    sValues[k] = r.nextInt(j) + 1;
                    lValues[k] = r.nextInt(j) + 1;
                }
                long start = System.nanoTime();
                for(int l = 0; l < sValues.length; l++) {
                    recursiveEuclid(sValues[l], lValues[l]);
                }
                System.out.println("With length " + i + " and range " + j + " Recursive test took " + (System.nanoTime() - start)/1E9);
                start = System.nanoTime();
                for(int l = 0; l < sValues.length; l++) {
                    iterativeEuclid(sValues[l], lValues[l]);
                }
                System.out.println("With length " + i + " and range " + j + " Iterative test took " + (System.nanoTime() - start)/1E9);

            }
        }

    }
    //For small values, < 10000, the recursive method is slightly faster
    //For larger values, the iterative method is ~20% faster

    //    With length 1000 and range 10 Recursive test took 1.89251E-4
    //    With length 1000 and range 10 Iterative test took 1.85238E-4
    //    With length 1000 and range 100 Recursive test took 8.2142E-5
    //    With length 1000 and range 100 Iterative test took 1.43398E-4
    //    With length 1000 and range 1000 Recursive test took 1.18135E-4
    //    With length 1000 and range 1000 Iterative test took 1.5431E-4
    //    With length 1000 and range 10000 Recursive test took 1.2081E-4
    //    With length 1000 and range 10000 Iterative test took 1.94368E-4
    //    With length 10000 and range 10 Recursive test took 6.53794E-4
    //    With length 10000 and range 10 Iterative test took 7.30086E-4
    //    With length 10000 and range 100 Recursive test took 0.001473895
    //    With length 10000 and range 100 Iterative test took 0.001993661
    //    With length 10000 and range 1000 Recursive test took 0.001967164
    //    With length 10000 and range 1000 Iterative test took 0.002111206
    //    With length 10000 and range 10000 Recursive test took 0.002295981
    //    With length 10000 and range 10000 Iterative test took 0.002319373
    //    With length 100000 and range 10 Recursive test took 0.005185836
    //    With length 100000 and range 10 Iterative test took 0.004683761
    //    With length 100000 and range 100 Recursive test took 0.009933523
    //    With length 100000 and range 100 Iterative test took 0.009840195
    //    With length 100000 and range 1000 Recursive test took 0.018009095
    //    With length 100000 and range 1000 Iterative test took 0.015297823
    //    With length 100000 and range 10000 Recursive test took 0.024863663
    //    With length 100000 and range 10000 Iterative test took 0.020678884
    //    With length 1000000 and range 10 Recursive test took 0.039372706
    //    With length 1000000 and range 10 Iterative test took 0.044698364
    //    With length 1000000 and range 100 Recursive test took 0.100031346
    //    With length 1000000 and range 100 Iterative test took 0.097194744
    //    With length 1000000 and range 1000 Recursive test took 0.16994659
    //    With length 1000000 and range 1000 Iterative test took 0.143773445
    //    With length 1000000 and range 10000 Recursive test took 0.236379201
    //    With length 1000000 and range 10000 Iterative test took 0.19022182
    //    With length 10000000 and range 10 Recursive test took 0.361784162
    //    With length 10000000 and range 10 Iterative test took 0.408172367
    //    With length 10000000 and range 100 Recursive test took 0.939186516
    //    With length 10000000 and range 100 Iterative test took 0.902047519
    //    With length 10000000 and range 1000 Recursive test took 1.629068055
    //    With length 10000000 and range 1000 Iterative test took 1.410335198
    //    With length 10000000 and range 10000 Recursive test took 2.327008637
    //    With length 10000000 and range 10000 Iterative test took 1.897082822
    //    With length 100000000 and range 10 Recursive test took 3.618882036
    //    With length 100000000 and range 10 Iterative test took 4.071320616
    //    With length 100000000 and range 100 Recursive test took 9.312272974
    //    With length 100000000 and range 100 Iterative test took 8.933075786
    //    With length 100000000 and range 1000 Recursive test took 16.264477484
    //    With length 100000000 and range 1000 Iterative test took 13.941596497
    //    With length 100000000 and range 10000 Recursive test took 24.466469642
    //    With length 100000000 and range 10000 Iterative test took 20.305507985

    static double recursiveEuclid(double s, double l) {
        if(s > l) {
            double t = l;
            l = s;
            s = t;
        }
        return l%s == 0 ? s : recursiveEuclid(l%s, s);
    }

    static double iterativeEuclid(double s, double l) {
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
