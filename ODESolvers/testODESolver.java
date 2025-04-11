import java.util.Scanner;

public class testODESolver {
    public static void main(String[] args) {

        // Define ODE: dy/dt = f(t, y)
        System.out.println("Solving dy/dt = y");
        ODEFunction function = (t, y) -> y;

        double t0 = 2;
        double y0 = 7.38;
        double tEnd = 4.0;
        double h = 0.5;
        
        System.out.println("\nUsing Euler's Method");
        ODESolver solver1 = new EulerMethod(function);

        double[] result1 = solver1.solve(t0, y0, tEnd, h);

        System.out.println("\nTime\tValue");
        double t = t0;
        for (double val : result1) {
            System.out.printf("%.4f\t%.6f%n", t, val);
            t += h;
        }


        System.out.println("\nUsing Heun's Method");
        ODESolver solver2 = new HeunMethod(function);

        double[] result2 = solver2.solve(t0, y0, tEnd, h);

        System.out.println("\nTime\tValue");
        t = t0;
        for (double val : result2) {
            System.out.printf("%.4f\t%.6f%n", t, val);
            t += h;
        }

    }
}
