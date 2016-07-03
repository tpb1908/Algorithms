import java.util.Random;

/**
 * Created by theo on 18/04/16.
 */
public class ExpressionTreeParser implements Test {
    static ExpressionNode root;
    static Random r = new Random();

    @Override
    public void run() {
        root = new Operator('*');
        root.left = new Operator('/');
        root.left.left = new Operand(21);
        root.left.right = new Operand(7);

        root.right = new Operator('+');
        root.right.left = new Operand(3);
        root.right.right = new Operand(7);

        System.out.println(root.value());
    }

    static void evaluateString(String expr) {

    }
}
