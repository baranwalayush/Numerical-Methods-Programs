package numericalIntegration;

import java.util.function.Function;

abstract public class findIntegral {
    
    protected Function<Double, Double> func;
    protected double a;
    protected double b;
    private String name;
    private double res;

    public void setRes(double res) {
        this.res = res;
    }

    public findIntegral(Function<Double, Double> func, double a, double b) {
        this.func = func;
        this.a = a;
        this.b = b;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void find();

    public void printResult(){
        System.out.println("The integral of the given function from " + a + " to " + b + " using " + name + " method is " + res);
    }

    

}
