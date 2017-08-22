package java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by theo on 16/04/16.
 */
public class BinarySearch {


    public static int search(double[] data, double item) {
        int left = 0;
        int right = data.length -1;
        int current;
        do {
            current = (right+left)>>1;
            if(data[current] < item) {
                left = current + 1;
            } else if(data[current] > item) {
                right = current -1;
            } else {
                return current;
            }
        } while(right >= left);
        return -1;
    }

    public static int search(int[] data, int item) {
        int left = 0;
        int right = data.length -1;
        int current;
        do {
            current = (right+left)>>1;
            if(data[current] < item) {
                left = current + 1;
            } else if(data[current] > item) {
                right = current -1;
            } else {
                return current;
            }
        } while(right >= left);
        return -1;
    }

    public static int search(Object[] data, Object item, Comparator<Object> c) {
        int left = 0;
        int right = data.length -1;
        int current;
        do {
            current = (right+left)>>1;
            if(c.compare(data[current], item) < 0) {
                left = current + 1;
            } else if(c.compare(data[current], item) > 0) {
                right = current -1;
            } else {
                return current;
            }
        } while(right >= left);
        return -1;
    }

}
