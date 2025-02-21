import java.util.function.Function;

class BisectionMethod {

    // Parameters:
    // a & b are the initial points with opposite value of func(x) and b>a
    // tolerance is the allowed difference value between a & b
    // maxIterations is the maximum number of iterations allowed
    // func is the function for which root is to be finded

    private double a, b, tolerance;
    private int maxIterations;
    Function<Double, Double> function;
    public BisectionMethod(double a, double b, double tolerance, int maxIterations, Function<Double, Double> func) {
        this.a = a;
        this.b = b;
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
        this.function = func;
    }

    // Implement the bisection method
    public double findRoot() {
        double mid = (a + b) / 2;
        int iteration = 0;

        if (function.apply(a) * function.apply(b) >= 0) {
            throw new IllegalArgumentException("Invalid range: f(a) and f(b) must have opposite signs.");
        }

        while (Math.abs(b - a) >= tolerance && iteration < maxIterations) {
            mid = (a + b) / 2;
            double fMid = function.apply(mid);

            if (fMid == 0.0 || Math.abs(b - a) < tolerance) {
                break; // Found exact root or within tolerance
            }

            if (function.apply(a) * fMid < 0) {
                b = mid; 
            } else {
                a = mid;
            }

            iteration++;
        }

        return mid;
    }

    public static void main(String[] args) {

        // Function<Double, Double> func = x -> x*x - 10*x + 9;
        // BisectionMethod solver = new BisectionMethod(5, 10, 0.0001, 100, func);

        Function<Double, Double> func = x -> 2 - x + Math.log(x);
        BisectionMethod solver = new BisectionMethod(1, 4, 0.0001, 100, func);
        double root = solver.findRoot();
        System.out.println("Root found at: " + root);
    }
}
