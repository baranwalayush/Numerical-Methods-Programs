package numericalIntegration;

import java.util.function.Function;

public class Simpson3_8th extends findIntegral{

    public Simpson3_8th(Function<Double, Double> func, double a, double b) {
        super(func, a, b);
        super.setName("Simpson's 3/8th");
    }

    @Override
    public void find() {
        
        double value, h;

        h = (this.b - this.a) / 3;

        value = (((3 * h) / 8) * (this.func.apply(this.a) + (3 * this.func.apply(this.a + h)) + (3 * this.func.apply(this.a + (2 * h))) + this.func.apply(this.b)));

        this.setRes(value);
    }

    
    
}
