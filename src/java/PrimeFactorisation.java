package java;

import org.apfloat.Apint;
import org.apfloat.ApintMath;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by theo on 16/04/16.
 */
public class PrimeFactorisation implements Test {

    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter some monstrous number:\n");
        String num = s.nextLine();
        long start = System.nanoTime();
        try {
            long val = Long.parseLong(num);
            System.out.println(primeFactors(val));
            System.out.println("Time taken " + (System.nanoTime()-start)/1E9);
        } catch (NumberFormatException n) {
            BigInteger val = new BigInteger(num);
            System.out.println("Using a BigInteger, this may take some time");
            System.out.println(primeFactors(val));
            System.out.println("Time taken " + (System.nanoTime()-start)/1E9);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    static ArrayList<Long> primeFactors(long n) {
        ArrayList<Long> factors = new ArrayList<>();
        while(n%2 == 0) { //Eliminating the even factor
            factors.add(2L);
            n /= 2;
        }
        //Finding the other prime factors
        for(int i = 3; i <= Math.sqrt(n); i += 2) {
            while(n%i == 0) {
                factors.add((long)i);
                n /= i;
            }
        }
        if(n > 2) { //n is a prime
            factors.add(n);
        }
        return factors;
    }

    //Even slower than BigInteger ~35 times slower
    static ArrayList<Apint> primeFactors(Apint n) {
        ArrayList<Apint> factors = new ArrayList<>();
        Apint two = new Apint(2);
        while(n.mod(two).equals(Apint.ZERO)) {
            factors.add(two);
            n = n.divide(two);
        }

        for(Apint i = new Apint(3); i.compareTo(ApintMath.sqrt(n)[0]) < 0; i = i.add(two)) {
            while(n.mod(i).equals(Apint.ZERO)) {
                factors.add(i);
                n = n.divide(i);
            }
        }
        if(n.compareTo(two) > 0) {
            factors.add(n);
        }
        return factors;
    }

    //Horribly slow, but that's just BigIntegers
    static ArrayList<BigInteger> primeFactors(BigInteger n) {
        ArrayList<BigInteger> factors = new ArrayList<>();
        BigInteger two = BigInteger.valueOf(2);
        while(n.mod(two).equals(BigInteger.ZERO)) {
            factors.add(two);
            n = n.divide(two);
        }

        for(BigInteger i = BigInteger.valueOf(3); i.compareTo(sqrt(n)) < 0; i = i.add(two) ) {
            while(n.mod(i).equals(BigInteger.ZERO)) {
                factors.add(i);
                n = n.divide(i);
            }
        }

        if(n.compareTo(two) > 0) {
            factors.add(n);
        }
        return factors;
    }


    //http://stackoverflow.com/a/16804098/4191572
    //This is some witchcraft
    static BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        // Loop until we hit the same value twice in a row, or wind
        // up alternating.
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }
}
