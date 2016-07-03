import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by theo on 16/04/16.
 */
public class BinarySearch implements Test {

    @Override
    public void run() {
        double[] data ;
        for(int i = 1; i < Integer.MAX_VALUE; i *= 2) {
            data = new double[i];
            for(int j = 0; j < data.length; j++) {
                data[j] = Math.random() * j;
            }
            Arrays.sort(data);
            long start = System.nanoTime();
            search(data, data[(int) Math.floor(Math.random() * (data.length - 1))]);
            System.out.println("Time to find value in array of size " + i + " was " + (System.nanoTime()-start)/1E9);
        }
    }
//    Time to find value in array of size 32 was 3.86E-6
//    Time to find value in array of size 64 was 4.354E-6
//    Time to find value in array of size 128 was 4.394E-6
//    Time to find value in array of size 256 was 4.175E-6
//    Time to find value in array of size 512 was 1.8781E-5
//    Time to find value in array of size 1024 was 4.203E-6
//    Time to find value in array of size 2048 was 1.1586E-5
//    Time to find value in array of size 4096 was 8.456E-6
//    Time to find value in array of size 8192 was 7.85E-6
//    Time to find value in array of size 16384 was 8.08E-6
//    Time to find value in array of size 32768 was 1.0215E-5
//    Time to find value in array of size 65536 was 6.151E-5
//    Time to find value in array of size 131072 was 1.2553E-5
//    Time to find value in array of size 262144 was 4.4222E-5
//    Time to find value in array of size 524288 was 3.3319E-5
//    Time to find value in array of size 1048576 was 2.7697E-5
//    Time to find value in array of size 2097152 was 2.5066E-5
//    Time to find value in array of size 4194304 was 1.5756E-5
//    Time to find value in array of size 8388608 was 1.653E-5
//    Time to find value in array of size 16777216 was 1.4848E-5
//    Time to find value in array of size 33554432 was 1.5443E-5
//    Time to find value in array of size 67108864 was 2.1129E-5
//    Time to find value in array of size 134217728 was 1.5437E-5
//    Time to find value in array of size 268435456 was 2.0948E-5

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
