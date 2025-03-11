import java.util.function.Function;

class ThreePointForwardDifferenceSystem extends findDifferential{

    public ThreePointForwardDifferenceSystem(Function<Double, Double> func, double x) {
        super(func, x);
        super.setName("ThreePointForwardDifferenceSystem");
    }

    public ThreePointForwardDifferenceSystem(Function<Double, Double> function, double x, double x_del) {
        super(function, x, x_del);
        super.setName("ThreePointForwardDifferenceSystem");
    }

    @Override
    public void find() {
        double value;

        value = (4 * this.function.apply(this.x + this.x_del) - (3 * this.function.apply(this.x)) - this.function.apply(this.x + 2 * this.x_del)) / (this.x_del * 2) ;

        this.setRes(value);
    }

    

}
