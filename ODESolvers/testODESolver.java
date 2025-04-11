import java.util.Scanner;

public class testODESolver {
    public static void main(String[] args) {

        // Define ODE: dy/dt = f(t, y)
        System.out.println("Solving dy/dt = y");
        ODEFunction function = (t, y) -> y;

        double t0 = 2;
        double y0 = 7.38;
        double tEnd = 5.0;
        double h = 0.5;
        
        System.out.println("Using Euler's Method");
        ODESolver solver = new EulerMethod(function);

        double[] result = solver.solve(t0, y0, tEnd, h);

        System.out.println("\nTime\tValue");
        double t = t0;
        for (double val : result) {
            System.out.printf("%.4f\t%.6f%n", t, val);
            t += h;
        }

    }
}
