package numericalIntegration;

import java.util.function.Function;
import java.lang.Math;

public class GaussQuadrature extends findIntegral{

    private int n;

    public GaussQuadrature(Function<Double, Double> func) {
        super(func, -1, 1);
        n = 2;
        super.setName("Gauss Quadrature " + n + " level");
    }

    public GaussQuadrature(Function<Double, Double> func, int n) {
        super(func, -1, 1);
        super.setName("Gauss Quadrature " + n + " level");
    }

    @Override
    public void find() {
        double value;

        if(this.n == 2){
            
            value = this.func.apply( -1 * Math.sqrt(1/3)) + this.func.apply(Math.sqrt(1/3));
            this.setRes(value);

        }
        else{

            if(this.n > 3){
                System.out.println(n + "th level not available, Calculating value using n=3");
            }

            value = ((5/9) * this.func.apply( -1 * Math.sqrt(3/5))) + ((8/9) * this.func.apply(0.0)) + ((5/9) * this.func.apply(Math.sqrt(3/5)));
            this.setRes(value);

        }

    }

}
