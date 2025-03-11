import java.util.function.Function;;

public class BackwardDifferenceSystem extends findDifferential{

    public BackwardDifferenceSystem(Function<Double, Double> func, double x) {
        super(func, x);
        super.setName("BackwardDifferenceSystem");
    }

    public BackwardDifferenceSystem(Function<Double, Double> function, double x, double x_del) {
        super(function, x, x_del);
        super.setName("BackwardDifferenceSystem");
    }
    
    @Override
    public void find() {
        double value;

        value = (this.function.apply(this.x) - this.function.apply(this.x - this.x_del)) / (this.x_del) ;

        this.setRes(value);
   }
    
}
