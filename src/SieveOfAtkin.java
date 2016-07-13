/**
 * Created by theo on 13/07/16.
 */

import java.util.Arrays;

public class SieveOfAtkin implements Test {


    @Override
    public void run() {

        for(int i = 10; i <= 1E9; i *= 10) {
            long startTime = System.nanoTime();
            atkin(i);
            System.out.println("Computation of " + i + " primes took " + (System.nanoTime()-startTime)/1E9);
        }
        /*
            Computation of 10 primes took 8.7256E-5
            Computation of 100 primes took 1.3959E-5
            Computation of 1000 primes took 8.5474E-5
            Computation of 10000 primes took 7.75623E-4
            Computation of 100000 primes took 0.005689539
            Computation of 1000000 primes took 0.011218489
            Computation of 10000000 primes took 0.059695633
            Computation of 100000000 primes took 1.057412536
            Computation of 1000000000 primes took 10.516420109
         */
    }

    private void atkin(final int lim) {
        final int limSQRT = (int) Math.sqrt(lim);
        final boolean[] sieve = new boolean[lim +1];

        Arrays.fill(sieve, false);
        // the sieve works only for integers > 3, so
        // set these trivially to their proper values
        sieve[0] = false;
        sieve[1] = false;
        sieve[2] = true;
        sieve[3] = true;

        /*Iterate through all possible integer values for x and y
            to the root of the max prime.
            No larger values are required as the max value for x / y will be
            the root of n.

         */
        for(int x = 1; x <= limSQRT; x++) {
            for(int y = 1; y <= limSQRT; y++) {
                int n = (4 * x * x) + (y * y);
                if(n <= lim && (n%12 == 1 || n%12 == 5)) {
                    sieve[n] = !sieve[n];
                }
                n = (3 * x * x) + (y * y);
                if(n <= lim  & (n%12 == 7)) {
                    sieve[n] = ! sieve[n];
                }

                n = (3 * x * x) - (y * y); //Or n -= 2(y*y)
                if(x > y && n <= lim && (n%12 == 11)) {
                    sieve[n] = !sieve[n];
                }


            }
        }

        for(int n = 5; n<= limSQRT; n++) {
            if(sieve[n]) {
                int x = n*n;
                for(int i =x; i <= lim; i += x) {
                    sieve[i] = false;
                }
            }
        }
//        final StringBuilder builder = new StringBuilder();
//        for(int i = 0, j = 0; i <= lim; i++) {
//            if(sieve[i]) {
//                builder.append(i);
//                builder.append(", ");
//                if(++j%10 == 0) {
//                    builder.append("\n");
//                }
//            }
//        }
//
//        System.out.print(builder.toString());
    }




}
