/**
 * Created by theo on 19/04/16.
 */
public class FastModulo implements Test {

    @Override
    public void run() {
        long start = System.nanoTime();
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            pow(1.1,1000);
        }
        System.out.println("Time taken for  pow " + (System.nanoTime()-start)/1E9);
        start = System.nanoTime();
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            regularPow(1.1, 1000);
        }
        System.out.println("Time taken for regular pow " + (System.nanoTime()-start)/1E9);
    }

    //https://discuss.codechef.com/questions/20451/a-tutorial-on-fast-modulo-multiplication-exponential-squaring
    static double pow(double base, int exp) {
        if(exp == 1) return base;
        double orig = base;
        if((exp&1) == 0) {
            base *= orig;
            for(int i = 0; i < exp>>1;i++) {
                base *= orig;
            }
        } else {
            base *= orig;
            for(int i = 0; i < (exp-1)>>1; i++) {
                base *= orig;
            }
            base *= orig;
        }
        return base;
    }

    static double regularPow(double base, int exp) {
        if(exp==1) return base;
        double orig = base;
        for(int i = 0; i < exp; i++) {
            base *= orig;
        }
        return base;
    }

}
