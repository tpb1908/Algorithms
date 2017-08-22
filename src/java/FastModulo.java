package java;

/**
 * Created by theo on 19/04/16.
 */
public class FastModulo{



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
