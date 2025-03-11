import java.util.function.Function;

class ForwardDifferenceSystem extends findDifferential{

    public ForwardDifferenceSystem(Function<Double, Double> func, double x) {
        super(func, x);
        super.setName("ForwardDifferenceSystem");
    }

    public ForwardDifferenceSystem(Function<Double, Double> function, double x, double x_del) {
        super(function, x, x_del);
        super.setName("ForwardDifferenceSystem");
    }

    @Override
    public void find() {
        double value;

        value = (this.function.apply(this.x + this.x_del) - this.function.apply(this.x)) / (this.x_del) ;

        this.setRes(value);
    }

}
