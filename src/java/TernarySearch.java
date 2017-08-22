package java;

/**
 * Created by theo on 19/04/16.
 */
public class TernarySearch {

    //Maximum of a unimodal function within given bounds
    static double ternarySearch(Polynomial f, double left, double right, double absolutePrecision) {
        double leftThird;
        double rightThird;
        for(;;) {
            if(Math.abs(right-left) < absolutePrecision) {
                return (left+right)/2;
            }
            leftThird = left + (right-left)/3;
            rightThird = right - (right-left)/3;
            if(f.eval(leftThird) < f.eval(rightThird)) {
                left = leftThird;
            } else {
                right = rightThird;
            }
        }
    }

    private static class Polynomial {
        double[] coefficients;

        Polynomial(double... coefficients) {
            this.coefficients = coefficients;

        }

        Polynomial(int degree) {
            coefficients = new double[degree];
        }

        public void increaseDegree() {
            double[] newCoefficients = new double[coefficients.length+1];
            for(int i = 0; i < coefficients.length;i++) {
                newCoefficients[i+1] = coefficients[i];
            }
            coefficients = newCoefficients;
        }

        public double eval(double x) {
            double val = 0;
            for(int i = 0; i < coefficients.length; i++) {
                val += coefficients[i] * Math.pow(x, coefficients.length-i);
            }
            return val;
        }


    }

}
