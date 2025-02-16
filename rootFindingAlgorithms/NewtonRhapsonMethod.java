import java.util.function.Function;

class NewtonRhapsonMethod{

    // Parameters
    // x0 is an initial value of x for which the f(x0) is close to zero
    // tolerance is the allowed difference value between actual root and solution
    // maxIterations is the maximum number of iterations allowed
    // func is the function for which root is to be finded
    // derivFunc is the derivation of func
    private double x0, tolerance;
    private int maxIterations;
    Function<Double, Double> function;
    Function<Double, Double> derivFunction;

    // Constructor
    public NewtonRhapsonMethod(Function<Double, Double> func, Function<Double, Double> derivFunc, double x0, double tolerance, int maxIterations){
        this.x0 = x0;
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
        this.function = func;
        this.derivFunction = derivFunc;
    }

    // Implement Newton-Rhapson Method
    public double findRoot(){

        double h = (function.apply(x0) / derivFunction.apply(x0));
        double x1 = x0 - h;

        int iteration = 0;

        while(h >= tolerance && iteration < maxIterations){

            if(function.apply(x1) == 0){
                break; // root found
            }

            h = (function.apply(x1) / derivFunction.apply(x1));
            x1 = x1 - h;

            iteration++;
        }

        return x1;
    }

    public static void main(String[] args){
        Function<Double, Double> func = x -> x*x - 10*x + 9;
        Function<Double, Double> derivFunc = x -> 2*x - 10;
        NewtonRhapsonMethod solver = new NewtonRhapsonMethod(func, derivFunc, 11, 0.0001, 100);
        double root = solver.findRoot();
        System.out.println("Root found at: " + root);
    }

}