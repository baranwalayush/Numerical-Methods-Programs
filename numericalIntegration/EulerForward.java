package numericalIntegration;

import java.util.function.Function;

public class EulerForward extends findIntegral{

    public EulerForward(Function<Double, Double> func, double a, double b) {
        super(func, a, b);
        super.setName("EulerForward");
    }

    @Override
    public void find(){
        double value;

        value = (this.func.apply(b) * (b - a));

        this.setRes(value);
    }
    
}
