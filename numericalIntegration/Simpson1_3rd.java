package numericalIntegration;

import java.util.function.Function;

public class Simpson1_3rd extends findIntegral{

    public Simpson1_3rd(Function<Double, Double> func, double a, double b) {
        super(func, a, b);
        super.setName("Simpson's 1/3rd");
    }

    @Override
    public void find() {
        
        double value, h;

        h = (this.b - this.a) / 2;

        value = ((h / 3) * (this.func.apply(this.a) + (4 * this.func.apply(this.a + h)) + this.func.apply(this.b)));

        this.setRes(value);
    }
}
