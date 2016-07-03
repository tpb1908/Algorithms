import java.util.Arrays;

/**
 * Created by theo on 03/04/16.
 */
public  class AiMaths {
    //TODO- Method to generate dataset from an array of coefficients of a polynomial
    //http://www.matematicasvisuales.com/english/html/analysis/interpolacion/lagrange.html
    /*
    * Construct an array of the correct size for a polynomial of degree n, with the coefficient of x^n at index 0
    * Expand brackets, adding to the correct index. The denominator is always just a double, so division is easy
    * The problem is an algorithm to expand the brackets and get the correct powers of x
    * In theory, move from left to right, building a cache array, such that on each step from left to right
    * the power n of each index in the array increases by one.
    * For example, a (x-a)(x-b) gives x^2 +(-a-b)x + (a+b), so the coefficients would be {1, (-a-b), (a+b)}
    * with powers of 2, 1, 0
    * Next, multiply each part by (x-c), giving x^3 +(-a-b-c)x^2 + (ab +bc +bc)x -(abc)
    * This gives coefficients of {1, (-a-b-c), (ab+bc+bc), -(abc), with powers 3,2,1,0
    * In each case each part has to be divided by (x0 -x1)(x0-x2).. and multiplied by y0 .. before being placed in the
    * main array
     */
    /*
    * Possibility-
    * The AI could build a state diagram-
    * This would be a system of conditions and their movements
    * For example what does a bouncing character do when they hit a vertical obstacle
    * A creature dataset can have multiple motion paths stored, which are referred to
    * in the state diagram
    *
    * For each creature on the screen, the AI stores an instance of a datamodel class, which holds
    * the state diagram, current state, and path data
    * The datamodel also holds information on the cost of different types of collision with a creature
    *
    * When a collision occurs, the game itself removes the creature/player before notifying the AI of the
    * collision.
    * If a creature has been removed, the AI removes the creature and its position data, but retains the state
    * diagram and path data which may be merged into a 'super-dataset' for that creature
     */

    private static double sumX4, sumX3, sumX2, sumX, sumX2Y, sumXY, sumY;
    private static double a, b, c;
    private static double x1, x2, x3, y1, y2, y3;

    private AiMaths() {}

    public static void expandBrackets(double[] xData) {

    }

    //http://www.matematicasvisuales.com/english/html/analysis/interpolacion/lagrange.html
    public static double[] polynomialRegression(int degree, double[] xData, double[] yData) {
        if(xData.length < degree || yData.length < degree) {
            throw new IllegalArgumentException("The number of data points must be greater than" +
                    " the degree of the polynomial. xData given has " + xData.length + " points" +
                    " and yData has " + yData.length + ". " + degree + " points required.");
        } else if(degree < 0) {
            throw new IllegalArgumentException("The degree of the polynomial must be greater than 0.");
        } else if(xData.length != yData.length) {
            throw new IllegalArgumentException("xData and yData must be the same length. " +
                    " xData has length " + xData.length + " and yData has length " + yData.length + ".");
        }
        double[] polynomial = new double[degree+1];
        Arrays.fill(polynomial, 0);
        double cache = 1;
        double[] currentPoly = new double[degree+1];
        double denominator;
        for(int i = 0; i < degree+1; i++) {
            System.out.println("i = " + i + " Running on point (" + xData[i] + ", " + yData[i] +")");
            denominator = 1;
            //This code is working
            for(double x : xData) {
                if(x != xData[i]) {
                    denominator *= (xData[i]-x);
                }
            }
            System.out.println("Denominator is " + denominator);
            //This code is not working
            /*
            * The coefficients will be in order 0, sum of singles , sum of product of pairs,
            * sum of product of triplets, sum of product of quadruplets etc,
            * finally just the product of all values
            * for a,b,c,d,e this gives x^5 + (-a-b-c-d-e)x^4 + (ab + ac + ad + ae + bc + bd...)x^3
            * So for each one, multiply the previous product by the next value
             */
            int currentDegree = currentPoly.length-1; //The index of the current degree in the array
            for(int j = 0; j < degree; j++) {
                Arrays.fill(currentPoly, 1);
                if(j != i) {
                    for(int k = currentPoly.length -1; k < currentDegree; k++) {
                        if(currentPoly[k] != 0) {
                            currentPoly[k] *= -xData[j];
                        } else {
                            currentPoly[k] = -xData[j];
                        }
                    }
                }
                System.out.println("Current poly " + currentPoly[j]);

                currentDegree -=1;
            }
            //Adding to the coefficients of each part of the polynomial
            for(int k = 0; k < degree; k++) {
                polynomial[k] += (currentPoly[k]/denominator)*yData[i];
                System.out.println("Adding " + (currentPoly[k]/denominator)*yData[i]);
            }
        }
        System.out.println(Arrays.toString(polynomial));
        return new double[] {0};
    }

    /**
     * Calculates the coefficients of a quadratic best fit to the data passed.
     * Susceptible to floating point rounding errors on large data sets
     * @return Array of three doubles. In the order a, b, and c, in ax^2 + bx + c
     * @param xData The x data set
     * @param yData The y data set
     * @throws IllegalArgumentException if fewer than three data points are given,
     * or if xData and yData are of different length
     */
    public static double[] quadRegression(double[] xData, double[] yData) {
        if(xData.length < 3 || yData.length < 3) {
            throw new IllegalArgumentException("At least 3 data points are needed " +
                    xData.length + " given for x values, and " + yData.length + " given for y.");
        } else if(xData.length != yData.length) {
            throw new IllegalArgumentException("xData and yData must be the same length. " +
                    " xData has length " + xData.length + " and yData has length " + yData.length + ".");
        }
        sumX4 = sumX3 = sumX2 = sumX = sumX2Y = sumXY = sumY = 0;
        double n = xData.length;
        for(int i = 0; i < n; i++) {
            sumX4 += Math.pow(xData[i], 4);
            sumX3 += Math.pow(xData[i], 3);
            sumX2 += Math.pow(xData[i], 2);
            sumX += xData[i];
            sumX2Y += Math.pow(xData[i], 2) * yData[i];
            sumXY += xData[i] * yData[i];
            sumY += yData[i];
        }
        //https://www.easycalculation.com/statistics/quadratic-regression.php
        double h = sumX2 - ((sumX*sumX)/n);
        double i = sumXY - ((sumX*sumY)/n);
        double j = sumX3 - ((sumX2 * sumX)/n);
        double k = sumX2Y - ((sumX2 * sumY)/n);
        double l = sumX4 - ((sumX2 * sumX2)/n);

        a = ((k*h) - (i*j))/((h*l)-(j*j));
        b = ((i*l)-(k*j))/((h*l)-(j*j));
        c = (sumY/n) - (b * (sumX/n)) - (a*(sumX2/n));

        return  new double[] {a, b, c};
    }

    /**
     * Calculates the coefficients of a quadratic function fitting three data points: the first,
     * middle, and final values in the arguments
     * @return Array of three doubles. In the order a, b, and c, in ax^2 + bx + c
     * @param xData The x data set
     * @param yData The y data set
     * @throws IllegalArgumentException If fewer than three data points are given, regression cannot be completed
     * Use fastLinearRegression for two points
     */
    public static double[] fastQuadRegression(double[] xData, double[] yData) {
        if(xData.length < 3 || yData.length < 3) {
            throw new IllegalArgumentException("At least 3 data points are needed " +
                    xData.length + " given for x values, and " + yData.length + " given for y.");
        }
        x1 = xData[0];
        x2 = xData[xData.length/2];
        x3 = xData[xData.length-1];
        y1 = yData[0];
        y2 = yData[yData.length/2];
        y3 = yData[yData.length-1];
        //Lagrange interpolating polynomial
        a = (((y2-y3)*x1)+((y1-y2)*x3)+((y3-y1)*x2))/
                (((x3-x2)*x1*x1)+((-(x3*x3)+(x2*x2))*x1)+((x2 * x3 * x3)-(x2*x2*x3)));

        // Equal x values could cause division by 0, e.g. on either side of a critical point
        if(x1-x2 == 0) {
            b = ((a*x3*x3)-(a*x2*x2)+y2-y3)/(x2-x3);
        } else if(x2-x3 == 0) {
            b =  ((a*x2*x2)-(a*x1*x1)+y1-y2)/(x1-x2);
        } else {
            b = ((a*x1*x1)-(a*x3*x3)+y3-y1)/(x3-x1);
        }
        c = y1 - (a*x1*x1) - (b*x1);

        return new double[] {a, b, c};
    }

    /**
     * Calculates the coefficients of a linear best fit to the data passed
     * @param xData The x data set
     * @param yData The y data set
     * @return Array of two doubles, m and c in y = mx +c
     * @throws IllegalArgumentException If fewer than two data points are passed,
     * or if xData and yData are of different length
     */
    public static double[] linearRegression(double[] xData, double[] yData) {
        if(xData.length < 2 || yData.length < 2) {
            throw new IllegalArgumentException("At least 2 data points are needed " +
                    xData.length + " given for x values, and " + yData.length + " given for y.");
        } else if(xData.length != yData.length) {
            throw new IllegalArgumentException("xData and yData must be the same length. " +
                    " xData has length " + xData.length + " and yData has length " + yData.length + ".");
        }
        sumX = sumY = sumXY = sumX2 = 0;
        double n = xData.length;
        for(int i = 0;i < n;i++) {
            sumX += xData[i];
            sumY += yData[i];
            sumXY += xData[i] * yData[i];
            sumX2 += xData[i] * xData[i];
        }

        double m = ((n*sumXY)-(sumX*sumY))/((n*sumX2)-(sumX*sumX));
        double c = (sumY-(m*sumX))/n;

        return new double[] {m, c};
    }

    /**
     * Calculates the coefficients of a linear function fitting three data points:
     * the first, the middle, and the final values in the arguments
     * @param xData  The x data set
     * @param yData  The y data set
     * @return Array of two doubles, m and c in y = mx +c
     * @throws IllegalArgumentException if fewer than two data points are given
     */
    public static double[] fastLinearRegression(double[] xData, double[] yData) {
        if(xData.length < 2 || yData.length < 2) {
            throw new IllegalArgumentException("At least 2 data points are needed " +
                    xData.length + " given for x values, and " + yData.length + " given for y.");
        }
        x1 = xData[0];
        x2 = xData[xData.length -1];
        y1 = yData[0];
        y2 = yData[yData.length -1];

        double m = (y2 - y1)/(x2 - x1);
        double c = y1 - (m * x1);

        return new double[] {m, c};
    }

}
