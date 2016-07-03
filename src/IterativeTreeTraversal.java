import java.util.Random;
import java.util.Stack;

/**
 * Created by theo on 18/04/16.
 */
public class IterativeTreeTraversal implements Test {
    static Node root;
    static Random r = new Random();

    @Override
    public void run() {
        this.root = new Node(r.nextInt(100));
        createRandomTree(root, 100, 100);
        System.out.println(traverse());
    }

    private int traverse() {
        int sum = 0;
        Stack<Node> s = new Stack<>();
        Node c = root;
        if(c != null) {
            s.push(c);
            while (!s.empty()) {
                sum += c.getValue();
                if(c.right != null) {
                    s.push(c.right);
                }
                c = c.left != null ? c.left : s.pop();
            }
            return sum;
        } else {
            return sum;
        }
    }


    private void createRandomTree(Node start, int size, int valueRange) {
        if(size == 0) {
            return;
        }
        int shape = r.nextInt(10);
        if(shape < 1) {
            start.left = null;
            start.right = null;
        } else if(shape > 1 && shape < 5){
            if(r.nextBoolean()) {
                start.left  = new Node(r.nextInt(valueRange));
                createRandomTree(start.left, size-1, valueRange);
            } else {
                start.right = new Node(r.nextInt(valueRange));
                createRandomTree(start.right, size -1, valueRange);
            }
        } else if(shape > 5) {
            start.left  = new Node(r.nextInt(valueRange));
            start.right  = new Node(r.nextInt(valueRange));
            createRandomTree(start.left, size -1, valueRange);
            createRandomTree(start.right, size -2, valueRange);
        }
    }
}
