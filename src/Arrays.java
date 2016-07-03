import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by pearson-brayt15 on 26/05/2016.
 */
public class Arrays {
    String[] strings;
    ArrayList<Integer> integerList;
    ArrayList<Double> doubleList;
    ArrayList<String> stringList;

    public Arrays() {
        byte[] byteArray;
        short[] shortArray;
        int[] numbers;
        long[] longNumbers;
        float[] floatingArray;
        double[] floatingPointNumbers;

        integerList = new ArrayList<>(10);
        for(int j = 0; j < 10; j++) {
            integerList.add((int) (Math.random() * 50));
        }
        for(int j : integerList) {
            System.out.println(j);
        }
        integerList.set(3, 5);
        System.out.println(integerList.get(3));

    }

    public static void main(String[] args) {
        new Arrays();
    }


}
