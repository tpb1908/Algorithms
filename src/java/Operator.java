package java;

/**
 * Created by pearson-brayt15 on 24/03/2016.
 */
public class Operator extends ExpressionNode {
    private char operator;

    public Operator(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    @Override
    public double value() {
        switch (operator) {
            case '^':
                return Math.pow(left.value(), right.value());
            case '/':
                return left.value() / right.value();
            case '*':
                return  left.value() * right.value();
            case '+':
                return  left.value() + right.value();
            case '-':
                return left.value() - right.value();
            default:
                return Double.NaN; //Invalid operator
        }
    }
}
