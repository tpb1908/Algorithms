/**
 * Created by theo on 19/04/16.
 */
public class JumpSearch implements Test {

    @Override
    public void run() {
        System.out.println(search(new double[] {1,2,3,4,5,6,7,8,9}, 3));
    }

    //http://www.stoimen.com/blog/2011/12/12/computer-algorithms-jump-search/
    //Operates in O(sqrt(n))
    //This can be reduced to O(log(n))), however there is no point, as its implementation is more difficult than binary search
    static int search(double[] data, double val) {
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
