import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by theo on 16/04/16.
 */
public class SieveOfEratosthenes implements Test {

    @Override
    public void run() {
        for(int i = 10; i < 1E9; i *= 10) {
            long start = System.nanoTime();
            sieve(i);
            System.out.println("Sieving " + i + " took " + (System.nanoTime()-start)/1E9);
        }
    }

//    Sieving 10 took 9.3731E-5
//    Sieving 100 took 2.0946E-5
//    Sieving 1000 took 1.34008E-4
//    Sieving 10000 took 7.83187E-4
//    Sieving 100000 took 0.003163833
//    Sieving 1000000 took 0.011036062
//    Sieving 10000000 took 0.072296352
//    Sieving 100000000 took 1.732858371

    static ArrayList<Integer> sieve(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        boolean[] vals = new boolean[n];
        Arrays.fill(vals, true);
        for(int i = 2; i < Math.sqrt(n); i += 1) {
            if(vals[i]) {
                for(int j = i*i; j < n; j += i) {
                    vals[j] = false;
                }
            }
        }
        for(int i = 2; i < vals.length; i++) {
            if(vals[i]) {
                factors.add(i);
            }
        }
        return factors;
    }
}
