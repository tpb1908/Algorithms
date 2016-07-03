/**
 * Created by theo on 18/04/16.
 */
public class MergeSort implements Test {
    //This is about twice as slow as QuickSort

    @Override
    public void run() {
        for(int i = 1; i < 1E9; i*= 10) {
            double[] data = new double[i];
            for(int j = 0; j < data.length; j++) {
                data[j] = Math.random() * i;
            }
            long start = System.nanoTime();
            recursiveMergeSort(data);
            System.out.println("Time to sort array of " + data.length + " " + (System.nanoTime()-start)/1E9);
        }
    }

//    Time to sort array of 1 3.6309E-5
//    Time to sort array of 10 1.3704E-5
//    Time to sort array of 100 7.0256E-5
//    Time to sort array of 1000 6.83841E-4
//    Time to sort array of 10000 0.003400305
//    Time to sort array of 100000 0.022679466
//    Time to sort array of 1000000 0.223295238
//    Time to sort array of 10000000 2.027351109
//    Time to sort array of 100000000 21.904794275

    static double[] recursiveMergeSort(double[] array ) {
        if(array.length <= 1) {
            return  array;
        }
        double[] left = new double[((array.length+1)/2)]; //Divisor must be float to return a float
        double[] right = new double[array.length/2];
        int lIndex = 0;
        int rIndex = 0;
        for(int i = 0; i < array.length; i++) {
            if((i & 1) == 0) {
                left[lIndex] = array[i];
                lIndex++;
            } else {
                right[rIndex] = array[i];
                rIndex++;
            }
        }
        left = recursiveMergeSort(left);
        right = recursiveMergeSort(right);

        return merge(left, right);

    }

    static double[] merge(double[] left, double[] right) {
        double[] result = new double[left.length + right.length];
        int iLeft = 0;
        int iRight = 0;
        int iResult = 0;

        while(iLeft < left.length && iRight < right.length) {
            if(left[iLeft] < right[iRight]) {
                result[iResult] = left[iLeft];
                iLeft++;
            } else {
                result[iResult] = right[iRight];
                iRight++;
            }
            iResult++;
        }
        while(iLeft < left.length) {
            result[iResult] = left[iLeft];
            iLeft++;
            iResult++;
        }
        while(iRight < right.length) {
            result[iResult] = right[iRight];
            iRight++;
            iResult++;
        }
        return result;
    }
}
