/**
 * Created by pearson-brayt15 on 24/03/2016.
 */
public class Operand extends ExpressionNode {
    private double value;

    public Operand(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double value() {
        return value;
    }
}
