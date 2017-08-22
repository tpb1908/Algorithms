package java;

/**
 * Created by theo on 23/04/16.
 */
public class QuickSelect {

    public void run() {
        double[] data = new double[] {5,7};
        System.out.println(select(data, 6));
    }

    /**
     * Finds the nth smallest value in the data
     * @param data The dataset for which to find the nth smallest value
     * @param n The value for which to find the smallest value, indexed from 0
     * @return The nth smallest value
     */
    public static double select(double[] data, int n) {
        int left = 0;
        int right = data.length-1;
        //If n is greater than the size of the dataset, find the largest value
        if(n > data.length) {
            n = data.length -1;
        }
        for(;;) {
            if (left == right) {
                return data[left];
            }
            int pivot = left + (int) (Math.random() * (right - left + 1));
            pivot = partition(data, left, right, pivot);
            if (n == pivot) {
                return data[n];
            } else if (n < pivot) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
    }

    public static int partition(double[] data, int left, int right, int pivot) {
        double pivotValue = data[pivot];
        int storeIndex = left;
        swap(data, pivot, right);
        for(int i = left; i < right; i++) {
            if(data[i] < pivotValue) {
                swap(data, storeIndex, i);
                storeIndex++;
            }
        }
        swap(data, right, storeIndex);
        return storeIndex;
    }

    public static void swap(double[] data, int p1, int p2) {
        double c = data[p1];
        data[p1] = data[p2];
        data[p2] = c;
    }


}
