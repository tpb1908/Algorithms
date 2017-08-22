package java;

import java.util.Arrays;

/**
 * Created by theo on 23/04/16.
 */
public class InsertionSort {

    public void run() {
        double [] data = new double[] {5,4,3,2,1,0,-1,-2,-3,4};
        sort(data);
        System.out.println(Arrays.toString(data));
    }

    public static void sort(double[] data) {
        int j;
        double temp;
        for(int i = 1; i < data.length; i++) {
            j = i;
            while(j > 0 && data[j-1] > data[j]) {
                temp = data[j];
                data[j] = data[j-1];
                data[j-1] = temp;
                j -= 1;
            }
        }
    }
}
