package java;

/**
 * Created by theo on 19/04/16.
 */
public class JumpSearch {


    //http://www.stoimen.com/blog/2011/12/12/computer-algorithms-jump-search/
    //Operates in O(sqrt(n))
    //This can be reduced to O(log(n))), however there is no point, as its implementation is more difficult than binary search
    public static int search(double[] data, double val) {
        int len = data.length;
        int step = (int) Math.floor(Math.sqrt(len));
        int prev = 0;
        while(data[ (step < len ? step : len) ] < val) {
            prev = step;
            step += Math.floor(Math.sqrt(len));
            if(step >= len) {
                return -1;
            }
        }
        while(data[prev] < val) {
            prev++;
            if(prev == (step < len ? step : len)) {
                return -1;
            }
        }

        if(data[prev] == val) {
            return prev;
        }
        return -1;
    }


}
