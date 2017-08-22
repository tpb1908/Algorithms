package java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by theo on 18/04/16.
 */
public class BinPacker {

    //First fit decreasing bin packing
    public static boolean pack(int binSize, int[] bins,  Integer[] itemSizes) {
        Arrays.sort(itemSizes, (t1, t2) -> {
            if(t1 > t2) {
                return -1;
            } else if(t2 > t1) {
                return  1;
            } else {
                return 0;
            }
        });
        //This is the actual packing
        boolean allPacked = true;
        boolean iPacked = false;
        Arrays.fill(bins, 0);
        for(Integer i : itemSizes) {
            for(int j = 0; j < bins.length; j++) {
                if(bins[j] + i <= binSize) {
                    bins[j] += i;
                    iPacked = true;
                    break;
                }
                if(!iPacked) {
                    allPacked = false;
                }
            }
        }
        return allPacked;
    }
}
