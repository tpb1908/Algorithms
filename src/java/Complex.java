package java;

/**
 * Created by pearson-brayt15 on 17/05/2016.
 */
public class Complex {
    double a;
    double b;

    //java.Complex numbers are not ordered and therefore cannot be compared

    public Complex() {}

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    Complex add(Complex n) {
        return new Complex(a + n.a, b + n.b);
    }

    public Complex subtract(Complex n) {
        return new Complex(a - n.a, b - n.b);
    }

    public Complex multiply(Complex n) {
        return new Complex(a*n.a - b*n.b, a*n.b + b*n.a);
    }

    Complex divide(Complex n) {
        double denom = n.a*n.a + n.b*n.b;
        return new Complex(((a*n.a)/denom) + ((b*n.b)/denom), ((b*n.a)/(denom)) - ((a*n.b)/denom));
    }

    public static Complex conjugate(Complex n) {
        return new Complex(n.a, -n.b);
    }

    public static double abs(Complex n) {
        return Math.sqrt(n.a*n.a + n.b*n.b);
    }

    @Override
    public String toString() {
        return "a = " + a + ", b = " + b;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Complex)) return false;
        Complex complex = (Complex) obj;
        return complex.a == a && complex.b == b;
    }
}
