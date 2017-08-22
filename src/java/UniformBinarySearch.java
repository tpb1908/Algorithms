package java;

/**
 * Created by theo on 19/04/16.
 */
public class UniformBinarySearch {
    static int[] delta;


    public static void makeDelta(int n) {
        delta = new int[42];
        int power = 1;
        int i = 0;
        int half;
        do {
            half = power;
            power <<= 1;
            delta[i]  = (n+half)/power;
        } while(delta[i++] != 0);
    }

    public static int search(int[] data, int val) {
        int i = delta[0]-1;
        int d = 0;
        for(;;) {
            if(val == data[i]) {
                return i;
            } else if(delta[d] == 0) {
                return  -1;
            } else {
                if(val < data[i]) {
                    i -= delta[++d];
                } else {
                    i += delta[++d];
                }
            }
        }

    }



}
