package numericalIntegration;

import java.util.function.Function;

public class EulerBackward extends findIntegral{

    public EulerBackward(Function<Double, Double> func, double a, double b) {
        super(func, a, b);
        this.setName("EulerBackward");
    }

    @Override
    public void find(){
        double value;

        value = (this.func.apply(a) * (b - a));

        this.setRes(value);
    }
    
}
