import java.util.function.Function;;

public class CenralDifferenceSystem extends findDifferential{

    public CenralDifferenceSystem(Function<Double, Double> function, double x) {
        super(function, x);
        super.setName("CenralDifferenceSystem");
    }

    public CenralDifferenceSystem(Function<Double, Double> function, double x, double x_del) {
        super(function, x, x_del);
        super.setName("CenralDifferenceSystem");
    }
    
    @Override
    public void find() {
        double value;

        value = (this.function.apply(this.x + this.x_del) - this.function.apply(this.x - this.x_del)) / (2 * this.x_del) ;

        this.setRes(value);
    }
    
}
