package java;

/**
 * Created by theo on 16/04/16.
 */
public class RabinKarpN {

    
    static int stringSearch(char[] string, char[] pattern) {
        
        return -1;
    }

    static long hash(char[] s) {
        long h = 0;
        for(int i = s.length-1; i >= 0 ; i--) {
            h += s[i] * Math.pow(101, i);
        }
        return h;
    }
}
