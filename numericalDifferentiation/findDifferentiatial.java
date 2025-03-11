import java.util.function.Function;

abstract class findDifferential {

    protected Function<Double, Double> function;
    protected double x;
    protected double x_del;
    private double res;
    private String name;

    public findDifferential(Function<Double, Double> function, double x){
        this.function = function;
        this.x = x;
        x_del = 1;
    }

    public findDifferential(Function<Double, Double> function, double x, double x_del){
        this.function = function;
        this.x = x;
        this.x_del = x_del;
    }

    public double getRes(){
        return res;
    }

    public void setRes(double val){
        this.res = val;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void find();

    public void printResult(){
        System.out.println("The value of differential of the given function at " + x + " using " + name + " method is " + res );
    }

    


}