/**
 * Created by theo on 18/04/16.
 */
public class Node {
    Node left;
    Node right;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}