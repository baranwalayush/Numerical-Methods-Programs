import java.util.function.Function;

class SecantMethod{

    // Parameters
    // x0 & x1 are the intial points with opposite value of func(x)
    // tolerance is the allowed difference value between a & b
    // maxIterations is the maximum number of iterations allowed
    // func is the function for which root is to be finded

    private double x0, x1, tolerance;
    private int maxIterations;
    Function<Double, Double> function;

    // Constructor
    public SecantMethod(Function<Double, Double> func, double x0, double x1, double tolerance, int maxIterations){
        this.function = func;
        this.x0 = x0;
        this.x1 = x1;
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    // Implement the Secant Method
    public double findRoot(){

        double x2 = (x0 + x1) / 2;
        int iteration = 0;

        if (function.apply(x0) * function.apply(x1) >= 0) {
            throw new IllegalArgumentException("Invalid range: f(a) and f(b) must have opposite signs.");
        }

        while(Math.abs(x1 - x0) >= tolerance && iteration < maxIterations){

            x2 = (x0*function.apply(x1) - x1*function.apply(x0)) / (function.apply(x1) - function.apply(x0));
            double fx2 = function.apply(x2);

            if (fx2 == 0.0) {
                break; // Found exact root or within tolerance
            }

            x0=x1;
            x1=x2;

            iteration++;
        }

        return x2;
    }

    public static void main(String[] args) {
        Function<Double, Double> func = x -> Math.cos(x) + 2*x;
        SecantMethod solver = new SecantMethod(func, -1, 2, 0.0001, 100);
        double root = solver.findRoot();
        System.out.println("Root found at: " + root);
    }
}