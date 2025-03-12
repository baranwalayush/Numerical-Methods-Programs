package numericalIntegration;

import java.util.function.Function;

public class TrapezoidalRule extends findIntegral{

    public TrapezoidalRule(Function<Double, Double> func, double a, double b) {
        super(func, a, b);
        this.setName("Trapezoidal");
    }

    @Override
    public void find(){
        double value;

        value = ((this.func.apply(a) + this.func.apply(b)) * (b - a)) / 2;

        this.setRes(value);
    }
    
}
