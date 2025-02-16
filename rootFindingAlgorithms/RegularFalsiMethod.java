import java.util.function.Function;

class RegularFalsiMethod{

    // Parameters
    // a & b are the intial points with opposite value of func(x) and b>a
    // tolerance is the allowed difference value between a & b
    // maxIterations is the maximum number of iterations allowed
    // func is the function for which root is to be finded

    private double a, b, tolerance;
    private int maxIterations;
    Function<Double, Double> function;

    // Constructor
    public RegularFalsiMethod(Function<Double, Double> func, double a, double b, double tolerance, int maxIterations){
        this.function = func;
        this.a = a;
        this.b = b;
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    // Implement the Regular-Falsi Method
    public double findRoot(){

        double x2 = (a + b) / 2;
        int iteration = 0;

        if (function.apply(a) * function.apply(b) >= 0) {
            throw new IllegalArgumentException("Invalid range: f(a) and f(b) must have opposite signs.");
        }

        while(Math.abs(b - a) >= tolerance && iteration < maxIterations){

            x2 = (a*function.apply(b) - b*function.apply(a)) / (function.apply(b) - function.apply(a));
            double fx2 = function.apply(x2);

            if (fx2 == 0.0) {
                break; // Found exact root or within tolerance
            }

            if (function.apply(a) * fx2 < 0) {
                b = x2; 
            } else {
                a = x2;
            }

            iteration++;
        }

        return x2;
    }

    public static void main(String[] args) {
        Function<Double, Double> func = x -> Math.cos(x) + 2*x;
        RegularFalsiMethod solver = new RegularFalsiMethod(func, -1, 2, 0.0001, 100);
        double root = solver.findRoot();
        System.out.println("Root found at: " + root);
    }
}