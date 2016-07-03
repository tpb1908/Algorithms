import java.util.Arrays;
import java.util.Stack;

/**
 * Created by theo on 16/04/16.
 */
public class QuickSort implements Test {

    @Override
    public void run() {
        for(int i = 1; i < 1E9; i*= 10) {
            double[] data = new double[i];
            double[] dataCopy = data.clone();
            for(int j = 0; j < data.length; j++) {
                data[j] = Math.random() * i;
            }
            long start = System.nanoTime();
            recursiveQuicksort(data, 0, data.length);
            System.out.println("Time to sort array of " + data.length + " " + (System.nanoTime()-start)/1E9);
            start = System.nanoTime();
            Arrays.sort(dataCopy);
            System.out.println("System time to sort array of " + data.length + " " + (System.nanoTime()-start)/1E9);
        }

    }
//    Time to sort array of 1 4.1667E-5
//    Time to sort array of 10 7.367E-6
//    Time to sort array of 100 3.7707E-5
//    Time to sort array of 1000 5.44017E-4
//    Time to sort array of 10000 0.001165027
//    Time to sort array of 100000 0.007080972
//    Time to sort array of 1000000 0.079762091
//    Time to sort array of 10000000 0.945140885
//    Time to sort array of 100000000 10.623798637


    //TODO-Broken
    static void iterativeQuicksort(double[] data) {
        int low = 0;
        int high = data.length;
        int pivot;
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);
        while(!stack.isEmpty() && low != high) {
            high = stack.pop();
            low = stack.pop();

            System.out.println("Low is " +low+ " High is " + high);
            System.out.println("Data before pivot is " + Arrays.toString(data));

            pivot = partition(data, low, high);

            System.out.println("Data after pivot is " + Arrays.toString(data));
            System.out.println("Partition is " + pivot);
            if(pivot > 2) {
                stack.push(low);
                stack.push(pivot);

            }
            if(pivot+1 < high) {
                stack.push(pivot+1);
                stack.push(high);
            }
        }
    }

    static void recursiveQuicksort(double[] data, int low, int high) {
        if(low < high) {
            int pivot = partition(data, low, high);
            recursiveQuicksort(data, low, pivot);
            recursiveQuicksort(data, pivot + 1, high);
        }
    }

    static int partition(double[] data, int low, int high) {
        double pivot = data[low];
        int left = low;
        double cache;
        for(int i = low+1; i < high; i++) {
            if(data[i] < pivot) {
                left += 1;
                cache = data[i];
                data[i] = data[left];
                data[left] = cache;
            }
        }
        cache = data[low];
        data[low] = data[left];
        data[left] = cache;

        return left;
    }
}
