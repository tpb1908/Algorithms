/**
 * Created by theo on 23/04/16.
 */
public class FibonacciSearch implements Test {

    @Override
    public void run() {
        double[] data = new double[] {1,2,3,4,5,6,7,8,9};
        System.out.println(fibSearch(data, 2));
    }

    /*
        Algorithm-
        Let the searched element be x
        Find the smallest Fibonacci number that is greater than or equal to the
        length of the dataset
        Let the found found number be fib(m'th fibonacci number)
        We use the (m-2)'th fibonacci number as index (If it is valid)
        Let the (m-2)'th Fibonacci number be i, we compare data[i] with x.
        If x is the same, we return i. Otherwise we check if x is greater, and recur for
        the subarray after i, otherwise recur for the subarray before i

        Complexity-
        fibSearch operates in log(n) time
        approximately (1/sqrt(5))((1+sqrt(5))/2)^n  ~ c*1.62^n
        The worst case will occur when the target is in the larger 2/3 fraction of the array
        Useful different between it and other algorithms is that it doesn't use division,
        other than once to find n
     */

    public int fibSearch(double[] data, int x) {
        int n = (int) (data.length/data[0]);
        int fibm2 = 0;
        int fibm1 = 1;
        int fib = fibm1 + fibm2;

        //Consider caching these values
        //fibM stores the smallest fibonacci number greater than or equal to n
        while(fib < n) {
            fibm2 = fibm1;
            fibm1 = fib;
            fib = fibm2 + fibm1;
        }

        int offset = -1; //The range eliminated from the fron

        //While there are elements to be inspected
        while(fib > 1) {
            //Check if fibm2 is a valid loaction
            int i = Math.min(offset + fibm2, n-1);

            //If x is greater, cut the subarray from offset to i
            if(data[i] < x) {
                fib = fibm1;
                fibm1 = fibm2;
                fibm2 = fib - fibm1;
                offset = i;
            } else if(data[i] > x) { //Cut the subarray after i+1
                fib = fibm2;
                fibm1 -= fibm2;
                fibm2 = fib -fibm1;
            } else {
                return  i;
            }
        }
        //If there is one element left
        if(fibm1 == x && data[offset+1] == x) {
            return  offset+1;
        }
        return  -1;
    }
	
	public int[] values(int num) {
		final int[] values = new int[(int)(Math.log10(n)+1)];
		int i = 0;
		while(num > 0) {
			values[i++] = num%10;
			num /= 10;
		}
		return values;
	}
	

}
