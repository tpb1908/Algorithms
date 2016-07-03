import javax.lang.model.type.PrimitiveType;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by theo on 18/04/16.
 */
public class BinPacker implements Test {

    @Override
    public void run() {
        Integer[] data = new Integer[] {4,5,7,4,6,9,3,1,1,3,4};
        int[] bins = new int[5];
        pack(10, bins, data);
        System.out.println(Arrays.toString(bins));
    }


    //First fit decreasing bin packing
    static boolean pack(int binSize, int[] bins,  Integer[] itemSizes) {
        Arrays.sort(itemSizes, new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                if(t1 > t2) {
                    return -1;
                } else if(t2 > t1) {
                    return  1;
                } else {
                    return 0;
                }
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
