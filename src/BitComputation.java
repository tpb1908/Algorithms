/**
 * Created by theo on 18/04/16.
 */
public class BitComputation implements Test {
    /*
        Operators
            &   bitwise and, copies a bit to the result if it exists in both operands
            |   bitwise or, copies a bit to the result if it exists in either operand
            ^   bitwise xor, copies a bit to the result if it is set in only one operand
            ~   bitwise compliment, flips all of the bits in a value
            <<  left shift, the left operands value is moved to the left by the number specified
            >>  right shift, the left operands value is moved to the right by the number specified
            >>> zero fill right shift, the left operands value is moved right by the number of bits specified by
            the right operand and the shifted values are filled up with zeros.
            In a normal right shift, these positions would be filled with the sign bit
     */
    @Override
    public void run() {

    }

    //Checks if the first position is false, hence the value is even
    static boolean isEven(long num) {
        return (num & 1) == 0;
    }

    //Returns true if the bit of num at position n is true
    static boolean isSet(long num, int n) {
        return ((num & (1L<<n)) !=0);
    }

    //Sets the bit at position n to true
    static long setNthBit(long num, int n) {
        return num | (1<<n);
    }

    //Sets the nth bit to false
    static long unsetNthBit(long num, int n) {
        return num &-(1<<n);
    }

    //Toggles the value of the nth bit
    static long toggleNthBit(long num, int n) {
        return num ^ (1<<n);
    }

    //Counts the number of true binary digits
    static int countTrueBinaryDigits(long num) {
        int count = 0;
        while(num > 0) {
            count++;
            //Setting the least significant true bit to false
            num &= (num-1);
        }
        return count;
    }

    //Finds the rightmost true bit and sets all of the others to false
    static long isolateRightTrueBit(long num) {
        return  num & (-num);
    }

    //Find the rightmost false bit and sets all of the others to true
    static long isolateRightFalseBit(long num) {
        return -num & (num-1);
    }

    //All the false bits to the right of the righmost true bit are set to true
    static long rightPropogate(long num) {
        return num | (num-1);
    }

    //Changes the rightmost false bit to true
    static long setRightFalseTrue(long num) {
        return num | (num+1);
    }


}
