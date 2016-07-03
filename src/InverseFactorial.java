import java.math.BigInteger;

/**
 * Created by theo on 16/04/16.
 */
public class InverseFactorial implements Test {

    @Override
    public void run() {
        for(int i = 1; i <= 10000;i += 10) {
            BigInteger test = factorial((long)i);
            long start = System.nanoTime();
            inverseFactorial(test);
            System.out.println("Time for inverse factorial of " + i + " is " + (System.nanoTime()-start)/1E9);
        }


    }

    static long factorial(short count) {
        if(count > 20) {
            throw new IllegalArgumentException("Any value larger than 20! cannot be computed using a long\n" +
                    "Use factorial(long) to produce a BigInteger instead");
        }
        long val = 1;
        while(count > 0) {
            val *= count;
            count--;
        }
        return val;
    }

    static long inverseFactorial(long fact) {
        short divisor = 1;
        do {
            if(fact%divisor != 0) {
                throw new IllegalArgumentException("The value is not factorial");
            }
            fact /= divisor;
            divisor += 1;
        } while(fact != 1);
        return divisor -1;
    }

    static BigInteger factorial(long count) {
        BigInteger val = new BigInteger("1");
        BigInteger mult;
        while(count > 1) {
            mult = BigInteger.valueOf(count);
            val = val.multiply(mult);
            count--;

        }
        return val;
    }

    static BigInteger inverseFactorial(BigInteger fact) {
        BigInteger divisor = BigInteger.valueOf(1); //This is necessary for inverse of 1! to work
        do {
            if(!fact.mod(divisor).equals(BigInteger.ZERO)) {
                throw new IllegalArgumentException("The value is not a factorial");
            }
            fact = fact.divide(divisor);
            divisor = divisor.add(BigInteger.ONE);
        } while(!fact.equals(BigInteger.ONE));
        return divisor.subtract(BigInteger.ONE);
    }
}
